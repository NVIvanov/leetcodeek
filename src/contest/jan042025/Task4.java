package contest.jan042025;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Task4 {

    static class Solution {
        public long maxSubarraySum(int[] nums) {
            int best = kadane(nums);

            Set<Integer> distinctValues = new HashSet<>();
            for (int num : nums) {
                distinctValues.add(num);
            }

            for (int x : distinctValues) {
                List<Integer> filteredList = new ArrayList<>();
                for (int val : nums) {
                    if (val != x) {
                        filteredList.add(val);
                    }
                }

                if (filteredList.isEmpty()) {
                    continue;
                }

                int[] filteredArr = new int[filteredList.size()];
                for (int i = 0; i < filteredList.size(); i++) {
                    filteredArr[i] = filteredList.get(i);
                }

                int currentSum = kadane(filteredArr);
                best = Math.max(best, currentSum);
            }

            return best;
        }

        private static int kadane(int[] arr) {
            int maxEndingHere = arr[0];
            int maxSoFar = arr[0];
            for (int i = 1; i < arr.length; i++) {
                maxEndingHere = Math.max(arr[i], maxEndingHere + arr[i]);
                maxSoFar = Math.max(maxSoFar, maxEndingHere);
            }
            return maxSoFar;
        }
    }

    public static void main(String[] args) {

    }
}
