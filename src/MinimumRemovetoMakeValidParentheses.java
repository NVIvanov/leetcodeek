import java.util.ArrayDeque;
import java.util.BitSet;
import java.util.Deque;

public class MinimumRemovetoMakeValidParentheses {

    public static String minRemoveToMakeValid(String s) {
        // first run
        int count = 0;
        BitSet bits = new BitSet(s.length());
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                count++;
            } else if (c == ')') {
                if (count > 0) {
                    count--;
                } else {
                    bits.set(i);
                }
            }
        }

        //second run
        count = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            if (bits.get(i)) {
                continue;
            }
            char c = s.charAt(i);
            if (c == ')') {
                count++;
            } else if (c == '('){
                if (count > 0) {
                    count--;
                } else {
                    bits.set(i);
                }
            }
        }
        StringBuilder sb = new StringBuilder(s.length());
        for (int i = 0; i < s.length(); i++) {
            if (!bits.get(i)) {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(minRemoveToMakeValid("))(("));
    }
}
