public class AlternatingGroupsII {

    static class Solution {
        public int numberOfAlternatingGroups(int[] colors, int k) {
            int n = colors.length;
            int count = 0;
            for (int i = 0; i < n; i++) {
                boolean alternating = true;
                for (int j = 1; j < k; j++) {
                    int prevIndex = (i + j - 1) % n;
                    int currIndex = (i + j) % n;
                    if (colors[prevIndex] == colors[currIndex]) {
                        alternating = false;
                        break;
                    }
                }
                if (alternating) {
                    count++;
                }
            }
            return count;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().numberOfAlternatingGroups(new int[]{0,1,0,0,1,0,1}, 6));
    }
}
