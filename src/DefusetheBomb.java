import java.util.Arrays;

public class DefusetheBomb {

    static class Solution {
        public int[] decrypt(int[] code, int k) {
            if (k == 0) {
                return new int[code.length];
            }
            int[] res = new int[code.length];
            for (int i = 0; i < code.length; i++) {
                res[i] = calc(code, Math.abs(k), i + Integer.signum(k), Integer.signum(k));
            }
            return res;
        }

        private int calc(int[] code, int k, int index, int direction) {
            int sum = 0;
            for(int i = index, counter = 0; counter < k; i += direction) {
                sum += code[convertIndex(i, code.length)];
                counter++;
            }
            return sum;
        }

        private int convertIndex(int i, int len) {
            if (i >= 0) {
                return i % len;
            } else {
                return len + (i % len);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().decrypt(new int[]{2,4,9,3}, -2)));
    }
}
