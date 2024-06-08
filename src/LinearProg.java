import java.util.Arrays;

public class LinearProg {

    public static int[][] table(String a, String b) {
        int[][] res = new int[a.length()][b.length()];
        for (int i = 0; i < a.length(); i++) {
            for (int j = 0; j < b.length(); j++) {
                if (a.charAt(i) == b.charAt(j)) {
                    var prev = 0;
                    if (i > 0 && j > 0) {
                        prev = res[i-1][j-1];
                    }
                    res[i][j] = prev + 1;
                } else {
                    var left = 0;
                    var upper = 0;
                    if (i > 0) {
                        upper = res[i-1][j];
                    }
                    if (j > 0) {
                        left = res[i][j-1];
                    }
                    res[i][j] = Math.max(left, upper);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        var res = table("fish", "fosh");
        for (int[] re : res) {
            for (int i : re) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
