public class LengthOfLastWord {

    public static int lengthOfLastWord(String s) {
        int l = 0, prevL = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                if (l != 0) {
                    prevL = l;
                }
                l = 0;
            } else {
                l++;
            }
        }
        return l == 0 ? prevL : l;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("   fly me   to   the moon  "));
    }
}
