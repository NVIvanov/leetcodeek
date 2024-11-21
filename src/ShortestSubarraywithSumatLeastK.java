import java.util.*;

public class ShortestSubarraywithSumatLeastK {

    static class Solution {
        public int shortestSubarray(int[] nums, int k) {
            int sum = 0;
            int shortest = nums.length + 1;
            int l = 0, r = 0;
            while (!(r == nums.length && l == nums.length)) {
                if (sum < k) {
                    if (r < nums.length) {
                        sum += nums[r++];
                    } else {
                        sum -= nums[l++];
                    }
                } else {
                    shortest = Math.min(shortest, r - l);
                    sum -= nums[l++];
                }
            }
            return shortest == nums.length + 1 ? -1 : shortest;
        }

        public int shortestSubarray2(int[] nums, int k) {
            int shortest = nums.length + 1;

            for (int i = 0; i < nums.length; i++) {
                shortest = Math.min(shortest, len(nums, k, i, shortest));
            }

            return shortest == nums.length + 1 ? -1 : shortest;
        }

        public int len(int[] nums, int k, int i, int limit) {
            int sum = nums[i++];
            int len = 1;
            while (sum < k && i < nums.length && len < limit) {
                sum += nums[i++];
                len++;
            }
            if (sum < k) {
                return limit;
            }
            return len;
        }

        public int shortestSubarray3(int[] nums, int k) {
            long[] sums = new long[nums.length + 1];
            for (int i = 1; i <= nums.length; i++) {
                sums[i] = sums[i - 1] + nums[i - 1];
            }

            Deque<Integer> deque = new ArrayDeque<>();
            int shortest = Integer.MAX_VALUE;

            for (int i = 0; i <= nums.length; i++) {
                while (!deque.isEmpty() && sums[i] - sums[deque.peek()] >= k) {
                    shortest = Math.min(shortest, i - deque.poll());
                }
                while (!deque.isEmpty() && sums[i] <= sums[deque.peekLast()]) {
                    deque.pollLast();
                }
                deque.offer(i);
            }

            return shortest == Integer.MAX_VALUE ? -1 : shortest;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().shortestSubarray3(new int[]{84,-37,32,40,95}, 167));
    }
}
