package adventofcode2024.day1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class IdReader {

    public List<Queue<Integer>> readData(String fileName) {
        return readData(fileName, null);
    }

    public List<Queue<Integer>> readData(String fileName, Comparator<Integer> comparator) {
        Queue<Integer> list1 = makeQueue(comparator);
        Queue<Integer> list2 = makeQueue(comparator);
        List<Queue<Integer>> results = new ArrayList<>();
        results.add(list1);
        results.add(list2);

        try (var input = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)))) {
            while (input.ready()) {
                String line = input.readLine();
                List<Integer> twoNumbers = Arrays.stream(line.split("\\s+"))
                        .map(String::trim)
                        .map(Integer::parseInt)
                        .toList();
                list1.add(twoNumbers.get(0));
                list2.add(twoNumbers.get(1));
            }
        } catch (Exception e) {
            System.out.println("Problem reading input file");
            return Collections.emptyList();
        }
        return results;
    }

    private Queue<Integer> makeQueue(Comparator<Integer> comparator) {
        if (comparator == null) {
            return new LinkedList<>();
        }
        return new PriorityQueue<>(comparator);
    }
}
