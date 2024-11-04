public class StringCompressionIII {

    static class Solution {
        public String compressedString(String word) {
            int count = 0;
            char c, prevC = word.charAt(0);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                c = word.charAt(i);
                if (c == prevC) {
                    if (count < 9) {
                        count++;
                    } else {
                        sb.append("9").append(prevC);
                        count = 1;
                    }
                } else {
                    sb.append(count).append(prevC);
                    count = 1;
                }
                prevC = c;
            }
            sb.append(count).append(prevC);
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().compressedString("aaaaaaaaaaaaaabb"));
    }
}
