public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (true) {
            if (i == strs[0].length()) {
                return sb.toString();
            }
            char c = strs[0].charAt(i);
            for (var str : strs) {
                if (i == str.length()) {
                    return sb.toString();
                }
                if (c != str.charAt(i)) {
                    return sb.toString();
                }
            }
            sb.append(c);
            i++;
        }
    }

    public static void main(String[] args) {

    }
}
