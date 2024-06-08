public class ValidParenthesisString {

    public static boolean checkValidString(String s) {
        short minOpen = 0, maxOpen = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                minOpen++;
                maxOpen++;
            }
            if (s.charAt(i) == ')') {
                minOpen = (short) Math.max(minOpen - 1, 0);
                maxOpen--;
            }
            if (s.charAt(i) == '*') {
                minOpen = (short) Math.max(minOpen - 1, 0);
                maxOpen++;
            }
            if (maxOpen < 0) {
                return false;
            }
        }
        return minOpen == 0;
    }

    public static void main(String[] args) {
        System.out.println(checkValidString("(()"));
    }
}
