import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class RoundRobinMultithread implements Runnable {
    private final Integer maxTime;
    private final BlockingQueue<Process> processes =
            new ArrayBlockingQueue<>(100);

    RoundRobinMultithread(Integer maxTime) {
        this.maxTime = maxTime;
    }

    public void schedule(Process process) throws InterruptedException {
        processes.put(process);
//        System.out.println(process.name + " scheduled");
    }

    public static void main(String[] args) throws InterruptedException {
        var roundRobin = new RoundRobinMultithread(3);
        new Thread(roundRobin).start();
        new Thread(() -> {
            try {
                roundRobin.schedule(new Process("P1", 5));
                Thread.sleep(1000);
                roundRobin.schedule(new Process("P2", 3));
                Thread.sleep(2000);
                roundRobin.schedule(new Process("P3", 6));
                Thread.sleep(2000);
                roundRobin.schedule(new Process("P4", 1));
                Thread.sleep(1000);
                roundRobin.schedule(new Process("P5", 4));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();

    }

    @Override
    public void run() {
        while (true) {
            Process process;
            try {
                process = processes.take();
                var time = Math.min(maxTime, process.time);
                Thread.sleep(1000 * time);
                System.out.println("processed " + process.name + " " + time);
                if (process.time > maxTime) {
                    schedule(new Process(process.name, process.time - maxTime));
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }


    public record Process(String name, Integer time){}
}
