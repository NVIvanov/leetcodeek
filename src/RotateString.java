public class RotateString {

    static class Solution {
        public boolean rotateString(String s, String goal) {
            if (s.length() != goal.length()) {
                return false;
            }
            for (int i = 0; i < s.length(); i++) {
                if (equalsFromIndex(s, goal, i)) {
                    return true;
                }
            }
            return false;
        }

        private boolean equalsFromIndex(String a, String b, int index) {
            for (int i = 0; i < a.length(); i++) {
                if (a.charAt((i + index) % a.length()) != b.charAt(i)) {
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().rotateString("abcde", "cdeab"));
    }
}
