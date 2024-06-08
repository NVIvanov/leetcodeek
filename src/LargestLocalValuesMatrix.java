public class LargestLocalValuesMatrix {

    public int[][] largestLocal(int[][] grid) {
        int[][] result = new int[grid.length-2][grid[0].length-2];
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                result[i][j] = maxContiguous(grid, i+1, j+1);
            }
        }
        return result;
    }

    private int maxContiguous(int[][] grid, int row, int col) {
        int max = grid[row][col];
        for (int i = row-1; i <= row+1; i++) {
            for (int j = col-1; j <= col+1; j++) {
                if (grid[i][j] > max) {
                    max = grid[i][j];
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {

    }
}
