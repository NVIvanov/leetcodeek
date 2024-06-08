public class NumberofIslands {

    public static int numIslands(char[][] grid) {
        byte[][] visited = new byte[grid.length][grid[0].length];
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && visited[i][j] == 0) {
                    fillIsland(grid, visited, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private static void fillIsland(char[][] grid, byte[][] visited, int i, int j) {
        if (i >= 0 && i < grid.length && j >= 0 && j < grid[i].length && grid[i][j] == '1' && visited[i][j] == 0) {
            visited[i][j] = 1;
            fillIsland(grid, visited, i - 1, j);
            fillIsland(grid, visited, i + 1, j);
            fillIsland(grid, visited, i, j - 1);
            fillIsland(grid, visited, i, j + 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(numIslands(new char[][] {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        }));
    }
}
