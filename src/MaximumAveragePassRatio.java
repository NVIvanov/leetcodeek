import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MaximumAveragePassRatio {

    static class Solution {
        public double maxAverageRatio(int[][] classes, int extraStudents) {
            PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingDouble(it ->
                            (double) it[0] / it[1] - (double) (it[0] + 1) / (it[1] + 1)));

            for (int i = 0; i < classes.length; i++) {
                if (classes[i][0] != classes[i][1]) {
                    queue.offer(classes[i]);
                }
            }

            for (int i = 0; i < extraStudents && !queue.isEmpty(); i++) {
                int[] polled = queue.poll();
                polled[0]++;
                polled[1]++;
                queue.offer(polled);
            }

            return Arrays.stream(classes)
                    .mapToDouble(it -> (double) it[0] / it[1])
                    .average().orElse(0);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxAverageRatio(new int[][]{
                {2, 4},
                {3, 9},
                {4, 5},
                {2, 10}
        }, 4));
    }
}
