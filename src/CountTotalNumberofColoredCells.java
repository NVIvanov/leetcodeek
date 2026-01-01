public class CountTotalNumberofColoredCells {

    static class Solution {
        public long coloredCells(int n) {
            return f(n) - f(n - 2);
        }

        private long f(int n) {
            if (n < 1) return 0;
            return (long) n * (n + 1) * (2L * n + 1) / 6;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().coloredCells(69675));
        System.out.println(testCalc(69675));
    }

    private static long testCalc(int n) {
        n = 2 * n - 1;
        long sum = n;
        for (int i = 1; i < n; i+=2) {
            sum += 2L * i;
        }
        return sum;
    }


}
