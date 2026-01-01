import java.util.*;

public class MaximumFrequencyofanElementAfterPerformingOperationsI {

    static class Solution {
        public int maxFrequency(int[] nums, int k, int numOperations) {
            Arrays.sort(nums);
            if (numOperations == 0) {
                int maxDistinct = 0;
                int currCount = 0;
                int currentNum = nums[0];
                for (var num : nums) {
                    if (currentNum == num) {
                        currCount++;
                        maxDistinct = Math.max(maxDistinct, currCount);
                    } else {
                        currCount = 1;
                        currentNum = num;
                    }
                }
                return maxDistinct;
            }


            int l = 0, r = 0;
            Map<Integer, Integer> counts = new HashMap<>();
            TreeMap<Integer, List<Integer>> reverseCounts = new TreeMap<>(Comparator.reverseOrder());
            List<Integer> dummyList = new ArrayList<>();
            int maxCount = 0;
            while ((l == 0 && r == 0 || l < r) || l < nums.length || r < nums.length) {
                while (r < nums.length && nums[r] - nums[l] < 2 * k) {
                    counts.putIfAbsent(nums[r], 0);
                    reverseCounts.getOrDefault(counts.get(nums[r]), dummyList).remove((Object) nums[r]);
                    counts.computeIfPresent(nums[r], (key, v) -> v + 1);
                    reverseCounts.putIfAbsent(counts.get(nums[r]), new ArrayList<>());
                    reverseCounts.get(counts.get(nums[r])).add(nums[r]);

                    System.out.println(l + " " + r);
                    maxCount = Math.max(maxCount, Math.min(r - l + 1, numOperations + reverseCounts.firstKey()));
                    System.out.println(counts);
                    System.out.println(reverseCounts);
                    System.out.println("max length = " + maxCount);

                    r++;
                }
                reverseCounts.get(counts.get(nums[l])).remove((Object) nums[l]);
                if (reverseCounts.get(counts.get(nums[l])).isEmpty()) {
                    reverseCounts.remove(counts.get(nums[l]));
                }
                counts.computeIfPresent(nums[l], (key, v) -> v - 1);
                if (counts.containsKey(nums[l]) && counts.get(nums[l]) == 0) {
                    counts.remove(nums[l]);
                }
                l++;
                System.out.println(l + " " + r);
                maxCount = Math.max(maxCount, Math.min(r - l + 1,
                        numOperations + (reverseCounts.isEmpty() ? 0 : reverseCounts.firstKey())));
                System.out.println(counts);
                System.out.println(reverseCounts);
                System.out.println("max length = " + maxCount);
            }
            return maxCount;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxFrequency(new int[]{5,11,20,20}, 5, 1));
    }
}
