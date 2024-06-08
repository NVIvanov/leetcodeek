import java.util.Arrays;

public class CherryPickup {

    public static int cherryPickup(int[][] grid) {
        int answer = 0;
        int[][][] res = new int[2][grid[0].length][grid[0].length];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                Arrays.fill(res[i][j], -1);
            }
        }

        res[0][0][grid[0].length-1] = grid[0][0] + grid[0][grid[0].length-1];
        // 1 ->

        for (int i = 1; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                for (int k = j + 1; k < grid[i].length; k++) {
                    int max = -1;
                    for (int a =-1; a <= 1; a++) {
                        for (int b =-1; b <= 1; b++) {
                            if (j + a >= 0 && j + a < grid[i].length && k + b >= 0 && k + b < grid[i].length)
                                max = Math.max(max, res[(i+1)%2][j+a][k+b]);
                        }
                    }
                    if(max != -1){
                        res[i % 2][j][k] = max + grid[i][j] + grid[i][k];
                    }
                    if(answer < res[i%2][j][k]) {
                        answer = res[i%2][j][k];
                    }
                }
            }

        }

        return answer;
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {1, 0, 0, 0, 0, 0, 1},
                {2, 0, 0, 0, 0, 3, 0},
                {2, 0, 9, 0, 0, 0, 0},
                {0, 3, 0, 5, 4, 0, 0},
                {1, 0, 2, 3, 0, 0, 6}
        };

        System.out.println(cherryPickup(grid));
    }
}
