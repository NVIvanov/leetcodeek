package contest.jan042025;

import java.util.*;

public class Task2 {

    static class TaskManager {


        private final NavigableSet<Task> taskSet = new TreeSet<>(Comparator.<Task>comparingInt(t -> -t.priority).thenComparingInt(t -> -t.taskId));
        private final Map<Integer, Task> taskById = new HashMap<>();

        public TaskManager(List<List<Integer>> tasks) {
            for (List<Integer> task : tasks) {
                Task e = new Task(task.get(0), task.get(1), task.get(2));
                this.taskSet.add(e);
                this.taskById.put(e.taskId, e);
            }
        }

        public void add(int userId, int taskId, int priority) {
            Task e = new Task(userId, taskId, priority);
            taskSet.add(e);
            taskById.put(e.taskId, e);
        }

        public void edit(int taskId, int newPriority) {
            Task task = taskById.get(taskId);
            taskSet.remove(task);
            task.priority = newPriority;
            taskSet.add(task);
        }

        public void rmv(int taskId) {
            taskSet.remove(taskById.remove(taskId));
        }

        public int execTop() {
            if (taskSet.isEmpty()) {
                return -1;
            }
            Task first = taskSet.first();
            taskSet.remove(first);
            taskById.remove(first.taskId);
            return first.userId;
        }

        private static class Task {
            private int userId;
            private int taskId;
            private int priority;

            Task(int userId, int taskId, int priority) {
                this.userId = userId;
                this.taskId = taskId;
                this.priority = priority;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (!(o instanceof Task task)) return false;
                return userId == task.userId && taskId == task.taskId && priority == task.priority;
            }

            @Override
            public int hashCode() {
                return Objects.hash(userId, taskId, priority);
            }
        }
    }

    public static void main(String[] args) {
        TaskManager manager = new TaskManager(List.of(
                List.of(1,101,10),
                List.of(2,102,20),
                List.of(3,103,15)
        ));

        manager.add(4,104,5);

        manager.edit(102, 8);
        System.out.println(manager.execTop());
        manager.rmv(101);
        manager.add(5,105,15);
        System.out.println(manager.execTop());
    }
}
