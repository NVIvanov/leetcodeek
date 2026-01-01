import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class MinimumCosttoMakeatLeastOneValidPathinaGrid {

    static class Solution {
        public int minCost(int[][] grid) {
            Map<Point, Map<Point, Integer>> graph = new HashMap<>();

            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    Point point = new Point(i, j);
                    graph.putIfAbsent(point, new HashMap<>());
                    if (i > 0) {
                        graph.get(point).put(new Point(i - 1, j), grid[i][j] == 4 ? 0 : 1);
                    }
                    if (j > 0) {
                        graph.get(point).put(new Point(i, j - 1), grid[i][j] == 2 ? 0 : 1);
                    }
                    if (i < grid.length - 1) {
                        graph.get(point).put(new Point(i + 1, j), grid[i][j] == 3 ? 0 : 1);
                    }
                    if (j < grid[0].length - 1) {
                        graph.get(point).put(new Point(i, j + 1), grid[i][j] == 1 ? 0 : 1);
                    }
                }
            }

            return bfsShortestPath(graph, new Point(0, 0), new Point(grid.length - 1, grid[0].length - 1));
        }

        public static int bfsShortestPath(Map<Point, Map<Point, Integer>> graph, Point start, Point end) {
            Map<Point, Integer> distances = new HashMap<>();
            Queue<Point> queue = new LinkedList<>();

            for (Point point : graph.keySet()) {
                distances.put(point, Integer.MAX_VALUE);
            }

            distances.put(start, 0);
            queue.offer(start);

            while (!queue.isEmpty()) {
                Point current = queue.poll();
                int currentDistance = distances.get(current);
                if (graph.containsKey(current)) {
                    for (Map.Entry<Point, Integer> neighbor : graph.get(current).entrySet()) {
                        Point nextPoint = neighbor.getKey();
                        int weight = neighbor.getValue();
                        if (currentDistance + weight < distances.get(nextPoint)) {
                            distances.put(nextPoint, currentDistance + weight);
                            queue.offer(nextPoint);
                        }
                    }
                }
            }
            return distances.getOrDefault(end, Integer.MAX_VALUE) == Integer.MAX_VALUE ? -1 : distances.get(end);
        }

        record Point(int x, int y) {}
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minCost(new int[][]{{1,2}, {4,3}}));
    }
}
