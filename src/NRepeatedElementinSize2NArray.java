import java.util.HashSet;
import java.util.Set;

public class NRepeatedElementinSize2NArray {

    static class Solution {
        public int repeatedNTimes(int[] nums) {
            Set<Integer> metNumbers = new HashSet<>();
            for (int num: nums) {
                if (metNumbers.contains(num)) {
                    return num;
                }
                metNumbers.add(num);
            }
            return -1;
        }
    }

    public static void main(String[] args) {

    }
}
