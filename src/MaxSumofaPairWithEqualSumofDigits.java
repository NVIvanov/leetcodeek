import java.util.*;

public class MaxSumofaPairWithEqualSumofDigits {

    class Solution {
        public int maximumSum(int[] nums) {
            Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
            for (int num : nums) {
                int digitSum = digitSum(num);
                map.putIfAbsent(digitSum, new PriorityQueue<>(Comparator.reverseOrder()));
                map.get(digitSum).add(num);
            }
            int maxSum = 0;
            for (Map.Entry<Integer, PriorityQueue<Integer>> entry : map.entrySet()) {
                if (entry.getValue().size() < 2) {
                    continue;
                }
                maxSum = Math.max(maxSum, entry.getValue().poll() + entry.getValue().poll());
            }
            return maxSum;
        }

        private int digitSum(int num) {
            int sum = -1;
            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }
            return sum;
        }
    }

    public static void main(String[] args) {

    }
}
