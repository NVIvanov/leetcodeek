public class WordSearch {

    public static boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (exist(board, word, "", new boolean[board.length][board[0].length], i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean exist(char[][] board, String word, String prefix, boolean[][] visited, int x, int y) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || !validCandidate(visited, x, y)) {
            return false;
        }
        if (word.equals(prefix + board[x][y])) {
            return true;
        }
        if (word.startsWith(prefix + board[x][y])) {
            visited[x][y] = true;
            var result = exist(board, word, prefix + board[x][y], visited, x - 1, y)
                    || exist(board, word, prefix + board[x][y], visited, x, y - 1)
                    || exist(board, word, prefix + board[x][y], visited, x, y + 1)
                    || exist(board, word, prefix + board[x][y], visited, x + 1, y);
            visited[x][y] = false;
            return result;
        }
        return false;
    }

    private static boolean validCandidate(boolean[][] visited, int x, int y) {
        return !visited[x][y];
    }

    public static void main(String[] args) {
        System.out.println(exist(new char[][]{
                {'a', 'b', 'c', 'e'}, {'s', 'f', 'e', 's'}, {'a', 'd', 'e', 'e'}
        }, "abceseeefs"));
        /*
           a b c e
           s f e s
           a d e e
         */
    }
}
