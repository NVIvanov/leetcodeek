public class MaximumCandiesAllocatedtoKChildren {

    class Solution {
        public int maximumCandies(int[] candies, long k) {
            int max = 0;
            for (int i = 0; i < candies.length; i++) {
                max = Math.max(max, candies[i]);
            }
            int l = 0, r = max;
            while (l < r) {
                long mid = l + (r - l) / 2;
                if (canDivide(candies, k, mid)) {
                    l = (int)mid + 1;
                } else {
                    r = (int)mid;
                }
            }
            return l - 1;
        }

        private boolean canDivide(int[] candies, long k, long mid) {
            if (mid == 0) {
                return true;
            }
            int count = 0, i = 0;
            while (i < candies.length && count < k) {
                if (candies[i] >= mid) {
                    count += candies[i] / mid;
                }
                i++;
            }
            return count >= k;
        }
    }

    public static void main(String[] args) {
        
    }

}
