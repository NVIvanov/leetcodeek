import java.util.*;

public class ShortestDistanceAfterRoadAdditionQueriesI {
    public static int[] shortestDistanceAfterQueries(int n, int[][] queries) {

        if (n == 0) {
            return new int[0];
        }

        if (n == 1) {
            return new int[]{1};
        }

        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();

        for (int i = 0; i < n - 1; i++) {
            graph.put(i, new HashMap<>());
            graph.get(i).put(i + 1, 1);
        }

        Map<Integer, Integer> costs = new HashMap<>();
        if (n > 0) {
            costs.put(1, 1);
        }

        Map<Integer, Integer> parents = new HashMap<>();
        for (int i = 0; i < n - 1; i++) {
            parents.put(i + 1, i);
        }

        Set<Integer> processed = new HashSet<>();
        Optional<Integer> node = findClosestUnvisited(costs, processed);

        while (node.isPresent()) {
            var nodeValue = node.get();
            var cost = costs.get(nodeValue);
            var neighbors = graph.get(nodeValue);
            if (neighbors != null) {
                for (var neighbor: neighbors.keySet()) {
                    var newCost = cost + neighbors.get(neighbor);
                    if (costs.get(neighbor) > newCost) {
                        costs.replace(neighbor, newCost);
                        parents.put(neighbor, nodeValue);
                    }
                }
            }
            processed.add(nodeValue);
            node = findClosestUnvisited(costs, processed);
        }

        System.out.println(graph);
        System.out.println(costs);
        System.out.println(parents);

        return new int[0];
    }

    public static Optional<Integer> findClosestUnvisited(Map<Integer, Integer> costs, Set<Integer> visited) {
        return costs.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .filter(e -> !visited.contains(e.getKey()))
                .findFirst()
                .map(Map.Entry::getKey);
    }

    public static void main(String[] args) {
        System.out.println(shortestDistanceAfterQueries(5, new int[][]{
                {2,4},
                {0,2},
                {0,4}
        }));
    }
}
