import java.util.Arrays;

public class LongestCommonSubstring {

    public static void main(String[] args) {
        String b = "abcd";
        String a = "bcde";

        int[][] substringLengths = new int[a.length()][b.length()];

        /*
             a b c d e
           b 0 1 1 1 1
           c 0 1 2 2 2
           d 0 1 2 3 3
           e 0 1 2 3 4
           f 0 1 2 3 4
           g 0 1 2 3 4
         */
        for (int i = 0; i < a.length(); i++) {
            for (int j = 0; j < b.length(); j++) {
                if (a.charAt(i) == b.charAt(j)) {
                    if (i > 0 && j > 0) {
                        substringLengths[i][j] = 1 + substringLengths[i-1][j-1];
                    } else {
                        substringLengths[i][j] = 1;
                    }
                } else {
                    if (i > 0 && j > 0) {
                        substringLengths[i][j] = Math.max(substringLengths[i - 1][j], substringLengths[i][j - 1]);
                    } else if (i > 0) {
                        substringLengths[i][j] = substringLengths[i-1][j];
                    } else if (j > 0){
                        substringLengths[i][j] = substringLengths[i][j-1];
                    }
                }
            }
        }

        Utils.print(substringLengths);

        StringBuilder sb = new StringBuilder();
        int i = substringLengths.length - 1;
        int j = substringLengths[i].length - 1;
        while (i >= 0 && j >= 0 && substringLengths[i][j] > 0) {
            if (a.charAt(i) == b.charAt(j)) {
                sb.append(a.charAt(i));
                i--;j--;
            } else {
                int left = 0;
                if (j > 0) left = substringLengths[i][j-1];
                int upper = 0;
                if (i > 0) upper = substringLengths[i-1][j];
                if (upper > left) {
                    i--;
                } else {
                    j--;
                }
            }
        }

        System.out.println(sb.reverse());
    }
}
