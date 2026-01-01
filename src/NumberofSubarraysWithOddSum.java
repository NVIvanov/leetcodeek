public class NumberofSubarraysWithOddSum {
    static class Solution {
        int[][] dp;

        /*

            1   2   3

                0   1   2
            0   1   2   2
            1       2   3
            2           4

         */
        public int numOfSubarrays(int[] arr) {
            dp = new int[arr.length][arr.length];
            for (int i = 0; i < arr.length; i++) {
                for (int j = i; j < arr.length; j++) {
                    int previousPositionOddSubarrays = numberOfOddSubarraysForPreviousPosition(arr, i, j);
                    if (j == i) {
                        dp[i][j] = previousPositionOddSubarrays + (arr[i] % 2 == 1 ? 1 : 0);
                    } else {
                        boolean previousIsOdd = isSubarrayAtPositionIsOdd(arr, i, j - 1);
                        if (previousIsOdd && arr[j] % 2 == 0 || !previousIsOdd && arr[j] % 2 == 1) {
                            dp[i][j] = previousPositionOddSubarrays + 1;
                        } else {
                            dp[i][j] = previousPositionOddSubarrays;
                        }
                    }
                }
            }
            return dp[arr.length - 1][arr.length - 1];
        }

        private boolean isSubarrayAtPositionIsOdd(int[] arr, int l, int r) {
            return numberOfOddSubarraysForPreviousPosition(arr, l, r) != dp[l][r];
        }

        private int numberOfOddSubarraysForPreviousPosition(int[] arr, int l, int r) {
            int previousOddNumberOfSubarrays;
            if (r > l) {
                previousOddNumberOfSubarrays = dp[l][r - 1];
            } else {
                if (l > 0) {
                    previousOddNumberOfSubarrays = dp[l - 1][dp.length - 1];
                } else {
                    previousOddNumberOfSubarrays = 0;
                }
            }
            return previousOddNumberOfSubarrays;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().numOfSubarrays(new int[]{1,2,3,4,5,6,7}));
    }
}
