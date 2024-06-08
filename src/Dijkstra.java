import java.util.*;

public class Dijkstra {
    private final Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
    private final Map<Integer, Integer> costs = new HashMap<>();
    private final Map<Integer, Integer> parents = new HashMap<>();
    private final Set<Integer> processed = new HashSet<>();

    /**
     *
     * @param graphEdges in format graph[i] = [from, to, price]
     */
    public Dijkstra(int[][] graphEdges) {
        for (var edge: graphEdges) {
            graph.putIfAbsent(edge[0], new HashMap<>());
            graph.get(edge[0]).put(edge[1], edge[2]);
            costs.putIfAbsent(edge[1], edge[2]);
            parents.putIfAbsent(edge[1], edge[0]);
        }
    }





    public static void main(String[] args) {

        Map<String, Map<String, Integer>> graph = new HashMap<>();

        graph.put("start", Map.of("a", 6, "b", 2));
        graph.put("a", Map.of("fin", 1));
        graph.put("b", Map.of("a", 3, "fin", 5));

        System.out.println(graph);

        Map<String, Integer> costs = new HashMap<>();
        costs.put("a", 6);
        costs.put("b", 2);
        costs.put("fin", Integer.MAX_VALUE);

        Map<String, String> parents = new HashMap<>();
        parents.put("a", "start");
        parents.put("b", "start");
        parents.put("fin", null);

        Set<String> processed = new HashSet<>();
        Optional<String> node = findClosestUnvisited(costs, processed);

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

        System.out.println(costs);
        System.out.println(parents);
    }

    public static Optional<String> findClosestUnvisited(Map<String, Integer> costs, Set<String> visited) {
        return costs.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .filter(e -> !visited.contains(e.getKey()))
                .findFirst()
                .map(Map.Entry::getKey);
    }
}
