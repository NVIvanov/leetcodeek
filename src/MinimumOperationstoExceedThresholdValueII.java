import java.util.PriorityQueue;
import java.util.Queue;

public class MinimumOperationstoExceedThresholdValueII {

    static class Solution {
        public int minOperations(int[] nums, int k) {
            Queue<Long> queue = new PriorityQueue<>();
            for (int num : nums) {
                queue.offer((long) num);
            }
            int count = 0;
            while (queue.peek() < k) {
                long x = queue.poll();
                long y = queue.poll();
                queue.offer(Math.min(x, y) * 2 + Math.max(x, y));
                count++;
            }
            return count;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minOperations(new int[]{999999999,999999999,999999999}, 1000000000));
    }
}
