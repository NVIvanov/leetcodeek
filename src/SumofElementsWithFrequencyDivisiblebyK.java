import java.util.HashMap;
import java.util.Map;

public class SumofElementsWithFrequencyDivisiblebyK {

    static class Solution {
        public int sumDivisibleByK(int[] nums, int k) {
            Map<Integer, Integer> stats = new HashMap<>();
            for (int num : nums) {
                stats.putIfAbsent(num, 0);
                stats.compute(num, (key, v) -> v + 1);
            }
            int sum = 0;
            for (var entry: stats.entrySet()) {
                if (entry.getValue() % k == 0) {
                    sum += entry.getValue() * entry.getKey();
                }
            }
            return sum;
        }
    }

    public static void main(String[] args) {

    }
}
