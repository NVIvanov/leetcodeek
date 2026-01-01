import java.util.Arrays;

public class PlusOne {

    static class Solution {
        public int[] plusOne(int[] digits) {
            int index = digits.length;
            do {
                index--;
                if (index >= 0) {
                    digits[index] = (digits[index] + 1) % 10;
                }
            } while (index >= 0 && digits[index] == 0);
            if (digits[0] == 0) {
                int[] newArr = new int[digits.length + 1];
                System.arraycopy(digits, 0, newArr, 1, digits.length);
                newArr[0] = 1;
                return newArr;
            }
            return digits;
        }
    }

    public static void main(String[] args) {

        int[] arr = new int[1];
        for (int i = 0; i < 10000; i++) {
            arr = new Solution().plusOne(arr);
        }
        System.out.println(Arrays.toString(arr));
    }
}
