public class MinimumRecolorstoGetKConsecutiveBlackBlocks {
    static class Solution {
        public int minimumRecolors(String blocks, int k) {
            int currentBlackBlocks = 0;
            int minRecolors = blocks.length();
            for (int i = 0; i < blocks.length(); i++) {
                if (blocks.charAt(i) == 'B') {
                    currentBlackBlocks++;
                }
                if (i >= k) {
                    if (blocks.charAt(i - k) == 'B') {
                        currentBlackBlocks--;
                    }
                }
                if (i >= k - 1) {
                    minRecolors = Math.min(minRecolors, k - currentBlackBlocks);
                }
            }

            return minRecolors;
        }
    }

    public static void main(String[] args) {
        
    }
}
