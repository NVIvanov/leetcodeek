import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;
import java.util.function.ToIntFunction;
import java.util.stream.Stream;

public class FourDivisors {
    static class Solution {
        public int sumFourDivisors(int[] nums) {
            return Arrays.stream(nums)
                    .map(this::sumOfDivisors)
                    .sum();
        }

        public int sumOfDivisors(int num) {
            Set<Integer> uniqueDivisors = new HashSet<>();
            uniqueDivisors.add(1);
            uniqueDivisors.add(num);
            for (int i = 2; i <= Math.sqrt(num); i++) {
                while (num % i == 0) {
                    uniqueDivisors.add(i);
                    uniqueDivisors.add(num / i);
                    num = num / i;
                }
                if (uniqueDivisors.size() > 4) {
                    return 0;
                }
            }
            if (uniqueDivisors.size() < 4) {
                return 0;
            }
            return uniqueDivisors.stream().mapToInt(i -> i).sum();
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().sumFourDivisors(new int[] {1,2,3,4,5,6,7,8,9,10}));
    }
}
