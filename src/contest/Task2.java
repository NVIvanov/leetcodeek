package contest;

import java.util.HashMap;
import java.util.Map;

public class Task2 {
    static class Solution {
        Map<String, Long> map = new HashMap<>();

        public long shiftDistance(String s, String t, int[] nextCost, int[] previousCost) {
            long totalCost = 0;
            for (int i = 0; i < s.length(); i++) {
                long cost = calcCost(s.charAt(i), t.charAt(i), nextCost, previousCost);
                totalCost += cost;
            }
            return totalCost;
        }

        private long calcCost(char a, char b, int[] nextCost, int[] prevCost) {
            char aw = a;
            if (map.containsKey(a + "" + b)) {
                return map.get(a + "" + b);
            }
            long costNext = 0;
            while (aw != b) {
                costNext += nextCost[aw - 'a'];
                if (aw == 'z') {
                    aw = 'a';
                } else {
                    aw++;
                }
            }
            long costPrev = 0;
            aw = a;
            while (aw != b) {
                costPrev += prevCost[aw - 'a'];
                if (aw == 'a') {
                    aw = 'z';
                } else {
                    aw--;
                }
            }
            long minCost = Math.min(costNext, costPrev);
            map.put(a + "" + b, minCost);
            return minCost;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().shiftDistance("abab", "baba",
                new int[]{100,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                new int[]{1,100,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}));
        System.out.println(new Solution().shiftDistance("leet", "code",
                new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
                new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}));
    }
}
