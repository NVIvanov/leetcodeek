import java.util.Comparator;
import java.util.PriorityQueue;

public class FinalArrayStateAfterKMultiplicationOperationsI {

    static class Solution {
        public int[] getFinalState(int[] nums, int k, int multiplier) {
            PriorityQueue<Integer> indexes = new PriorityQueue<>(Comparator.<Integer>comparingInt(it -> nums[it])
                    .thenComparing(Comparator.naturalOrder()));

            for (int i = 0; i < nums.length; i++) {
                indexes.add(i);
            }

            for (int i = 0; i < k; i++) {
                var index = indexes.poll();
                nums[index] *= multiplier;
                indexes.offer(index);
            }

            return nums;
        }
    }

    public static void main(String[] args) {

    }
}
