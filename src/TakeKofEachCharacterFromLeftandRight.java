import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class TakeKofEachCharacterFromLeftandRight {

    static class Solution {
        public int takeCharacters(String s, int k) {
            if (k == 0) {
                return 0;
            }
            int[] a = takeCharacters(s, 'a', k);
            int[] b = takeCharacters(s, 'b', k);
            int[] c = takeCharacters(s, 'c', k);
            if (a == null || b == null || c == null) {
                return -1;
            }
            return
                    s.length()
                    - Math.min(a[1], Math.min(b[1], c[1]))
                    + Math.max(a[0], Math.max(b[0], c[0]))
                    + 1;
        }

        private int[] takeCharacters(String s, char c, int k) {
            Deque<Integer> indices = new ArrayDeque<>();
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == c) {
                    indices.offer(i);
                }
            }
            if (indices.size() < k) {
                return null;
            }
            int l = 0, r = s.length();
            int count = 0;
            while (count < k) {
                if (indices.peek() < (s.length() - indices.peekLast())) {
                    l = indices.poll();
                } else {
                    r = indices.pollLast();
                }
                count++;
            }
            return new int[]{l, r};
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().takeCharacters("acba", 1));
    }
}
