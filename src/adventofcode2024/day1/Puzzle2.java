package adventofcode2024.day1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Puzzle2 {
    private static final IdReader idReader = new IdReader();

    public Long similarityScore() {
        List<Queue<Integer>> queues = idReader.readData("puzzle1.txt");
        Map<Integer, Integer> meetCount = new HashMap<>();
        Queue<Integer> q1 = queues.get(0);
        Queue<Integer> q2 = queues.get(1);
        while (!q2.isEmpty()) {
            meetCount.merge(q2.poll(), 1, Integer::sum);
        }
        Map<Integer, Integer> score = new HashMap<>();
        long total = 0;
        while (!q1.isEmpty()) {
            total += score.computeIfAbsent(q1.poll(), k -> k * meetCount.getOrDefault(k, 0));
        }
        return total;
    }

    public static void main(String[] args) {
        System.out.println(new Puzzle2().similarityScore());
    }
}
