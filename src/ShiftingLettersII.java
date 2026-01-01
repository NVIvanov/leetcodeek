import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class ShiftingLettersII {

    static class Solution {
        public String shiftingLetters(String s, int[][] shifts) {
            int[] diffArray = new int[s.length()];
            for (var shift : shifts) {
                diffArray[shift[0]] += shift[2] == 0 ? -1 : 1;
                if (shift[1] + 1 < s.length()) {
                    diffArray[shift[1] + 1] += shift[2] == 0 ? 1 : -1;
                }
            }

            System.out.println(Arrays.toString(diffArray));

            StringBuilder sb = new StringBuilder();
            int numberOfShifts = 0;
            for (int i = 0; i < s.length(); i++) {
                numberOfShifts = (numberOfShifts + diffArray[i]) % 26;
                if (numberOfShifts < 0) numberOfShifts += 26;

                char shiftedChar = (char) ('a' +
                        ((s.charAt(i) - 'a' + numberOfShifts) % 26));
                sb.setCharAt(i, shiftedChar);
            }

            return sb.toString();
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().shiftingLetters("abc", new int[][]{{0,1,0},{1,2,1},{0,2,1}}));
    }
}
