public class MinimumArrayEnd {

    static class Solution {

        public long minEnd(int n, int x) {
            n = n - 1;
            long result = 0;
            byte size = 0;
            while (x > 0 || n > 0) {
                result |= ((long) ((x & 1) | (n & 1))  << size);
                if ((x & 1) != 1) {
                    n >>= 1;
                }
                x >>= 1;
                size++;
            }
            return result;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minEnd(3, 4));
    }
}
