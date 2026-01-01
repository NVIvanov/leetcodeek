public class MaximumScoreAfterSplittingaString {

    static class Solution {
        public int maxScore(String s) {
            int zeroScore = 0;
            int oneScore = 0;
            int maxScore = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '1') {
                    oneScore++;
                }
            }

            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '0') {
                    zeroScore++;
                }
                if (s.charAt(i) == '1') {
                    oneScore--;
                }
                maxScore = Math.max(maxScore, oneScore + zeroScore);
            }

            return maxScore;
        }
    }

    public static void main(String[] args) {

    }
}
