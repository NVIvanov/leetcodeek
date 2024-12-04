public class MakeStringaSubsequenceUsingCyclicIncrements {
    static class Solution {
        public boolean canMakeSubsequence(String str1, String str2) {
            int f = 0, s = 0;
            while (f < str1.length() && s < str2.length()) {
                int diff = str2.charAt(s) - str1.charAt(f);
                if (diff == 0 || diff == 1 || diff == -25) {
                    s++;
                }
                f++;
            }
            return s == str2.length();
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().canMakeSubsequence("zc", "ad"));
    }
}
