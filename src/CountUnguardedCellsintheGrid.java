public class CountUnguardedCellsintheGrid {
    static class Solution {
        Integer GUARD = 1;
        Integer WALL = 2;
        Integer GUARDED = 3;

        public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
            int[][] map = new int[m][n];
            for (int i = 0; i< walls.length; i++) {
                map[walls[i][0]][walls[i][1]] = WALL;
            }
            for (int i = 0; i < guards.length; i++) {
                map[guards[i][0]][guards[i][1]] = GUARD;
            }

            for (int i = 0; i < guards.length; i++) {
                fillGuard(map, guards[i][0], guards[i][1]);
            }
            int count = 0;
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[i].length; j++) {
                    if (map[i][j] == 0) {
                        count++;
                    }
                }
            }
            return count;
        }

        private void fillGuard(int[][] map, int x, int y) {
            for (int j = y + 1; j < map[0].length; j++) {
                if (map[x][j] == WALL || map[x][j] == GUARD) {
                    break;
                }
                map[x][j] = GUARDED;
            }
            for (int j = y - 1; j >= 0; j--) {
                if (map[x][j] == WALL || map[x][j] == GUARD) {
                    break;
                }
                map[x][j] = GUARDED;
            }
            for (int i = x + 1; i < map.length; i++) {
                if (map[i][y] == WALL || map[i][y] == GUARD) {
                    break;
                }
                map[i][y] = GUARDED;
            }
            for (int i = x - 1; i >= 0; i--) {
                if (map[i][y] == GUARD || map[i][y] == WALL) {
                    break;
                }
                map[i][y] = GUARDED;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int unguarded = solution.countUnguarded(
                4, 6,
                new int[][]{
                        {0, 0},
                        {1, 1},
                        {2, 3}
                },
                new int[][]{
                        {0, 1},
                        {2, 2},
                        {1, 4}
                }
        );
        System.out.println(unguarded);
    }
}
