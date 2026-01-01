import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MaximumNumberofIntegerstoChooseFromaRangeI {

    static class Solution {
        public int maxCount(int[] banned, int n, int maxSum) {
            Set<Integer> set = Arrays.stream(banned)
                    .boxed()
                    .collect(Collectors.toSet());
            return (int) IntStream.rangeClosed(1, n)
                    .filter(num -> !set.contains(num))
                    .map(new java.util.function.IntUnaryOperator() {
                        private int runningSum = 0;

                        @Override
                        public int applyAsInt(int value) {
                            runningSum += value;
                            return runningSum;
                        }
                    })
                    .takeWhile(sum -> sum <= maxSum)
                    .count();
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxCount(
                new int[] {1,6,5}, 5,6
        ));
        System.out.println(new Solution().maxCount(
                new int[] {1,2,3,4,5,6,7}, 8,1
        ));
        System.out.println(new Solution().maxCount(
                new int[] {11}, 7,50
        ));
    }
}
