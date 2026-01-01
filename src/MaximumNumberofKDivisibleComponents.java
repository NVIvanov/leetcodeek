import java.util.*;

public class MaximumNumberofKDivisibleComponents {

    static class Solution {
        static int counter = 0;
        public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
            counter = 0;
            Map<Integer, List<Integer>> map = new HashMap<>();
            for (int[] edge : edges) {
                map.computeIfAbsent(edge[0], e -> new ArrayList<>()).add(edge[1]);
                map.computeIfAbsent(edge[1], e -> new ArrayList<>()).add(edge[0]);
            }
            Set<Integer> visited = new HashSet<>();
            map.put(-1, List.of(0));
            sumOfSubTree(map, visited, values, -1, k);
            return counter;
        }

        private long sumOfSubTree(Map<Integer, List<Integer>> edgesFrom, Set<Integer> visited, int[] values, int index, int k) {
            return edgesFrom.getOrDefault(index, Collections.emptyList()).stream().filter(child -> !visited.contains(child)).mapToLong(child -> {
                visited.add(child);
                long sum = sumOfSubTree(edgesFrom, visited, values, child, k);
                if (sum % k == 0) {
                    counter++;
                    System.out.println("child - " + child + " sum - " + sum + " - counted");
                    return 0;
                }
                System.out.println("child - " + child + " sum - " + sum);
                return sum;
            }).sum() + (index == -1 ? 0 : values[index]);
        }
    }

    public static void main(String[] args) {
//        System.out.println(new Solution().maxKDivisibleComponents(5,
//                new int[][]{
//                        {0,2},
//                        {1,2},
//                        {1,3},
//                        {2,4}
//                }, new int[]{1,8,1,4,4,}, 6));
//
//        System.out.println(new Solution().maxKDivisibleComponents(7,
//                new int[][]{
//                        {0,1},
//                        {0,2},
//                        {1,3},
//                        {1,4},
//                        {2,5},
//                        {2,6}
//                }, new int[]{3,0,6,1,5,2,1}, 3));
//
//        System.out.println(new Solution().maxKDivisibleComponents(1,
//                new int[][]{}, new int[]{0}, 1));



        System.out.println(new Solution().maxKDivisibleComponents(1,
                new int[][]{
                        {0,1},
                        {0,2},
                        {1,3},
                        {1,4},
                        {2,5},
                        {2,6},
                }, new int[]{1000000000,1000000000,1000000000,1000000000,1000000000,1000000000,1000000000}, 7));
    }
}
