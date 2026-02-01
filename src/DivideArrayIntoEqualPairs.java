import java.util.HashMap;
import java.util.Map;

public class DivideArrayIntoEqualPairs {
    class Solution {
        public boolean divideArray(int[] nums) {
            Map<Integer, Boolean> oddCounts = new HashMap<>();
            for (var num: nums) {
                oddCounts.put(num, oddCounts.getOrDefault(num, false) ^ true);
            }
            for (var key: oddCounts.keySet()) {
                if (oddCounts.get(key)) {
                    return false;
                }
            }
            return true;
        }
    }
}
