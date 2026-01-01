import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class FindUniqueBinaryString {
    static class Solution {
        public String findDifferentBinaryString(String[] nums) {
            SortedSet<Integer> set = new TreeSet<>();
            for (String num : nums) {
                set.add(Integer.parseInt(num, 2));
            }

            int resInt = 0;
            double limit = Math.pow(2, nums.length);
            for (int i = 0; i < limit; i++) {
                if (!set.contains(i)) {
                    resInt = i;
                    break;
                }
            }

            String resStr = Integer.toString(resInt, 2);
            StringBuilder sb = new StringBuilder();
            sb.repeat("0", nums.length - resStr.length());
            sb.append(resStr);

            return sb.toString();
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findDifferentBinaryString(new String[]{
                "00", "01"
        }));
    }
}
