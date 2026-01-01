import java.util.HashMap;
import java.util.Map;

public class FirstCompletelyPaintedRoworColumn {

    static class Solution {
        public int firstCompleteIndex(int[] arr, int[][] mat) {
            int m = mat.length;
            int n = mat[0].length;

            int[] horizontal = new int[m];
            int[] vertical = new int[n];

            Map<Integer, int[]> map = new HashMap<>();

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    map.put(mat[i][j], new int[]{i, j});
                }
            }

            for (int i = 0; i < arr.length; i++) {
                horizontal[map.get(arr[i])[0]]++;
                vertical[map.get(arr[i])[1]]++;
                if (horizontal[map.get(arr[i])[0]] == n || vertical[map.get(arr[i])[1]] == m) {
                    return i;
                }
            }
            return -1;
        }
    }

    public static void main(String[] args) {

    }
}
