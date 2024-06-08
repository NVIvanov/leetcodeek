public class ReversePrefixofWord {

    public static String reversePrefix(String word, char ch) {
        return new StringBuilder(word.substring(0, word.indexOf(ch) + 1)).reverse() + word.substring(word.indexOf(ch) + 1);
    }

    public static void main(String[] args) {
        System.out.println(reversePrefix("abcdefd", 'd'));
    }
}
