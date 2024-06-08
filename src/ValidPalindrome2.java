public class ValidPalindrome2 {

    public static boolean validPalindrome(String s) {
        return validPalindrome(s, 0, s.length() - 1, false);
    }

    public static boolean validPalindrome(String s, int i, int j, boolean isDeleted) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                if (isDeleted) {
                    return false;
                }
                return validPalindrome(s, i + 1, j, true) || validPalindrome(s, i, j - 1, true);
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(validPalindrome("aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga"));
    }
}
