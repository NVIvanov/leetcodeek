import java.util.*;

public class CourseScheduleIV {

    static class Solution {
        public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
            Map<Integer, List<Integer>> graph = new HashMap<>();
            for (int[] prerequisite : prerequisites) {
                graph.putIfAbsent(prerequisite[0], new ArrayList<>());
                graph.get(prerequisite[0]).add(prerequisite[1]);
            }

            boolean[][] isReachable = new boolean[numCourses][numCourses];
            graph.keySet().forEach(key -> bfs(graph, key, isReachable));

            System.out.println(graph);
            for (int i = 0; i < numCourses; i++) {
                for (int j = 0; j < numCourses; j++) {
                    System.out.print(isReachable[i][j] ? "YES " : "NO ");
                }
                System.out.println();
            }

            List<Boolean> res = new ArrayList<>();
            for (int[] query : queries) {
                res.add(isReachable[query[0]][query[1]]);
            }
            return res;
        }

        private void bfs(Map<Integer, List<Integer>> graph, Integer start, boolean[][] isReachable) {
            Queue<Integer> toVisit = new LinkedList<>();
            toVisit.add(start);
            Set<Integer> visited = new HashSet<>();
            while (!toVisit.isEmpty()) {
                Set<Integer> visit = new HashSet<>();
                while (!toVisit.isEmpty()) {
                    int cur = toVisit.poll();
                    visited.add(cur);
                    List<Integer> linked = graph.get(cur);
                    if (linked != null) {
                        linked.forEach(v -> isReachable[start][v] = true);
                        visit.addAll(linked);
                    }
                }
                visit.removeAll(visited);
                toVisit.addAll(visit);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().checkIfPrerequisite(5,
                new int[][]{
                        {0,1},
                        {1,2},
                        {2,3},
                        {3,4}
                }, new int[][]{
                        {0,4},
                        {4,0},
                        {1,3},
                        {3,0}
                }));
    }

}
