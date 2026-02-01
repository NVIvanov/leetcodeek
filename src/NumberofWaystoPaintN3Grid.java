public class NumberofWaystoPaintN3Grid {

    static class Solution {
        private final static Integer MOD = 1_000_000_007;

        public int numOfWays(int n) {
            long c2 = 6, c3 = 6, tmpc3;
            for (int i = 2; i <= n; i++) {
                tmpc3 = c3;
                c3 = ((c2 + tmpc3) * 2) % MOD;
                c2 = (tmpc3 * 2 + c2 * 3) % MOD;
            }
            return Math.toIntExact((c2 + c3) % MOD);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().numOfWays(5000));
    }
}
