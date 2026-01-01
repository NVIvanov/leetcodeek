public class ClearDigits {

    static class Solution {
        public String clearDigits(String s) {
            StringBuilder res = new StringBuilder();
            int skip = 0;
            for (int i = s.length() - 1; i >= 0; i--) {
                if (Character.isDigit(s.charAt(i))) {
                    skip++;
                    continue;
                }
                if (skip > 0) {
                    skip--;
                    continue;
                }
                res.append(s.charAt(i));
            }
            return res.reverse().toString();
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().clearDigits("a5bcd123"));
    }
}
