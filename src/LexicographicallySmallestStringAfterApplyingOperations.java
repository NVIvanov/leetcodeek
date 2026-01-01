import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class LexicographicallySmallestStringAfterApplyingOperations {

    static class Solution {
        public String findLexSmallestString(String s, int a, int b) {
            String smallest = s;
            Set<String> processed = new HashSet<>();
            Queue<String> toVisit = new LinkedList<>();
            toVisit.add(s);
            while (!toVisit.isEmpty()) {
                Set<String> nextToVisit = new HashSet<>();
                while (!toVisit.isEmpty()) {
                    String curr = toVisit.poll();
                    processed.add(curr);
                    if (compareLexigraphically(smallest, curr) > 0) {
                        smallest = curr;
                    }
                    String shifted = applyShift(curr, b);
                    String incremented = addNumbers(curr, a);
                    if (!processed.contains(shifted)) {
                        nextToVisit.add(shifted);
                    }
                    if (!processed.contains(incremented)) {
                        nextToVisit.add(incremented);
                    }
                }
                toVisit.addAll(nextToVisit);
            }
            return smallest;
        }

        private int compareLexigraphically(String a, String b) {
            for (int i = 0; i < a.length(); i++) {
                if (a.charAt(i) < b.charAt(i)) {
                    return -1;
                } else if (a.charAt(i) > b.charAt(i)) {
                    return 1;
                }
            }
            return 0;
        }

        public String applyShift(String s, int b) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                sb.append(s.charAt(shiftRight(i, b, s.length())));
            }
            return sb.toString();
        }

        private int shiftRight(int i, int b, int l) {
            if (i - b < 0) {
                return i - b + l;
            }
            return i - b;
        }

        private String addNumbers(String s, int a) {
            StringBuilder sb = new StringBuilder(s);
            for (int i = 1; i < s.length(); i+=2) {
                sb.setCharAt(i, nextChar(s.charAt(i), a));
            }
            return sb.toString();
        }

        private char nextChar(char c, int a) {
            char n = (char) (c + a);
            if (n > '9') {
                n-=10;
            }
            return n;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findLexSmallestString("0011", 4, 2));
    }
}
