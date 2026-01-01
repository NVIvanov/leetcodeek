import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class FindScoreofanArrayAfterMarkingAllElements {

    static class Solution {
        public long findScore(int[] nums) {
            PriorityQueue<Integer> indexes = new PriorityQueue<>(Comparator.<Integer>comparingInt(it -> nums[it])
                    .thenComparing(Comparator.naturalOrder()));
            for (int i = 0; i < nums.length; i++) {
                indexes.add(i);
            }

            Set<Integer> markedIndexes = new HashSet<>();

            long score = 0;

            while (!indexes.isEmpty()) {
                int index = indexes.poll();
                if (markedIndexes.contains(index)) {
                    continue;
                }
                score += nums[index];
                markedIndexes.add(index);
                markedIndexes.add(index - 1);
                markedIndexes.add(index + 1);
            }

            return score;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findScore(new int[]{2,5,6,6,10}));
    }
}
