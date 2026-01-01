package adventofcode2024.day8;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class Puzzle15 {

    public static void main(String[] args) throws FileNotFoundException {

        Map<Character, List<List<Integer>>> map = new HashMap<>();

        int index = 0, columns = 0;
        try (Scanner in = new Scanner(new FileInputStream("puzzle15.txt"))) {
            while (in.hasNextLine()) {
                String line = in.nextLine();
                columns = line.length();
                for (int j = 0; j < line.length(); j++) {
                    char c = line.charAt(j);
                    if (c == '.') {
                        continue;
                    }
                    map.computeIfAbsent(c, k -> new ArrayList<>()).add(List.of(index, j));
                }
                index++;
            }
        }
        int rows = index;

        System.out.println(map);

        Set<List<Integer>> antinodes = new HashSet<>();

        int finalColumns = columns;
        map.forEach((sym, coordinates) -> {
            for (int i = 0; i < coordinates.size(); i++) {
                for (int j = i + 1; j < coordinates.size(); j++) {
                    var first = coordinates.get(i);
                    var second = coordinates.get(j);
                    antinodes.addAll(calculateAntinodes(first.get(0), first.get(1), second.get(0), second.get(1), rows, finalColumns));
                }
            }
        });
        System.out.println(antinodes.stream().sorted(Comparator.<List<Integer>>comparingInt(List::getFirst).thenComparing(List::getLast)).toList());
        System.out.println(antinodes.size());
    }

    /**
     * . . . .
     * . . 2 .
     * . 1 . .
     * . . . .
     */
    private static List<List<Integer>> calculateAntinodes(int x1, int y1, int x2, int y2, int rows, int cols) {
        int dX = x2 - x1;
        int dY = y2 - y1;
        List<List<Integer>> antinodes = new ArrayList<>();
        antinodes.add(List.of(x1, y1));
        antinodes.add(List.of(x2, y2));
        while (x1 - dX >= 0 && y1 - dY >= 0 && x1 - dX < rows && y1 - dY < cols) {
            antinodes.add(List.of(x1 - dX, y1 - dY));
            x1 -= dX;
            y1 -= dY;
        }
        while (x2 + dX >= 0 && y2 + dY >= 0 && x2 + dX < rows && y2 + dY < cols) {
            antinodes.add(List.of(x2 + dX, y2 + dY));
            x2 += dX;
            y2 += dY;
        }
        return antinodes;
    }
}
