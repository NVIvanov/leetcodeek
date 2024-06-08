import java.util.*;

public class FindifPathExistsinGraph {

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> toVisit = new LinkedList<>();
        for (int[] edge : edges) {
            graph.putIfAbsent(edge[0], new ArrayList<>());
            graph.putIfAbsent(edge[1], new ArrayList<>());
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        toVisit.add(source);
        visited.add(source);
        while (!toVisit.isEmpty()) {
            int current = toVisit.poll();
            var neighbors = graph.get(current);
            if (neighbors != null) {
                for (int neighbor : graph.get(current)) {
                    if (!visited.contains(neighbor)) {
                        visited.add(neighbor);
                        toVisit.add(neighbor);
                    }
                }
            }
        }
        return visited.contains(destination);
    }

    public static void main(String[] args) {

    }
}
