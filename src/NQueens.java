import java.util.ArrayList;
import java.util.List;

public class NQueens {

    public static List<List<String>> solveNQueens(int n) {
        int[] queens = new int[n];
        List<List<String>> result = new ArrayList<>();
        backtrack(queens, 0, result);
        return result;
    }

    private static void backtrack(int[] queens, int row, List<List<String>> result) {
        if (row == queens.length) {
            List<String> q = new ArrayList<>();
            for (var qn: queens) q.add(convert(qn, queens.length));
            result.add(q);
        } else {
            for (int j = 0; j < queens.length; j++) {
                boolean legal = true;
                for (int i = 0; i < row; i++) {
                    if (queens[i] == j || queens[i] == j + row - i || queens[i] == j - row + i) {
                        legal = false;
                        break;
                    }
                }
                if (legal) {
                    queens[row] = j;
                    backtrack(queens, row + 1, result);
                }
            }
        }
    }

    private static String convert(Integer i, Integer n) {
        return ".".repeat(i) +
                "Q" +
                ".".repeat(n - i - 1);
    }

    public static void main(String[] args) {
        System.out.println(solveNQueens(4));
    }
}
