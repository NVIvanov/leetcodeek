package contest.dec212024;

import java.util.Arrays;

public class Task2 {

    static class Solution {
        static final int MOD = 1_000_000_007;
        public int numberOfPaths(int[][] grid, int k) {
            int m = grid.length;
            int n = grid[0].length;

            // Optimize memory using two 2D arrays instead of 3D array
            int[][] prev = new int[n][1024];
            int[][] curr = new int[n][1024];

            // Initialize the starting point
            prev[0][grid[0][0]] = 1;

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    for (int x = 0; x < 1024; x++) {
                        if (prev[j][x] > 0) {
                            int newXor;

                            // Move Right
                            if (j + 1 < n) {
                                newXor = x ^ grid[i][j + 1];
                                curr[j + 1][newXor] = (curr[j + 1][newXor] + prev[j][x]) % MOD;
                            }

                            // Move Down
                            if (i + 1 < m) {
                                newXor = x ^ grid[i + 1][j];
                                curr[j][newXor] = (curr[j][newXor] + prev[j][x]) % MOD;
                            }
                        }
                    }
                }
                // Move to next row, swap arrays
                prev = curr;
                curr = new int[n][1024]; // Reset curr for next row
            }

            System.out.println(Arrays.toString(prev[n-1]));

            // Return the number of paths ending at the last cell with XOR == k
            return prev[n - 1][k];
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().numberOfPaths(
                new int[][]{
                        {2, 1, 5},
                        {7, 10, 0},
                        {12, 6, 4}
                }, 11
        ));
    }
}
