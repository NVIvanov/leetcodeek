public class MaximumMatrixSum {

    static class Solution {
        public long maxMatrixSum(int[][] matrix) {
            long sum = 0;
            int smallest = Integer.MAX_VALUE;
            int negCount = 0;
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    if (matrix[i][j] < 0) {
                        negCount++;
                    }
                    sum += Math.abs(matrix[i][j]);
                    smallest = Math.min(Math.abs(matrix[i][j]), smallest);
                }
            }

            return negCount % 2 == 0 ? sum : sum - (2L * smallest);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxMatrixSum(new int[][]{
                {10,-6,-6,-8},
                {-3,-7,-8,-9},
                {-4,-8,-5,-8},
                {-9,-9,-6,-8}
        }));
    }

}
