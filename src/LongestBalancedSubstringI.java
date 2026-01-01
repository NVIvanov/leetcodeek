import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class LongestBalancedSubstringI {

    static class Solution {
        public int longestBalanced(String s) {
            for (int i = s.length(); i > 0; i--) {
                System.out.println("length = " + i);
                Map<Character, Integer> stats = new HashMap<>();
                Map<Integer, Integer> reverseStats = new HashMap<>();
                int a = 0;
                for (int j = 0; j < s.length(); j++) {
                    reverseStats.computeIfPresent(stats.get(s.charAt(j)), (k, v) -> v - 1);
                    stats.putIfAbsent(s.charAt(j), 0);
                    stats.computeIfPresent(s.charAt(j), (k, v) -> v + 1);
                    if (reverseStats.containsKey(stats.get(s.charAt(j))) &&
                        reverseStats.get(stats.get(s.charAt(j))) == 0) {
                        reverseStats.remove(stats.get(s.charAt(j)));
                    }
                    reverseStats.putIfAbsent(stats.get(s.charAt(j)), 0);
                    reverseStats.computeIfPresent(stats.get(s.charAt(j)), (k, v) -> v + 1);
                    if (j >= i) {
                        System.out.println("decrement position on " + a + " stats is " + stats.get(s.charAt(a)));
                        reverseStats.computeIfPresent(stats.get(s.charAt(a)), (k, v) -> v - 1);
                        stats.computeIfPresent(s.charAt(a), (k, v) -> v - 1);
                        if (reverseStats.containsKey(stats.get(s.charAt(a)))
                            && reverseStats.get(stats.get(s.charAt(a))) == 0) {
                            reverseStats.remove(stats.get(s.charAt(a)));
                        }
                        a++;
                    }
                    System.out.println(stats);
                    System.out.println(reverseStats);
                    System.out.println();
                }
            }
            return 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().longestBalanced(
                "aaaabbb"        ));
    }
}
