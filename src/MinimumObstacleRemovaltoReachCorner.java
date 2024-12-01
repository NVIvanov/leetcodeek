import java.util.*;

public class MinimumObstacleRemovaltoReachCorner {

    static class Solution {
        public int minimumObstacles(int[][] grid) {
            boolean[][] visited = new boolean[grid.length][grid[0].length];
            int[][] path = new int[grid.length][grid[0].length];
            PriorityQueue<Integer[]> toVisit = new PriorityQueue<>(Comparator.comparingInt(o -> grid[o[0]][o[1]]));
            toVisit.add(new Integer[]{0, 0});

            visited[0][0] = true;

            while (!toVisit.isEmpty()) {
                Set<Integer[]> next = new HashSet<>();
                while (!toVisit.isEmpty()) {
                    Integer[] curr = toVisit.poll();
                    List<Integer[]> nextCells = nextCells(curr[0], curr[1], grid);
                    for (Integer[] nextCell : nextCells) {
                        if (!visited[nextCell[0]][nextCell[1]]) {
                            next.add(nextCell);
                            visited[nextCell[0]][nextCell[1]] = true;
                            path[nextCell[0]][nextCell[1]] = path[curr[0]][curr[1]] + grid[nextCell[0]][nextCell[1]];
                        } else {
                            if (path[nextCell[0]][nextCell[1]] > grid[nextCell[0]][nextCell[1]] + path[curr[0]][curr[1]]) {
                                next.add(nextCell);
                            }
                            path[nextCell[0]][nextCell[1]] = Math.min(path[nextCell[0]][nextCell[1]], grid[nextCell[0]][nextCell[1]] + path[curr[0]][curr[1]] );
                        }
                    }
                }
                toVisit.addAll(next);
            }

            return path[grid.length - 1][grid[0].length - 1];
        }

        private List<Integer[]> nextCells(int x, int y, int[][] grid) {
            List<Integer[]> result = new ArrayList<>();
            if (canBeNext(x - 1, y, grid)) {
                result.add(new Integer[]{x - 1, y});
            }
            if (canBeNext(x, y - 1, grid)) {
                result.add(new Integer[]{x, y - 1});
            }
            if (canBeNext(x, y + 1, grid)) {
                result.add(new Integer[]{x, y + 1});
            }
            if (canBeNext(x + 1, y, grid)) {
                result.add(new Integer[]{x + 1, y});
            }
            return result;
        }

        private boolean canBeNext(int x, int y, int[][] grid) {
            return !(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minimumObstacles(
                new int[][] {
                        {0,1,0},
                        {1,0,0},
                }
        ));
    }
}
