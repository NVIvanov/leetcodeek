public class MaximumNumberofFishinaGrid {

    static class Solution {
        private static int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        public int findMaxFish(int[][] grid) {
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] > 0) {
                        max = Math.max(max, dfs(grid, i, j, new boolean[grid.length][grid[0].length]));
                    }
                }
            }
            return max;
        }

        private int dfs(int[][] grid, int row, int col, boolean[][] visited) {
            visited[row][col] = true;
            int sum = 0;
            for (int[] direction : directions) {
                int newRow = row + direction[0];
                int newCol = col + direction[1];
                if (newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[0].length
                        && !visited[newRow][newCol] && grid[newRow][newCol] > 0) {
                    sum += dfs(grid, newRow, newCol, visited);
                }
            }
            return sum + grid[row][col];
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findMaxFish(new int[][]{{9,10}}));
    }
}
