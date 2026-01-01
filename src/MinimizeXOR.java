public class MinimizeXOR {

    static class Solution {
        public int minimizeXor(int num1, int num2) {
            int num2Bits = Integer.bitCount(num2);
            int num1Bits = Integer.bitCount(num1);
            int x = num1;
            for (int i = 0; i < num2Bits - num1Bits; i++) {
                x = x | (x + 1);
            }
            for (int i = 0; i < num1Bits - num2Bits; i++) {
                x = x & (x - 1);
            }
            return x;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minimizeXor(25, 72));
    }
}
