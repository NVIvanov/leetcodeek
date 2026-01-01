import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class MakingALargeIsland {

    static class Solution {
        static int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        public int largestIsland(int[][] grid) {
            int max = 1;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    max = Math.max(max, bfs(grid,i,j));
                }
            }
            return max;
        }

        private int bfs(int[][] grid, int row, int col) {
            Queue<Point> queue = new LinkedList<>();
            queue.offer(new Point(row, col));
            Set<Point> visited = new HashSet<>();
            while (!queue.isEmpty()) {
                Set<Point> toVisit = new HashSet<>();
                while (!queue.isEmpty()) {
                    Point cur = queue.poll();
                    visited.add(cur);
                    for (int[] dir : dirs) {
                        int x = cur.x + dir[0];
                        int y = cur.y + dir[1];
                        if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == 1) {
                            toVisit.add(new Point(x, y));
                        }
                    }
                }
                toVisit.removeAll(visited);
                queue.addAll(toVisit);
            }
            return visited.size();
        }

        record Point(int x, int y) {}
    }

    public static void main(String[] args) {
        System.out.println(new Solution().largestIsland(new int[][]{
                {0,0}
        }));
    }
}
