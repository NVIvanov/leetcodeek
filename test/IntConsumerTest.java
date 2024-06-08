import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;

public class IntConsumerTest {

    @Test
    public void test5of100() {
        IntConsumer consumer = new IntConsumer(5);
        var numbers = fillWithNumbers(consumer, 100).stream().limit(5).toList();;
        var consumed = consumer.top();
        Assertions.assertIterableEquals(numbers, consumed);
    }

    @Test
    public void test5of3() {
        IntConsumer consumer = new IntConsumer(5);
        var numbers = fillWithNumbers(consumer, 3);
        var consumed = consumer.top();
        Assertions.assertIterableEquals(numbers, consumed);
    }

    @Test
    public void test0of0() {
        IntConsumer consumer = new IntConsumer(0);
        var numbers = fillWithNumbers(consumer, 0);
        var consumed = consumer.top();
        Assertions.assertIterableEquals(numbers, consumed);
    }

    @Test
    public void test5of100Concurrently() throws ExecutionException, InterruptedException {
        IntConsumer consumer = new IntConsumer(5);
        var numbers = fillWithNumbersConcurrently(consumer, 100).stream().limit(5).toList();
        var consumed = consumer.top();
        Assertions.assertIterableEquals(numbers, consumed);
    }

    @Test
    public void test1000of1000000Concurrently() throws ExecutionException, InterruptedException {
        IntConsumer consumer = new IntConsumer(1000);
        var numbers = fillWithNumbersConcurrently(consumer, 1000000).stream().limit(1000).toList();
        var consumed = consumer.top();
        Assertions.assertIterableEquals(numbers, consumed);
    }

    @Test
    public void test5of3Concurrently() throws ExecutionException, InterruptedException {
        IntConsumer consumer = new IntConsumer(5);
        var numbers = fillWithNumbersConcurrently(consumer, 3);
        var consumed = consumer.top();
        Assertions.assertIterableEquals(numbers, consumed);
    }

    private List<Integer> fillWithNumbers(IntConsumer consumer, Integer range) {
        var list = new Random().ints(range).boxed().toList();
        list.forEach(consumer::consume);
        return list.stream().sorted(Comparator.reverseOrder()).toList();
    }

    private List<Integer> fillWithNumbersConcurrently(IntConsumer consumer, Integer range) throws InterruptedException, ExecutionException {
        var executorService = Executors.newFixedThreadPool(10);
        var completionService = new ExecutorCompletionService<Integer>(executorService);
        for (int i = 0; i < range; i++) {
            completionService.submit(() -> {
                var value = ThreadLocalRandom.current().nextInt();
                consumer.consume(value);
                return value;
            });
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < range; i++) {
            result.add(completionService.take().get());
        }
        return result.stream().sorted(Comparator.reverseOrder()).toList();
    }
}
