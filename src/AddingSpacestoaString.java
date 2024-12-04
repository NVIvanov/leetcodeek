public class AddingSpacestoaString {

    static class Solution {
        public String addSpaces(String s, int[] spaces) {
            StringBuilder sb = new StringBuilder();
            int spaceIndex = 0;
            for (int i = 0; i < s.length(); i++) {
                if (spaceIndex < spaces.length && spaces[spaceIndex] == i) {
                    spaceIndex++;
                    sb.append(' ');
                    i--;
                } else {
                    sb.append(s.charAt(i));
                }
            }
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().addSpaces("LeetcodeHelpsMeLearn", new int[]{8, 8, 13, 15}));
    }
}
