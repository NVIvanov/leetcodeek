import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class FindBuildingWhereAliceandBobCanMeet {

    static class Solution {
        public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
            for (int i = 0; i < queries.length; i++) {
                if (queries[i][0] > queries[i][1]) {
                    int tmp = queries[i][0];
                    queries[i][0] = queries[i][1];
                    queries[i][1] = tmp;
                }
            }

            int[] res = new int[queries.length];

            Arrays.fill(res, -1);

            int[][] sortedQueries = new int[queries.length][3];
            for (int i = 0; i < queries.length; i++) {
                sortedQueries[i][0] = i;
                sortedQueries[i][1] = queries[i][0];
                sortedQueries[i][2] = queries[i][1];
            }

            Arrays.sort(sortedQueries, Comparator.comparingInt(a -> -a[2]));


            Integer[] sortedHeight = new Integer[heights.length];
            for (int i = 0; i < heights.length; i++) {
                sortedHeight[i] = heights[i];
            }

            Arrays.sort(sortedHeight, Comparator.<Integer>comparingInt(it -> heights[it]).thenComparingInt(i -> -i));

            PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.<Integer>comparingInt(it -> heights[it]).thenComparingInt(i -> -i));
            for (int i = 0; i < heights.length; i++) {
                pq.add(i);
            }



//            System.out.println(pq.stream().toList());

            /*



            x, 3,
            y, 2,
            z, 1



             */
            for (int i = 0; i < sortedQueries.length; i++) {
                if (sortedQueries[i][1] == sortedQueries[i][2] ||
                        heights[sortedQueries[i][1]] < heights[sortedQueries[i][2]]) {
                    res[sortedQueries[i][0]] = sortedQueries[i][2];
                } else {
                    int index = pq.peek();
                    while (!pq.isEmpty() && heights[sortedQueries[i][1]] >= heights[index]) {
                        index = pq.poll();
                    }
                    if (heights[sortedQueries[i][1]] < heights[index]) {
                        res[sortedQueries[i][0]] = index;
                    }
                }
            }

            return res;
        }

    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().leftmostBuildingQueries(
                new int[]{6,4,8,5,2,7},
                new int[][]{
                        {0,1},
                        {0,3},
                        {2,4},
                        {3,4},
                        {2,2}
                }
        )));

        System.out.println(Arrays.toString(new Solution().leftmostBuildingQueries(
                new int[]{5,3,8,2,6,1,4,6},
                new int[][]{
                        {0,7},
                        {3,5},
                        {5,2},
                        {3,0},
                        {1,6}
                }
        )));
    }
}
