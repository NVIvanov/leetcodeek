import java.util.HashMap;
import java.util.Map;

public class TuplewithSameProduct {


    static class Solution {
        public int tupleSameProduct(int[] nums) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    map.put(nums[i] * nums[j], map.getOrDefault(nums[i] * nums[j], 0) + 1);
                }
            }
            return map.values()
                    .stream()
                    .mapToInt(value -> 2 * value * 2 * (value - 1))
                    .sum();
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().tupleSameProduct(new int[]{2,3,4,6}));
    }
}
