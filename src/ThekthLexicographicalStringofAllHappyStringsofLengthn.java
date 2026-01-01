public class ThekthLexicographicalStringofAllHappyStringsofLengthn {
    static class Solution {
        public String getHappyString(int n, int k) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                if (i % 2 == 0) {
                    sb.append('a');
                } else {
                    sb.append('b');
                }
            }

            for (int i = 0; i < k - 1; i++) {
                if (!updateNextSubstring(sb)) {
                    return "";
                }
            }

            return sb.toString();
        }

        private boolean updateNextSubstring(StringBuilder sb) {
            boolean updatedWithNoOverflow = false;
            int index = sb.length() - 1;
            while (!updatedWithNoOverflow && index >= 0) {
                var prev = sb.charAt(index);
                var nextCandidate = (char) ((prev) % 3 + 'a');
                if (index > 0) {
                    if (nextCandidate == sb.charAt(index - 1) && nextCandidate > prev ||
                        index < sb.length() - 1 && nextCandidate == sb.charAt(index + 1)) {
                        nextCandidate = (char) ((nextCandidate) % 3 + 'a');
                    }
                }
                if (nextCandidate > prev) {
                    updatedWithNoOverflow = true;
                }
                sb.setCharAt(index, nextCandidate);
                index--;
            }

            return updatedWithNoOverflow;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().getHappyString(3, 9));
    }
}
