import java.util.*;
import java.util.stream.Collectors;

public class MakLexicographicallySmallestArraybySwappingElements {

    static class Solution {
        public int[] lexicographicallySmallestArray(int[] nums, int limit) {
            boolean[] visited = new boolean[nums.length];
            List<Map<Integer, Integer>> groups = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                if (!visited[i]) {
                    groups.add(makeGroup(nums, i, limit, visited));
                }
            }

            for (Map<Integer, Integer> group : groups) {
                sortGroup(group);
            }

            for (Map<Integer, Integer> group : groups) {
                System.out.println(group);
            }

            Map<Integer, Integer> merged = mergeGroups(groups);
            System.out.println(merged);

            int[] res = new int[nums.length];
            merged.forEach((key, value) -> res[value] = key);

            return res;
        }

        private Map<Integer, Integer> makeGroup(int[] nums, int index, int limit, boolean[] visited) {
            Map<Integer, Integer> group = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                if (Math.abs(nums[index] - nums[i]) <= limit) {
                    group.put(nums[i], i);
                    visited[i] = true;
                }
            }
            return group;
        }

        private void sortGroup(Map<Integer, Integer> group) {
            PriorityQueue<Integer> indexes = new PriorityQueue<>();
            PriorityQueue<Integer> values = new PriorityQueue<>();
            group.forEach((key, value) -> {
                indexes.add(key);
                values.add(value);
            });
            group.clear();
            while (!indexes.isEmpty()) {
                group.put(indexes.poll(), values.poll());
            }
        }

        private Map<Integer, Integer> mergeGroups(List<Map<Integer, Integer>> groups) {
            return groups.stream()
                    .flatMap(group -> group.entrySet().stream())
                    .collect(Collectors.groupingBy(Map.Entry::getKey,
                            Collectors.minBy(Comparator.comparingInt(Map.Entry::getValue))))
                    .entrySet().stream()
                    .collect(Collectors.toMap(Map.Entry::getKey, e -> e.getValue().get().getValue()));
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.lexicographicallySmallestArray(new int[]{1,7,6,18,2,1}, 3);
    }
}
