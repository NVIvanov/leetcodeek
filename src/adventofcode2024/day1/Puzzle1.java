package adventofcode2024.day1;

import java.util.*;

public class Puzzle1 {

    private static final IdReader idReader = new IdReader();

    public long findDistance() {
        List<Queue<Integer>> queues = idReader.readData("puzzle1.txt", Comparator.naturalOrder());
        long distance = 0;
        while (!queues.get(0).isEmpty()) {
            distance += Math.abs(queues.get(0).poll() - queues.get(1).poll());
        }
        return distance;
    }

    public static void main(String[] args) {
        System.out.println(new Puzzle1().findDistance());
    }
}
