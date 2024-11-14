import java.util.*;

public class MostBeautifulItemforEachQuery {

    static class Solution {
        public int[] maximumBeauty(int[][] items, int[] queries) {
            Arrays.sort(items, Comparator.<int[]>comparingInt(it -> it[0])
                    .thenComparingInt(it -> it[1]));
            int[] sortedQueries = Arrays.copyOf(queries, queries.length);
            Arrays.sort(sortedQueries);

            Map<Integer, Integer> map = calculateBeauty(items, sortedQueries);

            int[] res = new int[queries.length];
            for (int i = 0; i < queries.length; i++) {
                res[i] = map.get(queries[i]);
            }
            return res;
        }

        private static Map<Integer, Integer> calculateBeauty(int[][] items, int[] queries) {
            int itemIndex = 0;
            int queriesIndex = 0;
            int maxB = 0;

            Map<Integer, Integer> map = new HashMap<>();

            while (queriesIndex < queries.length) {
                while (itemIndex < items.length && items[itemIndex][0] <= queries[queriesIndex]) {
                    if (items[itemIndex][1] > maxB) {
                        maxB = items[itemIndex][1];
                    }
                    itemIndex++;
                }
                map.put(queries[queriesIndex++], maxB);
            }
            return map;
        }

    }

    public static void main(String[] args) {
        int[][] items = {{1,2}, {3,5}, {2,4}, {5,6}, {3,2}};
        int[] queries = {1,2,3,4,5,6};

        System.out.println(Arrays.toString(new Solution().maximumBeauty(items, queries)));
    }
}
