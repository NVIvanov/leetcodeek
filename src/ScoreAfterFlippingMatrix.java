import java.util.Arrays;

public class ScoreAfterFlippingMatrix {

    public int matrixScore(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            if (grid[i][0] == 0) {
                flipRow(grid, i);
            }
        }
        for (int i = 0; i < grid[0].length; i++) {
            int zeroCount = 0;
            for (int[] ints : grid) {
                if (ints[i] == 0) {
                    zeroCount++;
                }
            }
            if (zeroCount > grid.length / 2) {
                flipCol(grid, i);
            }
        }
        int sum = 0;
        for (int[] ints : grid) {
            sum += rowToInt(ints);
        }
        return sum;
    }

    private static void flipRow(int[][] grid, int row) {
        for (int col = 0; col < grid[0].length; col++) {
            grid[row][col] = grid[row][col] ^ 1;
        }
    }

    private static void flipCol(int[][] grid, int col) {
        for (int row = 0; row < grid.length; row++) {
            grid[row][col] = grid[row][col] ^ 1;
        }
    }

    private static int rowToInt(int[] row) {
        int res = 0;
        for (int j : row) {
            res += j;
            res *= 2;
        }
        return res / 2;
    }

    public static void main(String[] args) {
        System.out.println(rowToInt(new int[]{1,1,1,1}));
    }
}
