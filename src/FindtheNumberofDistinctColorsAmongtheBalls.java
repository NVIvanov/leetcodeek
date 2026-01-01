import java.util.HashMap;
import java.util.Map;

public class FindtheNumberofDistinctColorsAmongtheBalls {

    static class Solution {
        public int[] queryResults(int limit, int[][] queries) {
            Map<Integer, Integer> colorCount = new HashMap<>();
            Map<Integer, Integer> ballsColors = new HashMap<>();
            int[] res = new int[queries.length];
            for (int i = 0; i < queries.length; i++) {
                int ballNum = queries[i][0];
                int color = queries[i][1];
                if (ballsColors.containsKey(ballNum)) {
                    int existingColor = ballsColors.get(ballNum);
                    if (colorCount.get(existingColor) == 1) {
                        colorCount.remove(existingColor);
                    } else {
                        colorCount.put(existingColor, colorCount.get(existingColor) - 1);
                    }
                }
                ballsColors.put(ballNum, color);
                colorCount.put(color, colorCount.getOrDefault(color, 0) + 1);
                res[i] = colorCount.size();
            }
            return res;
        }
    }

    public static void main(String[] args) {

    }
}
