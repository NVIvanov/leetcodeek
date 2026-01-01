package contest.dec212024;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Task3 {

    static class Solution {
        public boolean checkValidCuts(int n, int[][] rectangles) {

            // Sort rectangles by x and y coordinates
            Arrays.sort(rectangles, Comparator.comparingInt(a -> a[0]));

            // Check for at least two vertical cuts
            int leftMax = rectangles[0][2];
            List<Integer> verticalCuts = new ArrayList<>();
            for (int i = 0; i < rectangles.length - 1; i++) {
                leftMax = Math.max(leftMax, rectangles[i][2]);
                int rightMin = rectangles[i + 1][0];
                if (leftMax <= rightMin) {
                    verticalCuts.add(i);
                }
            }
            if (verticalCuts.size() >= 2) {
                return true;
            }

            // Sort rectangles by y coordinates
            Arrays.sort(rectangles, Comparator.comparingInt(a -> a[1]));

            // Check for at least two horizontal cuts
            int bottomMax = rectangles[0][3];
            List<Integer> horizontalCuts = new ArrayList<>();
            for (int i = 0; i < rectangles.length - 1; i++) {
                bottomMax = Math.max(bottomMax, rectangles[i][3]);
                int topMin = rectangles[i + 1][1];
                if (bottomMax <= topMin) {
                    horizontalCuts.add(i);
                }
            }
            if (horizontalCuts.size() >= 2) {
                return true;
            }

            return false;
        }

    }

    public static void main(String[] args) {
        System.out.println(new Solution().checkValidCuts(5, new int[][]{
                {1,0,5,2}, {0,2,2,4}, {3,2,5,3}, {0,4,4,5}
        }));
    }
}
