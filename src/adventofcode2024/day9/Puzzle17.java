package adventofcode2024.day9;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class Puzzle17 {

    public static void main(String[] args) throws FileNotFoundException {
        int[] input;
        try (Scanner scanner = new Scanner(new FileInputStream("puzzle17example.txt"))) {
            input = Arrays.stream(scanner.nextLine().split("")).mapToInt(Integer::parseInt).toArray();
        }
        int a = 0;
        int b = input.length - 1;
        int index = 0;
        long sum = 0;
        List<Integer> sums = new ArrayList<>();
        while (a < b) {
            if (a % 2 == 0) {
                for (int i = 0; i < input[a]; i++) {
                    sums.add( index * a / 2);
                    sum += (long) index * a / 2;
                    index++;
                }
                a++;
            } else {
                if (input[b] > input[a]) {
                    b -= 2;
                    continue;
                }
                for (int i = 0; i < Math.min(input[b], input[a]); i++) {
                    sums.add( index * b / 2);
                    sum += (long) index * b / 2;
                    index++;
                }
                input[a] -= input[b];
                b-=2;
            }
        }
        for (int i = 0; i < input[b]; i++) {
            sums.add( index * b / 2);
            sum += (long) index * b / 2;
            index++;
        }
        System.out.println(input[b]);
        System.out.println(sums);
        System.out.println(sum);
    }
}
