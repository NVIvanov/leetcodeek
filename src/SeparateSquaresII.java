import java.util.*;

public class SeparateSquaresII {

    static class Solution {
        public double separateSquares(int[][] squares) {
            int[] ys = new int[squares.length * 2];
            int ysIndex = 0;
            for (int[] square: squares) {
                ys[ysIndex++] = square[1];
                ys[ysIndex++] = square[1] + square[2];
            }

            Map<Integer, List<Integer>> levels = new HashMap<>();


            Arrays.sort(ys);
            System.out.println(Arrays.toString(ys));
            return 0;
        }

    }

    public static void main(String[] args) {
        System.out.println(new Solution().separateSquares(new int[][]{
                {0, 0, 2}, {1, 1, 1}
        }));
    }
}
