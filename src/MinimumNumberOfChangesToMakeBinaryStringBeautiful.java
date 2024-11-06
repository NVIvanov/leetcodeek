public class MinimumNumberOfChangesToMakeBinaryStringBeautiful {

    static class Solution {

        /*

         10
         00

         1010
         0010
         0000

         1001
         0000

         1110
            1
         110011

         */

        public int minChanges(String s) {
            int count = 0;
            for (int i = 0; i < s.length() - 1; i += 2) {
                if (s.charAt(i) != s.charAt(i + 1)) {
                    count++;
                }
            }
            return count;
        }
    }

    public static void main(String[] args) {

    }
}
