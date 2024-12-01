import java.util.Arrays;
import java.util.Comparator;

public class RotatingtheBox {

    static class Solution {
        public char[][] rotateTheBox(char[][] box) {
            for (int i = 0; i < box.length; i++) {
                int l = 0, r = 0;
                while (l < box[i].length) {
                    while (r < box[i].length && box[i][r] != '*') {
                        r++;
                    }

                    sort(box[i], l, r - 1);

                    l = r + 1;
                    r = l;
                }
            }

            char[][] res = new char[box[0].length][box.length];

            for (int i = 0; i < box.length; i++) {
                for (int j = 0; j < box[i].length; j++) {
                    res[j][i] = box[box.length - i - 1][j];
                }
            }

            return res;
        }

        private void sort(char[] arr, int l, int r) {
            for (int i = l; i < r; i++) {
                for (int j = i; j <= r; j++) {
                    if (arr[i] < arr[j]) {
                        char temp = arr[i];
                        arr[i] = arr[j];
                        arr[j] = temp;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        char[][] box = {
                {'#', '.', '*', '.'},
                {'#', '#', '*', '.'}
        };

        Solution solution = new Solution();
        char[][] res = solution.rotateTheBox(box);
        System.out.println("dummy");
    }
}
