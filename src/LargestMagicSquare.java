public class LargestMagicSquare {

    static class Solution {
        public int largestMagicSquare(int[][] grid) {
            int minL = Math.min(grid.length, grid[0].length);

            for (int i = minL - 1; i >= 1; i--) {
                for (int j = 0; j < grid.length - i; j++) {
                    for (int k = 0; k < grid[j].length - i; k++) {
                        if (isMagic(grid, j, k, i)) {
                            return i * i;
                        }
                    }
                }
            }

            return 1;
        }

        private boolean isMagic(int[][] grid, int x, int y, int l) {
            int prevSum, sum = 0;
            for (int i = x; i < x + l; i++) {
                prevSum = sum;
                sum = 0;
                for (int j = y; j < y + l; j++) {
                    sum += grid[i][j];
                }
                if (sum != prevSum) {
                    return false;
                }
            }

            for (int i = x; i < x + l; i++) {
                prevSum = sum;
                sum = 0;
                for (int j = y; j < y + l; j++) {
                    sum += grid[j][i];
                }
                if (sum != prevSum) {
                    return false;
                }
            }

            prevSum = sum;
            sum = 0;
            for (int j = 0; j < l; j++) {
                sum += grid[x + j][y + j];
            }
            if (sum != prevSum) {
                return false;
            }

            prevSum = sum;
            sum = 0;
            for (int j = 0; j < l; j++) {
                sum += grid[x + j][y + l - j];
            }
            if (sum != prevSum) {
                return false;
            }

            return true;
        }
    }

    public static void main(String[] args) {

    }
}
