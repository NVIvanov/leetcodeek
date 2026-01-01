import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ConstructKPalindromeStrings {

    static class Solution {
        public boolean canConstruct(String s, int k) {
            if (s.length() < k) {
                return false;
            }
            Set<Character> chars = new HashSet<>();
            for (int i = 0; i < s.length(); i++) {
                if (chars.contains(s.charAt(i))) {
                    chars.remove(s.charAt(i));
                } else {
                    chars.add(s.charAt(i));
                }
            }
            return chars.size() <= k;
        }
    }

    public static void main(String[] args) {

    }
}
