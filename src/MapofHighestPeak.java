import java.util.*;

public class MapofHighestPeak {

    static class Solution {
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        public int[][] highestPeak(int[][] isWater) {
            int rows = isWater.length, cols = isWater[0].length;
            Queue<int[]> queue = new LinkedList<>();
            int[][] result = new int[rows][cols];
            for (int[] row : result) Arrays.fill(row, -1); // Initialize with -1 to track unvisited cells.

            // Add all water cells to the queue and mark them with height 0.
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (isWater[i][j] == 1) {
                        queue.offer(new int[]{i, j});
                        result[i][j] = 0;
                    }
                }
            }

            // BFS to calculate heights.
            while (!queue.isEmpty()) {
                int[] point = queue.poll();
                int currentHeight = result[point[0]][point[1]];

                for (int[] dir : directions) {
                    int newRow = point[0] + dir[0];
                    int newCol = point[1] + dir[1];

                    if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && result[newRow][newCol] == -1) {
                        result[newRow][newCol] = currentHeight + 1;
                        queue.offer(new int[]{newRow, newCol});
                    }
                }
            }

            return result;
        }

        record Point(int i, int j) {}
    }

    public static void main(String[] args) {
        int[][] res = new Solution().highestPeak(new int[][]{{0,0,1}, {1,0,0}, {0,0,0}});
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[i].length; j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
    }
}
