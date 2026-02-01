import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CounttheNumberofCompleteComponents {

    static class Solution {
        public int countCompleteComponents(int n, int[][] edges) {
            int result = 0;
            boolean[] visited = new boolean[n];
            Map<Integer, List<Integer>> graph = new HashMap<>();
            for (int[] edge : edges) {
                graph.putIfAbsent(edge[0], new ArrayList<>());
                graph.putIfAbsent(edge[1], new ArrayList<>());
                graph.get(edge[0]).add(edge[1]);
                graph.get(edge[1]).add(edge[0]);
            }
            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    List<Integer> component = new ArrayList<>();
                    dfs(graph, visited, i, component);
                    if (isComplete(graph, component)) {
                        result++;
                    }
                }
            }
            return result;
        }

        private void dfs(Map<Integer, List<Integer>> graph, boolean[] visited, int node, List<Integer> component) {
            if (visited[node]) {
                return;
            }
            visited[node] = true;
            component.add(node);
            if (!graph.containsKey(node)) {
                return;
            }
            for (int neighbor : graph.get(node)) {
                dfs(graph, visited, neighbor, component);
            }
        }

        private boolean isComplete(Map<Integer, List<Integer>> graph, List<Integer> component) {
            int numNodes = component.size();
            int numEdges = 0;
            for (int node : component) {
                if (graph.containsKey(node)) {
                    for (int neighbor : graph.get(node)) {
                        if (component.contains(neighbor) && node < neighbor) {
                            numEdges++;
                        }
                    }
                }
            }
            return numEdges == numNodes * (numNodes - 1) / 2;
        }
    }
}