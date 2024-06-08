import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LargestDivisibleSubset {

    /*
        f(i, i) = true
        f(a, b) - nums from a to b is divisible subset
        f(a, b) = f(a, b - 1) and b % b - 1 == 0

        1   2   3
     1  1   2   3
     2  1   2   2
     3  1   1   2

     3, 1

        1   2   4   8
     1  1   2   3   4
     2  1   2   3   4
     4  1   2   3   4
     8  1   2   3   4

        1   3   7   9
     1  1   2   3   4
     3  1   2   2   3
     7  1   1   2   2
     9  1   2   2   3

     9, 3, 1

        1   3   7   9   11
     1  1   2   3   4   5
     3  1   2   2   3   3
     7  1   0   1   0   0
     9  1   1   0   1   0
     11 1   0   0   0   1

            3   6   18  24  36  37  38
     3      1   2   3   4   5   5
     6      1   2   3   4   5   5
     18     1   2   3   3   4   4
     24     1   2   2   3   3   3
     36     1   2   3   3   4   4
     37     0   0   0   0   0   1

        2   3
     2  1   1
     3  0   1

        2   4   8
     2  1   2   3
     4  1   2   3
     8  1   2   3

        3   9   15
     3  1   2   3
     9  1   2   2
     15 1   1   2

     3,15

     идем с конца

     если i-1, j-1 больше, чем i,j, то переходим к i-1, j-1, из результата удаляем элемент i,j
     если i-1, j-1 меньше или рано, чем i,j, но число i,j не делится на число i-1, j-1, удаляем элемент i-1, j-1, переходим к
     i-2, j-2

     восстановление последовательности:

     если arr[i-1]
     */
    public static List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int[][] divisions = new int[nums.length][nums.length];
        Arrays.sort(nums);
        for (int i = 0; i < divisions.length; i++) {
            for (int j = 0; j < divisions.length; j++) {
                divisions[i][j] = 0;
                if (j > 0) {
                    divisions[i][j] = divisions[i][j-1];
                }
                if (nums[i] % nums[j] == 0 || nums[j] % nums[i] == 0) {
                    divisions[i][j]++;
                }
            }
        }
        System.out.println("    " + Arrays.toString(nums));
        for (int i = 0; i < nums.length; i ++) {
            System.out.println(nums[i] + " - " + Arrays.toString(divisions[i]));
        }
        for (int i = divisions.length - 1; i > 0; i--) {
            if (divisions[i][i] >= divisions[i - 1][i - 1]) {
                if (!result.isEmpty()) {
                    if (result.get(result.size() - 1) % nums[i] == 0) {
                        result.add(nums[i]);
                    }
                } else {
                    result.add(nums[i]);
                }
            } else {
                if (!result.isEmpty()) {
                    if (result.get(result.size() - 1) % nums[i] == 0) {
                        result.add(nums[i]);
                    }
                    break;
                }
            }
        }
        if (result.isEmpty() || result.get(result.size() - 1) % nums[0] == 0) {
            result.add(nums[0]);
        }
        /*
            1 2 3 4 6 24
            1 2 2 3 4 6

         если i-1 < i:
            если i делится на i - 1:
                добавляем i в результат

         */
        return result;
    }

    public static void main(String[] args) {
        System.out.println(largestDivisibleSubset(new int[]{4,8,10,240}));
    }
}
