package adventofcode2024.day7;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Puzzle1314 {

    public boolean canAchieve(int[] nums, long target, long current, int index) {
        if (index == nums.length) {
            return target == current;
        }
        current = current + nums[index];
        if (canAchieve(nums, target, current, index + 1)) {
            return true;
        }
        current = current - nums[index];
        current = current * nums[index];
        if (canAchieve(nums, target, current, index + 1)) {
            return true;
        }
        current = current / nums[index];
        current = Long.parseLong(current + String.valueOf(nums[index]));
        return canAchieve(nums, target, current, index + 1);
    }

    public static void main(String[] args) throws FileNotFoundException {
        Puzzle1314 puzzle = new Puzzle1314();

        Map<Long, int[]> map = new HashMap<>();

        try (Scanner in = new Scanner(new FileInputStream("puzzle13.txt"))) {
            while (in.hasNextLine()) {
                String line = in.nextLine();
                String[] tokens = line.split(":");
                long target = Long.parseLong(tokens[0]);
                int[] array = Arrays.stream(tokens[1].trim().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
                map.put(target, array);
            }
        }

        long sum = map.entrySet()
                .stream()
                .filter(e -> puzzle.canAchieve(e.getValue(), e.getKey(), 0, 0))
                .mapToLong(Map.Entry::getKey)
                .sum();

        System.out.println(sum);
    }
}
