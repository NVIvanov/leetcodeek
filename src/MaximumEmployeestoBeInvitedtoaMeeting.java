import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MaximumEmployeestoBeInvitedtoaMeeting {

    static class Solution {


        /*

            types:
                N-cycle
                2-cycle
                chains


            0   1
             \ /2
              2
              |
              3
         */
        public int maximumInvitations(int[] favorite) {
            Map<Integer, Integer> graph = new HashMap<>();
            for (int i = 0; i < favorite.length; i++) {
                graph.put(i, favorite[i]);
            }
            int count = 0;
            while (!graph.isEmpty()) {
                System.out.println(count++);
                System.out.println(component(graph));
            }
            return 0;
        }

        private Map<Integer, Integer> component(Map<Integer, Integer> graph) {
            if (graph.isEmpty()) {
                return graph;
            }

            Integer node = graph.keySet().iterator().next();
            Integer first = node;
            Map<Integer, Integer> result = new HashMap<>();
            while (graph.containsKey(node)) {
                if (Objects.equals(graph.get(node), first)) {
                    // this is a cycle
                    result.put(node, graph.get(node));
                    return result;
                }
                if (result.containsKey(graph.get(node))) {
                    return result;
                }
                result.put(node, graph.get(node));
                node = graph.remove(node);
            }
            return result;
        }
    }

    public static void main(String[] args) {
        new Solution().maximumInvitations(new int[]{2,2,1,2});
    }
}
