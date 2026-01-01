import java.util.Arrays;

public class MinimumNumberofOperationstoMoveAllBallstoEachBox {

    static class Solution {
        public int[] minOperations(String boxes) {
            int[] afterIndex = new int[boxes.length()];

            int count = 0, sum = 0;
            for (int i = boxes.length() - 1; i >= 0; i--) {
                if (boxes.charAt(i) == '1') {
                    count++;
                }
                afterIndex[i] = count;
            }

            for (int i = 0; i < boxes.length(); i++) {
                if (boxes.charAt(i) == '1') {
                    sum += i;
                }
            }

            int[] result = new int[boxes.length()];
            result[0] = sum;

            for (int i = 1; i < boxes.length(); i++) {
                sum += count - 2 * afterIndex[i];
                result[i] = sum;
            }

            return result;
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().minOperations("10")));
    }
}
