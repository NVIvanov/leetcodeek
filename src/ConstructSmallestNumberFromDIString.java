public class ConstructSmallestNumberFromDIString {
    static class Solution {
        public String smallestNumber(String pattern) {
            int[] res = new int[pattern.length() + 1];
            for (int i = 0; i < res.length; i++) {
                res[i] = i + 1;
            }
            int accD = 0;
            for (int i = pattern.length() - 1; i >= 0; i--) {
                if (pattern.charAt(i) == 'D') {
                    if (accD == 0) {
                        accD = res[i + 1];
                    }
                    res[i] = accD;
                } else {
                    if (accD != 0) {
                        accD = 0;
                    }
                }
            }
            accD = 0;
            for (int i = 0; i < pattern.length(); i++) {
                if (pattern.charAt(i) == 'D') {
                    accD++;
                    res[i + 1] -= accD;
                } else {
                    accD = 0;
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int re : res) {
                sb.append(re);
            }
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().smallestNumber("DDIDDIID"));
    }
}
