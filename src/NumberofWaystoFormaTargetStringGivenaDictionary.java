import java.util.Arrays;

public class NumberofWaystoFormaTargetStringGivenaDictionary {

    static class Solution {
        public int numWays(String[] words, String target) {

            int[][] freq = new int[words[0].length()][26];
            for (String word : words) {
                for (int j = 0; j < word.length(); j++) {
                    freq[j][word.charAt(j) - 'a']++;
                }
            }

            int[][] dp = new int[words[0].length()][target.length()];
            for (int i = 0; i < words[0].length(); i++) {
                Arrays.fill(dp[i], -1);
            }

            return (int) waysCount(words, target, 0, 0, dp, freq);
        }

        private long waysCount(
                String[] words,
                String target,
                int wordIndex,
                int targetIndex,
                int[][] dp,
                int[][] freq
        ) {
            if (target.length() == targetIndex) {
                return 1;
            }

            if (wordIndex == words[0].length() || words[0].length() - wordIndex < target.length() - targetIndex) {
                return 0;
            }

            long ways = 0;
            int pos = target.charAt(targetIndex) - 'a';

            ways += waysCount(words, target, wordIndex + 1, targetIndex, dp, freq);
            ways += freq[wordIndex][pos] * waysCount(words, target, wordIndex + 1, targetIndex + 1, dp, freq);

            dp[wordIndex][targetIndex] = (int) ways % 1_000_000_007;
            return dp[wordIndex][targetIndex];
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().numWays(new String[]{"acca", "bbbb", "caca"}, "aba"));
    }
}
