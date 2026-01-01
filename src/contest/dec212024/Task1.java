package contest.dec212024;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Task1 {

    static class Solution {
        public int subsequencesWithMiddleMode(int[] nums) {
            Map<Integer, Integer> map = new HashMap<Integer, Integer>();

            for (int i = 0; i < 4; i++) {
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            }

            int count = 0;

            for (int i = 4; i < nums.length; i++) {
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);

                if (unique(nums, map, i)) {
                    count++;
                    count %= 1000000007;
                }

                map.put(nums[i - 4], map.getOrDefault(nums[i - 4], 0) - 1);
            }
            return count;
        }

        private boolean unique(int[] nums, Map<Integer, Integer> map, int index) {
            List<Integer> list = map.values().stream().sorted(Comparator.reverseOrder()).toList();
            if (list.size() > 1 && list.get(0) == list.get(1)) {
                return false;
            }

            return map.get(nums[index - 2]) == list.get(0);
        }
    }

    public static void main(String[] args) {

    }
}
