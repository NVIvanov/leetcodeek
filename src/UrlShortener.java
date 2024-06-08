import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

public class UrlShortener {
    private final Random rand = new Random();
    private final int length;
    private final char[] chars;
    private final Map<String, String> longToShort = new ConcurrentHashMap<>();
    private final Map<String, String> shortToLong = new HashMap<>();

    public UrlShortener(int length) {
        this.length = length;
        chars = new char[62]; // 26 + 26 + 10 == 62 (A-Z a-z 0-9
        int j = 0;
        for (char i = 0; i < 256; i++) {
            if ((i >= '0' && i <= '9') || (i >= 'a' && i <= 'z') || (i >= 'A' && i <= 'Z')) {
                chars[j] = i;
                j++;
            }
        }
    }

    // https://google.com -> something
    public String shorten(String longUrl) {
        return longToShort.computeIfAbsent(longUrl, this::updateKey);
    }

    private String updateKey(String longUrl) {
        StringBuilder sb = new StringBuilder();
        boolean flag = true;
        while (flag) {
            for (int i = 0; i < length; i++) {
                sb.append(chars[rand.nextInt(62)]);
            }
            if (!shortToLong.containsKey(sb.toString())) {
                flag = false;
            }
        }
        shortToLong.put(sb.toString(), longUrl);
        return sb.toString();
    }

    public String expand(String shortUrl) {
        return shortToLong.get(shortUrl);
    }

    public static void main(String[] args) throws InterruptedException {
        UrlShortener u = new UrlShortener(5);

        var executorService = Executors.newFixedThreadPool(100);

        List<Callable<String>> tasks = new ArrayList<>();
        for (int i = 0; i <= 10000; i++) {
            tasks.add(() -> u.shorten("google.com"));
        }
        Set<String> results = new HashSet<>();
        executorService.invokeAll(tasks)
                .stream().map(f -> {
                    try {
                        return f.get();
                    } catch (InterruptedException | ExecutionException e) {
                        throw new RuntimeException(e);
                    }
                }).forEach(results::add);

        System.out.println(results);
        executorService.shutdown();
    }
}
