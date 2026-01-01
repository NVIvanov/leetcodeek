package adventofcode2024;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FindLongestSpecialSubstringThatOccursThriceI {

    static class Solution {
        public int maximumLength(String s) {
            int a = 1, b = s.length();
            int result = -1;
            while (a <= b) {
                int mid = a + (b - a) / 2;
                if (hasSpecial(s, mid)) {
                    result = mid;
                    a = mid + 1;
                } else {
                    b = mid - 1;
                }
            }
            return result;
        }

        private boolean hasSpecial(String s, int window) {
            Map<Character, Integer> symCount = new HashMap<>();
            Map<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < window - 1; i++) {
                symCount.merge(s.charAt(i), 1, Integer::sum);
            }
            for (int i = 0; i < s.length() - window + 1; i++) {
                symCount.merge(s.charAt(i + window - 1), 1, Integer::sum);
                if (symCount.keySet().size() == 1) {
                    map.merge(s.charAt(i), 1, Integer::sum);
                }
                symCount.merge(s.charAt(i), -1, Integer::sum);
                symCount.remove(s.charAt(i), 0);
            }
            return map.values().stream().anyMatch(it -> it >= 3);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maximumLength("aaa"));
    }
}
