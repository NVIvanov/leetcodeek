import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.*;

public class CodeExample {
    private DataSource delegate;
    private CodeExample lockService;
    private ScheduledExecutorService executor;

    public void lock(String jobName, Set<String> locks) {
        try {
            for (var lock : locks) {
                createLock(lock);
            }
            for (var lock : locks) {
                lockWithLockInfo(jobName, lock);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void lockWithLockInfo(String jobName, String lock) {
        ScheduledFuture<?> scheduledFuture = executor.scheduleAtFixedRate(() -> {
            String previousLock;
            synchronized (lockService) {
                previousLock = lockService.getPreviousLock(lock);
            }
            System.out.println("job is waiting for lock. previous lock: " + previousLock);
        }, 1000, 1000, TimeUnit.MILLISECONDS);
        lock(lock);
        scheduledFuture.cancel(false);
        synchronized (lockService) {
            lockService.updateLockInfo(lock, jobName);
        }
    }

    private void lock(String lock) {
        System.out.println("obtaining lock");
        try (var connection = delegate.getConnection()) {
            try (var prepatedStatement = connection.prepareStatement("select id from t_data_lock where id = ? for update")) {
                prepatedStatement.setString(1, lock);
                prepatedStatement.execute();
                if (!prepatedStatement.getResultSet().next()) {
                    createLock(lock);
                    lock(lock);
                }
                connection.commit();
            } catch (SQLException e) {
                connection.rollback();
                throw e;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void createLock(String lock) {
        try (var connection = delegate.getConnection()) {
            try (var prepatedStatement = connection.prepareStatement("merge into t_data_lock l " +
                    "using dual on (l.ID = ?) when not matched then insert (ID) values (?)")) {
                prepatedStatement.setString(1, lock);
                prepatedStatement.setString(2, lock);
                prepatedStatement.execute();
                connection.commit();
            } catch (
                    SQLException e) {
                connection.rollback();
                throw new RuntimeException(e);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void updateLockInfo(String lock, String job) {
        try (var connection = delegate.getConnection()) {
            try (var statement = connection.prepareStatement("" +
                    "merge into t_job_data_lock l using dual on (l.ID = ?)" +
                    "when not matched then insert (ID, JOB_NAME) values (?, ?) when matched then" +
                    "update set job_name = ?, last_update_datetime = cast(systimestamp at time zone 'UTC' as timestamp)" +
                    "")) {
                statement.setString(1, lock);
                statement.setString(2, job);
                statement.execute();
                connection.commit();
            } catch (SQLException e) {
                connection.rollback();
                throw new RuntimeException(e);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String getPreviousLock(String lock) {
        List<String> currentLocks = new ArrayList<>();
        try (var connection = delegate.getConnection()) {
            try (var statement = connection.prepareStatement("select id from t_data_lock where id = ?")) {
                statement.setString(1, lock);
                statement.execute();
                while (statement.getResultSet().next()) {
                    currentLocks.add(statement.getResultSet().getString(1));
                }
                connection.commit();
            } catch (SQLException e) {
                connection.rollback();
                throw new RuntimeException(e);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return currentLocks.getFirst();
    }
}
