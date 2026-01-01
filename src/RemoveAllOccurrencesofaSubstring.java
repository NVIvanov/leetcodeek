import java.util.Stack;

public class RemoveAllOccurrencesofaSubstring {
    static class Solution {
        public String removeOccurrences(String s, String part) {
            while (s.contains(part)) {
                s = s.replaceFirst(part, "");
            }
            return s;
        }
    }

    public static void main(String[] args) {

    }
}
