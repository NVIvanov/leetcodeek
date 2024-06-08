import java.util.Arrays;

public class PalindromicSubstrings {

    public static int countSubstrings(String s) {
        boolean[][] palindrome = new boolean[s.length()][s.length()];
        int res = 0;
        for (int l = 1; l <= s.length(); l++) {
            for (int i = 0; i < s.length() - l + 1; i++) {
                if (s.charAt(i) == s.charAt(i + l - 1) && (l <= 2 || palindrome[i+1][i+l-2])) {
                    palindrome[i][i+l-1] = true;
                    res++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(countSubstrings("aba"));
        /*
            a
            ab
            abc
            b
            ba
            a
         */
    }
}
