import java.util.ArrayList;
import java.util.List;

public class FindAllGroupsofFarmland {

    public static int[][] findFarmland(int[][] land) {
        byte[][] visited = new byte[land.length][land[0].length];
        List<int[]> corrdinatesAll = new ArrayList<>();
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[0].length; j++) {
                if (land[i][j] == 1 && visited[i][j] == 0) {
                    var coordinates = new int[]{i, j, i, j};
                    fillIsland(land, visited, coordinates, i, j);
                    corrdinatesAll.add(coordinates);
                }
            }
        }
        int[][] result = new int[corrdinatesAll.size()][];
        for (int i = 0; i < corrdinatesAll.size(); i++) {
            result[i] = corrdinatesAll.get(i);
        }
        return result;
    }

    private static void fillIsland(int[][] grid, byte[][] visited, int[] coordinates, int i, int j) {
        if (i >= 0 && i < grid.length && j >= 0 && j < grid[i].length && grid[i][j] == 1 && visited[i][j] == 0) {
            visited[i][j] = 1;
            if (i < coordinates[0] || j < coordinates[1]) {
                coordinates[0] = i;
                coordinates[1] = j;
            }
            if (i > coordinates[2] && j > coordinates[3]) {
                coordinates[2] = i;
                coordinates[3] = j;
            }
            fillIsland(grid, visited, coordinates, i - 1, j);
            fillIsland(grid, visited, coordinates, i + 1, j);
            fillIsland(grid, visited, coordinates,  i, j - 1);
            fillIsland(grid, visited, coordinates, i, j + 1);
        }
    }

    public static void main(String[] args) {

    }
}
