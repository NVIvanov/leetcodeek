public class MaxChunksToMakeSortedII {
    static class Solution {
        public int maxChunksToSorted(int[] arr) {
            int[] minimums = new int[arr.length + 1];
            minimums[minimums.length - 1] = Integer.MAX_VALUE;
            for (int i = arr.length - 1; i >= 0; i--) {
                minimums[i] = Math.min(minimums[i + 1], arr[i]);
            }
            int maxLeft = Integer.MIN_VALUE;
            int chunks = 0;
            for (int i = 0; i < arr.length; i++) {
                maxLeft = Math.max(maxLeft, arr[i]);
                if (maxLeft <= minimums[i + 1]) {
                    chunks++;
                }
            }
            return chunks == 0 ? 1 : chunks;
        }
    }


    public static void main(String[] args) {
        System.out.println(new Solution().maxChunksToSorted(new int[]{0,0,1,1,1}));
    }
}
