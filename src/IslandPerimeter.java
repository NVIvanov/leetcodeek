public class IslandPerimeter {

    public static int islandPerimeter(int[][] grid) {
        short perimeter = 0;
        for (byte i = 0; i < grid.length; i++) {
            for (byte j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0) {
                    if (i > 0 && grid[i - 1][j] == 1) {
                        perimeter ++;
                    }
                    if (i < grid.length - 1 && grid[i + 1][j] == 1) {
                        perimeter ++;
                    }
                    if (j > 0 && grid[i][j - 1] == 1) {
                        perimeter ++;
                    }
                    if (j < grid[i].length - 1 && grid[i][j + 1] == 1) {
                        perimeter ++;
                    }
                }
                if (grid[i][j] == 1) {
                    if (i == 0) {
                        perimeter ++;
                    }
                    if (i == grid.length - 1) {
                        perimeter ++;
                    }
                    if (j == 0) {
                        perimeter ++;
                    }
                    if (j == grid[i].length - 1) {
                        perimeter ++;
                    }
                }
            }
        }
        return perimeter;
    }

    public static void main(String[] args) {
        System.out.println(islandPerimeter(new int[][]{}));
    }
}
