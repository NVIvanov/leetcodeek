public class PathwithMaximumGold {
    public int getMaximumGold(int[][] grid) {
        int res = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] > 0) {
                    res = Math.max(res, backTrack(grid, i, j, visited, 0));
                }
            }
        }
        return res;
    }

    private int backTrack(int[][] grid, int row, int col, boolean[][] visited, int res) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == 0 || visited[row][col]) {
            return res;
        }
        visited[row][col] = true;
        var resU = Math.max(res, backTrack(grid, row - 1, col, visited, res + grid[row][col]));
        var resD = Math.max(res, backTrack(grid, row + 1, col, visited, res + grid[row][col]));
        var resL = Math.max(res, backTrack(grid, row, col - 1, visited, res + grid[row][col]));
        var resR = Math.max(res, backTrack(grid, row, col + 1, visited, res + grid[row][col]));
        res = Math.max(res, Math.max(resR, Math.max(resD, Math.max(resL, resU))));
        visited[row][col] = false;
        return res;
    }

    public static void main(String[] args) {
        System.out.println(
                new PathwithMaximumGold().getMaximumGold(new int[][]{
                        {0,6,0},
                        {5,8,7},
                        {0,9,0}
                })
        );
    }
}
