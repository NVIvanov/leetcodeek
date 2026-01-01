package contest.jan042025;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

public class Task3 {

    static class Solution {
        public int longestSubsequence(int[] nums) {

            int n = nums.length;
            DescendingDifferences[] dp = new DescendingDifferences[n];
            for (int i = 0; i < n; i++) {
                dp[i] = new DescendingDifferences();
            }
            int maxLen = 1;
            for (int j = 1; j < n; j++) {
                for (int i = 0; i < j; i++) {
                    int diff = Math.abs(nums[j] - nums[i]);
                    int bestChainEndingAtI = dp[i].getMaxForDiffGE(diff);
                    int newLen = (bestChainEndingAtI == 0 ? 1 : bestChainEndingAtI) + 1;
                    dp[j].update(diff, newLen);
                    maxLen = Math.max(maxLen, newLen);
                }
            }
            return maxLen;
        }

        static class DescendingDifferences {
            List<Integer> diffs;
            List<Integer> dpVals;
            List<Integer> suffixMax;

            public DescendingDifferences() {
                diffs = new ArrayList<>();
                dpVals = new ArrayList<>();
                suffixMax = new ArrayList<>();
            }

            public int getMaxForDiffGE(int diff) {
                int left = 0, right = diffs.size() - 1;
                int pos = diffs.size();
                while (left <= right) {
                    int mid = (left + right) / 2;
                    if (diffs.get(mid) >= diff) {
                        left = mid + 1;
                    } else {
                        pos = mid;
                        right = mid - 1;
                    }
                }
                if (pos == 0) {
                    return 0;
                } else {
                    return suffixMax.get(pos-1);
                }
            }

            public void update(int diff, int val) {
                int idx = -1;
                for (int i = 0; i < diffs.size(); i++) {
                    if (diffs.get(i) == diff) {
                        idx = i;
                        break;
                    }
                    if (diffs.get(i) < diff) {
                        idx = i;
                        diffs.add(i, diff);
                        dpVals.add(i, val);
                        suffixMax.add(i, 0);
                        break;
                    }
                }
                if (idx == -1) {
                    idx = diffs.size();
                    diffs.add(diff);
                    dpVals.add(val);
                    suffixMax.add(0);
                } else {
                    dpVals.set(idx, Math.max(dpVals.get(idx), val));
                }
                int from = idx;
                while (from >= 0) {
                    int candidate = dpVals.get(from);
                    int nextVal = (from < suffixMax.size() - 1)
                            ? suffixMax.get(from+1)
                            : 0;
                    suffixMax.set(from, Math.max(candidate, nextVal));
                    from--;
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().longestSubsequence(new int[] { 57,62,94,57,72 }));
    }
}
