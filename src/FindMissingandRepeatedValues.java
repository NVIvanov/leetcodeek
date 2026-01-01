import java.util.*;

public class FindMissingandRepeatedValues {

    static class Solution {
        public int[] findMissingAndRepeatedValues(int[][] grid) {
            int metTwice = 0;
            int sum = 0;
            int targetSum = 0;
            Set<Integer> metNumbers = new HashSet<>();
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (metNumbers.contains(grid[i][j])) {
                        metTwice = grid[i][j];
                    }
                    metNumbers.add(grid[i][j]);
                    sum += grid[i][j];
                    targetSum += i * grid.length + j + 1;
                }
            }
            System.out.println(sum);
            System.out.println(targetSum);
            System.out.println(metTwice);
            return new int[]{metTwice, targetSum - sum + metTwice};
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().findMissingAndRepeatedValues(
                new int[][]{
                        {1,3},
                        {2,2}
                }
        )));
    }
}
