public class GridGame {

    static class Solution {
        public long gridGame(int[][] grid) {
            long sum1 = grid[0][0];
            long sum1Total = 0;
            long sum2Total = 0;
            int n = grid[0].length;

            for (int i = 0; i < n; i++) {
                sum2Total += grid[1][i];
                sum1Total += grid[0][i];
            }
            long sum2 = sum2Total;

            long maxSum = sum1Total - sum1;

            for (int i = 1; i < n; i++) {
                sum1 += grid[0][i];
                sum2 -= grid[1][i - 1];
                long robot2MaxSum = Math.max(sum1Total - sum1, sum2Total - sum2);
                if (maxSum > robot2MaxSum) {
                    maxSum = robot2MaxSum;
                }
            }

            return maxSum;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().gridGame(new int[][]{
                {3,3,1},
                {8,5,2}
        }));
    }
}
