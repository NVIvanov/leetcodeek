import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FlipColumnsForMaximumNumberofEqualRows {

    static class Solution {
        public int maxEqualRowsAfterFlips(int[][] matrix) {
            Map<List<Integer>, Integer> map = new HashMap<>();
            for (int i = 0; i < matrix.length; i++) {
                List<Integer> row = new ArrayList<>();
                for (int j = 0; j < matrix[i].length - 1; j++) {
                    if (matrix[i][j] != matrix[i][j + 1]) {
                        row.add(j);
                    }
                }
                map.put(row, map.getOrDefault(row, 0) + 1);
            }
            int max = 0;
            for (Map.Entry<List<Integer>, Integer> entry : map.entrySet()) {
                if (entry.getValue() > max) {
                    max = entry.getValue();
                }
            }
            return max;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxEqualRowsAfterFlips(new int[][]
                {{1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}}));
    }
}
