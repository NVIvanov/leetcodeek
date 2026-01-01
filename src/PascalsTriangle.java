import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {

    static class Solution {
        public List<List<Integer>> generate(int numRows) {
            List<List<Integer>> allRows = new ArrayList<>();
            for (int i = 0; i < numRows; i++) {
                ArrayList<Integer> list = new ArrayList<>();
                for (int j = 0; j <= i; j++) {
                    list.add(0);
                }
                list.set(0, 1);
                list.set(i, 1);
                allRows.add(list);
            }
            if (numRows <= 2) {
                return allRows;
            }
            for (int i = 2; i < numRows; i++) {
                List<Integer> upperLine = allRows.get(i - 1);
                List<Integer> currentLine = allRows.get(i);
                for (int j = 1; j < i; j++) {
                    currentLine.set(j, upperLine.get(j - 1) + upperLine.get(j));
                }
            }
            return allRows;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().generate(1));
        System.out.println(new Solution().generate(2));
        System.out.println(new Solution().generate(3));
        System.out.println(new Solution().generate(4));

    }
}
