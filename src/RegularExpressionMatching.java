public class RegularExpressionMatching {

    public boolean isMatch(String s, String p) {
        Boolean[][] dp = new Boolean[s.length() + 1][p.length() + 1];
        return fillDp(dp, s, p, 0, 0);
    }

    private static boolean fillDp(Boolean[][] dp, String s, String p, int i, int j) {
        if (dp[i][j] != null) {
            return dp[i][j];
        }
        boolean result;
        if (j == p.length()) {
            result = i == s.length();
        } else {
            boolean symMatch = i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
            if (j + 1 < p.length() &&  p.charAt(j + 1) == '*') {
                result = fillDp(dp, s, p, i, j+2) || symMatch && fillDp(dp, s, p, i + 1, j);
            } else {
                result = symMatch && fillDp(dp, s, p, i + 1, j + 1);
            }
        }
        dp[i][j] = result;
        return dp[i][j];
    }
}
