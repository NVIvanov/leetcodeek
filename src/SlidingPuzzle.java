import java.util.*;

public class SlidingPuzzle {

    static class Solution {
        public int slidingPuzzle(int[][] board) {
            Board target = new Board(
                    new int[][]{
                            {1,2,3},
                            {4,5,0}
                    }
            );

            Queue<Board> explore = new LinkedList<>();
            Set<Board> visited = new HashSet<>();
            Deque<Integer> level = new LinkedList<>();
            level.add(0);
            explore.add(new Board(board));
            int step = 1;
            while (!explore.isEmpty()) {
                Set<Board> c = new HashSet<>();
                while (!explore.isEmpty()) {
                    Board current = explore.poll();
                    int lev = level.poll();
                    int[] zeroPos = findZero(current.board);
                    visited.add(current);
                    if (visited.contains(target)) {
                        return lev;
                    }
                    c.addAll(nextCandidates(current.board, zeroPos[0], zeroPos[1]));
                }
                for (Board cur : c) {
                    if (!visited.contains(cur)) {
                        explore.add(cur);
                        level.offer(step);
                    }
                }
                step++;
            }

            return -1;
        }

        private int[] findZero(int[][] board) {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (board[i][j] == 0) {
                        return new int[]{i, j};
                    }
                }
            }
            return new int[]{-1, -1};
        }

        private List<Board> nextCandidates(int[][] board, int x, int y) {
            List<Board> candidates = new ArrayList<>();
            int[][] coordinates = new int[][] {
                    {x - 1, y},
                    {x + 1, y},
                    {x, y - 1},
                    {x, y + 1},
            };
            for (int[] coordinate : coordinates) {
                if (coordinate[0] >= 0 && coordinate[0] < board.length && coordinate[1] >= 0 && coordinate[1] < board[0].length) {
                    int[][] next = new int[2][3];
                    next[0] = board[0].clone();
                    next[1] = board[1].clone();
                    next[x][y] = board[coordinate[0]][coordinate[1]];
                    next[coordinate[0]][coordinate[1]] = 0;
                    candidates.add(new Board(next));
                }
            }
            return candidates;
        }

        class Board {
            private int[][] board;
            public Board(int[][] board) {
                this.board = board;
            }

            @Override
            public boolean equals(Object obj) {
                Board other = (Board) obj;
                for (int i = 0; i < board.length; i++) {
                    for (int j = 0; j < board[0].length; j++) {
                        if (board[i][j] != other.board[i][j]) {
                            return false;
                        }
                    }
                }
                return true;
            }

            @Override
            public int hashCode() {
                return Arrays.deepHashCode(board);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().slidingPuzzle(new int[][]{
                {4,1,2},
                {5,0,3}
        }));
    }
}
