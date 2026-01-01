public class CountServersthatCommunicate {

    static class Solution {
        public int countServers(int[][] grid) {
            int[] horizontal = new int[grid.length];
            int[] vertical = new int[grid[0].length];

            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (grid[i][j] == 1) {
                        horizontal[i]++;
                        vertical[j]++;
                    }
                }
            }

            int count = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (grid[i][j] == 1 && (horizontal[i] > 1 || vertical[j] > 1)) {
                        count++;
                    }
                }
            }

            return count;
        }
    }
}
