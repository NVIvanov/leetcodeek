public class CircularSentence {

    static class Solution {


        /*
            aaa aaa aaa
            0

            if i < sentence.length - 1 &&

         */

        public boolean isCircularSentence(String sentence) {
            if (sentence.charAt(0) != sentence.charAt(sentence.length()-1)) {
                return false;
            }
            for (int i = sentence.indexOf(' '); i != -1; i = sentence.indexOf(' ', i + 1)) {
                if (sentence.charAt(i - 1) != sentence.charAt(i + 1)) {
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isCircularSentence("leetcode exercises sound delightful"));
    }
}
