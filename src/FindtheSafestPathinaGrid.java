import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindtheSafestPathinaGrid {

    public static int maximumSafenessFactor(List<List<Integer>> grid) {
        int rows = grid.size();
        int cols = rows;
        int[][] matrix = new int[rows][cols];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < grid.size(); i++) {
            for (int j = 0; j < grid.get(i).size(); j++) {
                if (grid.get(i).get(j) == 1) {
                    matrix[i][j] = 1;
                    queue.offer(new int[]{i, j});
                } else {
                    matrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            int row = pos[0];
            int col = pos[1];
            for (int[] direction : directions) {
                int newRow = row + direction[0];
                int newCol = col + direction[1];
                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols) {
                    if (matrix[newRow][newCol] > matrix[row][col] + 1) {
                        matrix[newRow][newCol] = matrix[row][col] + 1;
                        queue.offer(new int[]{newRow, newCol});
                    }
                }
            }
        }

        int l = 0;
        int r = grid.size();
        while (l < r) {
            int mid = (l + r + 1) / 2;
            if (isSafe(matrix, mid, grid.size())) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return l - 1;
    }

    private static boolean isSafe(int[][] dist, int target, int size) {
        int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[size][size];
        if (dist[0][0] >= target) {
            queue.add(new int[]{0, 0});
            visited[0][0] = true;
        }

        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            if (pos[0] == size-1 && pos[1] == size-1) {
                return true;
            }

            for (int[] direction : directions) {
                int newRow = pos[0] + direction[0];
                int newCol = pos[1] + direction[1];
                if (0 <= newRow && newRow < size && 0 <= newCol && newCol < size  && !visited[newRow][newCol] && dist[newRow][newCol] >= target) {
                    visited[newRow][newCol] = true;
                    queue.offer(new int[]{newRow, newCol});
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(maximumSafenessFactor(
                List.of(
                        List.of(0, 0, 1),
                        List.of(0, 0, 0),
                        List.of(0, 0, 0)
                )
        ));
    }
}
