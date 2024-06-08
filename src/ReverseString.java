import java.util.Arrays;

public class ReverseString {

    public void reverseString(char[] s) {
        for (int i = 0; i < s.length / 2; i++) {
            s[i] = (char) (s[s.length - 1 - i] + s[i]);
            s[s.length - 1 - i] = (char) (s[i] - s[s.length - 1 - i]);
            s[i] = (char) (s[i] - s[s.length - 1 - i]);
        }
        System.out.println(Arrays.toString(s));
    }

    public static void main(String[] args) {
        new ReverseString().reverseString(new char[]{'h', 'e', 'l', 'l', 'o'});
    }
}
