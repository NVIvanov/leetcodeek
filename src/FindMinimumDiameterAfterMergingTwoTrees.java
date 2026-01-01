import java.util.*;

public class FindMinimumDiameterAfterMergingTwoTrees {

    static class Solution {
        public int minimumDiameterAfterMerge(int[][] edges1, int[][] edges2) {
            var graph1 = graph(edges1);
            var graph2 = graph(edges2);

            int d1 = diameter(graph1);
            int d2 = diameter(graph2);
            int dO = (d1 % 2 == 1 ? d1 + 1 : d1) / 2 + (d2 % 2 == 1 ? d2 + 1 : d2) / 2 + 1;
            return Math.max(d1, Math.max(dO, d2));
        }

        private int diameter(Map<Integer, List<Integer>> graph) {
            var distancesFromZero = bfs(graph, 0);
            Integer farthest = distancesFromZero.entrySet()
                    .stream()
                    .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                    .map(Map.Entry::getKey)
                    .findFirst().orElse(0);
            var distancesFromOne = bfs(graph, farthest);
            return distancesFromOne.entrySet()
                    .stream()
                    .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                    .map(Map.Entry::getValue)
                    .findFirst().orElse(0);
        }

        private Map<Integer, List<Integer>> graph(int[][] edges) {
            Map<Integer, List<Integer>> graph = new HashMap<>();
            for (int[] edge : edges) {
                graph.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
                graph.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
            }
            return graph;
        }

        public Map<Integer, Integer> bfs(Map<Integer, List<Integer>> graph, Integer start) {
            Set<Integer> visited = new HashSet<>();
            Queue<Integer> queue = new LinkedList<>();
            Map<Integer, Integer> distance = new HashMap<>();
            queue.offer(start);
            visited.add(start);
            distance.put(start, 0);
            int res = 0;
            while (!queue.isEmpty()) {
                List<Integer> neighbors = new ArrayList<>();
                while (!queue.isEmpty()) {
                    int cur = queue.poll();
                    distance.put(cur, res);
                    neighbors.addAll(Optional.ofNullable(graph.get(cur)).orElse(Collections.emptyList()));
                }
                neighbors = neighbors.stream().filter(n -> !visited.contains(n)).toList();
                visited.addAll(neighbors);
                queue.addAll(neighbors);
                res++;
            }
            return distance;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minimumDiameterAfterMerge(new int[][]
                /*
                                    9
                                    |
                                6 - 3 - 2 - 0 - 1
                                    |
                        7 - 8 - 4 - 5 - 0 - 1
                                        | \
                                        3   2
                 */
                {{0,1},{2,0},{3,2},{3,6},{8,7},{4,8},{5,4},{3,5},{3,9}}
                , new int[][]{
                {0,1},
                {0,2},
                {0,3}
        }));
    }
}
