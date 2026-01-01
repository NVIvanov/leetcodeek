import java.util.*;

public class ConstructtheLexicographicallyLargestValidSequence {

    static class Solution {
        public int[] constructDistancedSequence(int n) {
            int[] res = new int[2 * n - 1];
            SortedSet<Integer> remaining = new TreeSet<>(Comparator.reverseOrder());
            for (int i = 1; i <= n; i++) {
                remaining.add(i);
            }
            boolean foundSequence = false;
            int i = n;
            while (!foundSequence && i > 0) {
                remaining.remove(i);
                foundSequence = fillNextNumber(res, 0, i, remaining);
                remaining.add(i);
                i--;
            }
            return res;
        }

        private boolean fillNextNumber(int[] nums, int index, int n, SortedSet<Integer> remaining) {
            if (n != 1 && (nums[index] != 0 || index + n >= nums.length || nums[index + n] != 0)) {
                return false;
            }
            if (n == 1 && nums[index] != 0) {
                return false;
            }
            nums[index] = n;
            if (n != 1) {
                nums[index + n] = n;
            }
            if (remaining.isEmpty()) {
                return true;
            }
            var iterate = new ArrayList<>(remaining);
            var nextIndex = index + 1;
            for (int i = nextIndex; i < nums.length; i++) {
                if (nums[nextIndex] != 0) {
                    nextIndex++;
                }
            }
            for (Integer next : iterate) {
                remaining.remove(next);
                var result = fillNextNumber(nums, nextIndex, next, remaining);
                if (result) {
                    return true;
                }
                remaining.add(next);
            }
            nums[index] = 0;
            if (n != 1) {
                nums[index + n] = 0;
            }
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().constructDistancedSequence(5)));
    }
}
