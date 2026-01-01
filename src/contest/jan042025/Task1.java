package contest.jan042025;

public class Task1 {

    static class Solution {
        public boolean hasMatch(String s, String p) {
            String[] parts = p.split("\\*");
            if (parts.length == 0) {
                return true;
            }
            if (parts.length == 1) {
                return s.contains(parts[0]);
            }
            if (parts[0].isEmpty()) {
                return s.contains(parts[1]);
            }
            int i1 = s.indexOf(parts[0]);
            if (i1 == -1) {
                return false;
            }
            int i2 = s.indexOf(parts[1], i1 + parts[0].length());
            return i2 != -1;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().hasMatch("xxxxqzq", "qzq*qz"));
    }
}
