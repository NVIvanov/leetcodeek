import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class ReallySimpleRoundRobin implements Iterator<String> {
    private final CopyOnWriteArrayList<String> hosts;
    private final AtomicInteger index = new AtomicInteger(0);

    public ReallySimpleRoundRobin(List<String> hosts) {
        this.hosts = new CopyOnWriteArrayList<>(hosts);
    }

    public void addNewHost(String host) {
        hosts.add(host);
    }

    @Override
    public boolean hasNext() {
        return true;
    }

    @Override
    public String next() {
        while (true) {
            var currentIndex = index.get();
            var nextIndex = currentIndex + 1;
            if (nextIndex >= hosts.size()) {
                nextIndex = 0;
            }
            if (index.compareAndSet(currentIndex, nextIndex)) {
                return hosts.get(currentIndex);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        var roundRobin = new ReallySimpleRoundRobin(List.of("host1", "host2", "host3", "host4"));

        var executor = Executors.newFixedThreadPool(10);
        var completionService = new ExecutorCompletionService<String>(executor);
        var tasks = new ArrayList<Callable<String>>();

        for (int i = 0; i < 1000 * 4; i++) {
            tasks.add(roundRobin::next);
        }

        tasks.forEach(completionService::submit);

        List<String> results = new ArrayList<>();

        for (int i = 0; i < 1000 * 4; i++) {
            var result = completionService.take();
            results.add(result.get());
        }

        var stat = results.stream()
                .collect(Collectors.toMap(
                        s -> s,
                        s -> 1,
                        Integer::sum
                ));

        System.out.println(stat);

        executor.shutdown();
    }
}
