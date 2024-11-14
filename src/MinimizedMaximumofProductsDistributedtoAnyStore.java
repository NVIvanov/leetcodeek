import java.util.Arrays;

public class MinimizedMaximumofProductsDistributedtoAnyStore {

    static class Solution {
        public int minimizedMaximum(int n, int[] quantities) {
            if (n == 1) {
                return quantities[0];
            }
            int l = 1, r = Arrays.stream(quantities).max().getAsInt();
            while (l < r) {
                int mid = l + (r - l) / 2;
                boolean res = canDistribute(quantities, mid, n);
                if (res) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }

            return l;
        }

        private static boolean canDistribute(int[] quantities, int k, int n) {
            for (int quantity : quantities) {
                n -= quantity / k;
                if (quantity % k > 0) {
                    n--;
                }
                if (n < 0) {
                    return false;
                }
            }
            return true;
        }

        public static void main(String[] args) {
            System.out.println(new Solution().minimizedMaximum(100000, new int[]{4,4,4,2,4,2,4,1,5,4,5,4,1,1,2,2,4,1,1,4,5,3,3,4,1,2}));
        }
    }
}
