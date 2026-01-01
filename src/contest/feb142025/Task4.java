package contest.feb142025;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Task4 {
    static class Solution {
        public static int shortestMatchingSubstring(String s, String p) {
            // Verify that p contains exactly two '*' characters.
            int starCount = 0;
            for (char ch : p.toCharArray()) {
                if (ch == '*') starCount++;
            }
            if (starCount != 2) {
                throw new IllegalArgumentException("Pattern must contain exactly two '*' characters.");
            }

            // Split pattern into parts: a, b, c.
            String[] parts = p.split("\\*", -1);
            if (parts.length != 3) {
                throw new IllegalArgumentException("Pattern must contain exactly two '*' characters.");
            }
            String a = parts[0];
            String b = parts[1];
            String c = parts[2];

            // Shortcut cases:
            if (a.isEmpty() && b.isEmpty() && c.isEmpty()) {
                // Pattern "**" — all parts empty: empty string is a match.
                return 0;
            }
            if (a.isEmpty() && b.isEmpty()) {
                // Pattern "**c" → minimal match is c.
                return s.contains(c) ? c.length() : -1;
            }
            if (a.isEmpty() && c.isEmpty()) {
                // Pattern "*b*" → minimal match is b.
                return s.contains(b) ? b.length() : -1;
            }
            if (b.isEmpty() && c.isEmpty()) {
                // Pattern "a**" → minimal match is a.
                return s.contains(a) ? a.length() : -1;
            }

            int best = Integer.MAX_VALUE;
            int n = s.length();

            // Precompute occurrence lists for b and c (if nonempty) using KMP.
            int[] occB = null;
            if (!b.isEmpty()) {
                occB = getOccurrences(s, b);
                if (occB.length == 0) {
                    // If b is required but never occurs, no match is possible.
                    return -1;
                }
            }
            int[] occC = null;
            if (!c.isEmpty()) {
                occC = getOccurrences(s, c);
                if (occC.length == 0) {
                    // If c is required but never occurs, no match is possible.
                    return -1;
                }
            }

            if (!a.isEmpty()) {
                // For nonempty a, only consider indices where a occurs.
                int index = s.indexOf(a);
                while (index != -1) {
                    int start = index;
                    int pos = index + a.length();
                    boolean valid = true;

                    // If b is required, find its first occurrence at or after pos.
                    if (!b.isEmpty()) {
                        int posB = findOccurrence(occB, pos);
                        if (posB == -1) {
                            valid = false;
                        } else {
                            pos = posB + b.length();
                        }
                    }

                    // If c is required, find its first occurrence at or after pos.
                    if (valid && !c.isEmpty()) {
                        int posC = findOccurrence(occC, pos);
                        if (posC == -1) {
                            valid = false;
                        } else {
                            pos = posC + c.length();
                        }
                    }

                    if (valid) {
                        best = Math.min(best, pos - start);
                    }
                    index = s.indexOf(a, index + 1);
                }
            } else {
                // When a is empty, we haven't handled the cases where one of b or c is empty
                // (they were shortcut above), so here both b and c must be nonempty.
                // In this case, an optimal starting index is at an occurrence of b.
                for (int posB : occB) {
                    int pos = posB + b.length();
                    int posC = findOccurrence(occC, pos);
                    if (posC != -1) {
                        best = Math.min(best, (posC + c.length()) - posB);
                    }
                }
            }

            return best == Integer.MAX_VALUE ? -1 : best;
        }

        /**
         * Returns an int array of all starting positions where pat occurs in text s,
         * computed using the KMP algorithm.
         */
        private static int[] getOccurrences(String s, String pat) {
            int m = pat.length();
            int n = s.length();
            int[] pi = new int[m];
            // Build prefix function for pat.
            for (int i = 1; i < m; i++) {
                int j = pi[i - 1];
                while (j > 0 && pat.charAt(i) != pat.charAt(j)) {
                    j = pi[j - 1];
                }
                if (pat.charAt(i) == pat.charAt(j)) {
                    j++;
                }
                pi[i] = j;
            }

            List<Integer> occ = new ArrayList<>();
            int j = 0;
            for (int i = 0; i < n; i++) {
                while (j > 0 && s.charAt(i) != pat.charAt(j)) {
                    j = pi[j - 1];
                }
                if (s.charAt(i) == pat.charAt(j)) {
                    j++;
                }
                if (j == m) {
                    occ.add(i - m + 1);
                    j = pi[j - 1];
                }
            }

            int[] result = new int[occ.size()];
            for (int i = 0; i < occ.size(); i++) {
                result[i] = occ.get(i);
            }
            return result;
        }

        /**
         * Performs binary search on the sorted array occ to find the smallest index
         * in occ that is >= pos. Returns that occurrence or -1 if none is found.
         */
        private static int findOccurrence(int[] occ, int pos) {
            int lo = 0, hi = occ.length - 1;
            int ans = -1;
            while (lo <= hi) {
                int mid = (lo + hi) / 2;
                if (occ[mid] >= pos) {
                    ans = occ[mid];
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 1000000; i++) {
            stringBuilder.append(random.nextInt(0, 9));
        }
        String s = stringBuilder.toString();
        String p = s.substring(0, 20000) + '*' + s.substring(20002, 30000) + '*' + s.substring(30002);
        System.out.println(new Solution().shortestMatchingSubstring(s, p));
    }
}
