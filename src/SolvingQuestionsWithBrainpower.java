public class SolvingQuestionsWithBrainpower {
    class Solution {
        public long mostPoints(int[][] questions) {
            int n = questions.length;
            long[] dp = new long[n + 1];
            for (int i = n - 1; i >= 0; i--) {
                int nextIndex = Math.min(i + questions[i][1] + 1, n);
                System.out.println("i: " + i + ", nextIndex: " + nextIndex);
                dp[i] = Math.max(dp[i + 1], questions[i][0] + dp[nextIndex]);
                System.out.println("dp[" + i + "]: " + dp[i]);
                System.out.println("questions[" + i + "][0]: " + questions[i][0]);
                System.out.println("questions[" + i + "][1]: " + questions[i][1]);
                System.out.println("dp[i + 1]: " + dp[i + 1]);
                System.out.println("dp[nextIndex]: " + dp[nextIndex]);
                System.out.println("dp[i] after max: " + dp[i]);
                System.out.println("-----");
            }
            return dp[0];
        }
    }

    public static void main(String[] args) {
        int[][] questions = {
                {3, 2},
                {4, 3},
                {4, 4},
                {2, 1},
                {1, 1}
        };
        Solution solution = new SolvingQuestionsWithBrainpower().new Solution();
        long result = solution.mostPoints(questions);
        System.out.println("Result: " + result);
    }
}
