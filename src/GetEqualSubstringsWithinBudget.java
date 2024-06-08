public class GetEqualSubstringsWithinBudget {

    public static int equalSubstring(String s, String t, int maxCost) {
        int sum = 0, maxLength = 0, l = 0, r = 0;
        while (l < s.length() && r < t.length()) {
            while (sum <= maxCost && r < t.length()) {
                sum += diff(s, t, r++);
                if (sum <= maxCost) {
                    maxLength = Math.max(maxLength, r - l);
                }
            }
            sum -= diff(s, t, l);
            l++;
            if (r < l) {
                r = l;
                sum = diff(s, t, l);
            }
        }
        return maxLength;
    }

    private static int diff(String s, String t, int i) {
        return Math.abs(s.charAt(i) - t.charAt(i));
    }

    public static void main(String[] args) {
        System.out.println(equalSubstring("krrgw", "zjxss", 19));
    }
}
