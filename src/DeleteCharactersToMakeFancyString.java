public class DeleteCharactersToMakeFancyString {

    static class Solution {
        public String makeFancyString(String s) {
            int consecutive = 0;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                if (i > 0 && s.charAt(i - 1) == s.charAt(i)) {
                    if (consecutive != 1) {
                        sb.append(s.charAt(i));
                        consecutive++;
                    }
                } else {
                    sb.append(s.charAt(i));
                    consecutive = 0;
                }
            }
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().makeFancyString("leetcodeeeee"));
    }
}
