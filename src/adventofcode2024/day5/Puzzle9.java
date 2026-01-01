package adventofcode2024.day5;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

public class Puzzle9 {


    public static void main(String[] args) throws FileNotFoundException {
        Map<Integer, Set<Integer>> edges = new HashMap<>();
        List<List<Integer>> lines = new ArrayList<>();

        try (Scanner in = new Scanner(new FileInputStream("puzzle9.txt"))) {
            while (in.hasNextLine()) {
                String line = in.nextLine();
                if (line.isEmpty()) {
                    break;
                }
                String[] tokens = line.split("\\|");
                edges.computeIfAbsent(Integer.parseInt(tokens[0]), k -> new HashSet<>()).add(Integer.parseInt(tokens[1]));
            }

            while (in.hasNextLine()) {
                String line = in.nextLine();
                lines.add(Arrays.stream(line.split(",")).map(Integer::parseInt).collect(Collectors.toList()));
            }
        }

        System.out.println(lines);

        System.out.println(edges);

        long medianSum = 0;
        for (var line: lines) {
            Set<Integer> nextPossible = new HashSet<>(edges.keySet());
            boolean eligible = true;
            for (var num: line) {
                if (!nextPossible.contains(num)) {
                    eligible = false;
                    break;
                } else {
                    nextPossible.clear();
                    nextPossible.addAll(edges.get(num));
                }
            }
            if (eligible) {
                medianSum += line.get(line.size() / 2);
                System.out.println(medianSum);
            }
        }
    }

}
