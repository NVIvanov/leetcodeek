import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class ValidParentheses {

    public static void main(String[] args) {
        var str = "()[]{}";
        System.out.println(isValid(str));
    }

    public static boolean isValid(String s) {
        var openBrackets = List.of('{', '(', '[');
        var closeBrackets = List.of('}', ')', ']');
        Deque<Character> chars = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            if (openBrackets.contains(s.charAt(i))) {
                chars.push(s.charAt(i));
            } else {
                if (chars.isEmpty()) {
                    return false;
                }
                Character c = chars.poll();
                if (closeBrackets.indexOf(s.charAt(i)) != openBrackets.indexOf(c)) {
                    return false;
                }
            }
        }
        return chars.isEmpty();
    }
}
