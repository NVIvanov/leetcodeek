import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class IntConsumer {
    private final Integer capacity;
    private final ConcurrentSkipListSet<Integer> container;
    private final ReadWriteLock lock = new ReentrantReadWriteLock();

    public IntConsumer(Integer capacity) {
        this.capacity = capacity;
        this.container = new ConcurrentSkipListSet<>(Comparator.reverseOrder());
    }

    public void consume(Integer val) {
        Lock writeLock = lock.writeLock();
        try {
            writeLock.lock();
            container.add(val);
            if (container.size() == capacity + 1) {
                container.remove(container.last());
            }
        } finally {
            writeLock.unlock();
        }
    }

    public List<Integer> top() {
        Lock readLock = lock.readLock();
        try {
            readLock.lock();
            return container.stream().toList();
        } finally {
            readLock.unlock();
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        IntConsumer consumer = new IntConsumer(5);
        new Thread(() -> System.out.println(consumer.top())).start();
        while (in.hasNext()) {
            Integer val = in.nextInt();
            consumer.consume(val);
        }
    }


}
