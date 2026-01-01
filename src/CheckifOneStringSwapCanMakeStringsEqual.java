public class CheckifOneStringSwapCanMakeStringsEqual {

    static class Solution {
        public boolean areAlmostEqual(String s1, String s2) {
            int sum1 = 0, sum2 = 0, count = 0;
            for (int i = 0; i < s1.length(); i++) {
                if (s1.charAt(i) != s2.charAt(i)) {
                    count++;
                    if (count > 2) {
                        return false;
                    }
                }
                sum1 += s1.charAt(i);
                sum2 += s2.charAt(i);
            }
            return sum1 == sum2;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().areAlmostEqual("bank", "kanb"));
    }
}
