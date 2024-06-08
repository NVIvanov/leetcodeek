import java.util.Comparator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;

public class RoundRobin {
    private final Integer maxQuantumTime;
    private final BlockingQueue<Process> processes = new PriorityBlockingQueue<>(10,
            Comparator.comparingInt(Process::arrivingTime));
    private Integer currentQuantum = 0;

    public RoundRobin(Integer maxQuantumTime) {
        this.maxQuantumTime = maxQuantumTime;
    }

    public void schedule(Process process) {
        processes.add(process);
    }

    public static void main(String[] args) {
        Process[] processes = new Process[]{
                new Process(1, 0, 5),
                new Process(2, 1, 3),
                new Process(3, 2, 4),
                new Process(4, 5, 5),
                new Process(5, 6, 3)
        };
        RoundRobin roundRobin = new RoundRobin(3);
        for (Process p: processes) {
            roundRobin.schedule(p);
        }
        roundRobin.execute();
    }

    public void execute() {
        try {
            Process nextProcess = processes.poll(30, TimeUnit.SECONDS);
            while (nextProcess != null) {
                System.out.println(nextProcess);
                currentQuantum += Math.min(maxQuantumTime, nextProcess.quantumWeight);
                if (maxQuantumTime < nextProcess.quantumWeight) {
                    schedule(new Process(nextProcess.pid, currentQuantum, nextProcess.quantumWeight - maxQuantumTime));
                }
                System.out.println("process pid=" + nextProcess.pid + "; spent=" +
                        Math.min(maxQuantumTime, nextProcess.quantumWeight) + "; currentQ=" + currentQuantum);
                nextProcess = processes.poll(5, TimeUnit.SECONDS);
            }
            System.out.println("Execution finished");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public record Process(
            Integer pid,
            Integer arrivingTime,
            Integer quantumWeight
    ){}
}
