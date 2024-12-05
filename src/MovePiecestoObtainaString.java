public class MovePiecestoObtainaString {

    static class Solution {
        public boolean canChange(String start, String target) {
            if (!start.replace("_", "").equals(target.replace("_", ""))) {
                return false;
            }
            int cStart = 0, cTarget = 0;
            for (int i = 0; i < start.length(); i++) {
                if (start.charAt(i) == 'L') {
                    cStart++;
                }
                if (target.charAt(i) == 'L') {
                    cTarget++;
                }
                if (cStart > cTarget) {
                    return false;
                }
            }

            for (int i = start.length() - 1; i >= 0; i--) {
                if (start.charAt(i) == 'R') {
                    cStart++;
                }
                if (target.charAt(i) == 'R') {
                    cTarget++;
                }
                if (cStart > cTarget) {
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {

    }
}
