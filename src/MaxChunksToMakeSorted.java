public class MaxChunksToMakeSorted {
    static class Solution {
        public int maxChunksToSorted(int[] arr) {
            int sum = 0;
            int chunks = 0;
            for (int i = 0; i < arr.length; i++) {
                sum += arr[i];
                if (sum == i * (i + 1) / 2) {
                    chunks++;
                }
            }
            return chunks;
        }
    }


    public static void main(String[] args) {


    }
}
