import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MinimumHeightTrees {

    public static List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (edges.length == 0) {
            return List.of(0);
        }

        Set<Integer> roots = new HashSet<>();
        List<List<Integer>> adjList = new ArrayList<>();

        // Constructing the adjacency list only once
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adjList.get(u).add(v);
            adjList.get(v).add(u);
            roots.add(u);
            roots.add(v);
        }

        List<Integer> res = new ArrayList<>();
        int minHeight = n;
        for (Integer root : roots) {
            int height = height(adjList, root);
            if (height < minHeight) {
                minHeight = height;
                res.clear();
                res.add(root);
            } else if (height == minHeight) {
                res.add(root);
            }
        }
        return res;
    }


    private static int height(List<List<Integer>> adjList, int root) {
        boolean[] visited = new boolean[adjList.size()];
        return dfs(adjList, root, visited);
    }

    private static int dfs(List<List<Integer>> adjList, int node, boolean[] visited) {
        visited[node] = true;
        int maxHeight = 0;
        for (int neighbor : adjList.get(node)) {
            if (!visited[neighbor]) {
                int height = dfs(adjList, neighbor, visited);
                maxHeight = Math.max(maxHeight, height);
            }
        }
        return maxHeight + 1;
    }


    public static void main(String[] args) {
        System.out.println(findMinHeightTrees(6, new int[][]{
                {3, 0},
                {3, 1},
                {3, 2},
                {3, 4},
                {5, 4}
        }));
    }
}
