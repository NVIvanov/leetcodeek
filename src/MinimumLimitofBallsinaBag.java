import java.util.Arrays;

public class MinimumLimitofBallsinaBag {

    static class Solution {
        public int minimumSize(int[] nums, int maxOperations) {
            int a = 1;
            int b = Integer.MIN_VALUE;
            for (int num: nums) {
                b = Math.max(b, num);
            }

            while (a < b) {
                int mid = a + (b - a) / 2;
                if (possibleToSplit(nums, mid, maxOperations)) {
                    b = mid;
                } else {
                    a = mid + 1;
                }
            }

            return a;
        }

        private boolean possibleToSplit(int[] arr, int maxBalls, int maxOperations) {
            int num = 0;

            for (int j : arr) {
                num += numOfOperations(maxBalls, j);
                if (num > maxOperations) {
                    return false;
                }
            }
            return true;
        }

        private int numOfOperations(int target, long value) {
            return (int) (Math.ceil((double) value / target) - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minimumSize(new int[]{9}, 2));
    }
}
