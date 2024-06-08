import java.util.*;

public class CountElementsWithMaximumFrequency {

    public static int maxFrequencyElements(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (var num: nums) {
            counts.putIfAbsent(num, 0);
            counts.merge(num, 1, Integer::sum);
        }
        int sum = 0, max = 0;
        for (var count: counts.values()) {
            if (count > max) {
                max = count;
                sum = count;
            } else if (count == max) {
                sum += count;
            }
        }
        return sum;
    }

    public static void main(String[] args) {

    }
}
