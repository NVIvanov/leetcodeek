import java.util.Comparator;
import java.util.PriorityQueue;

public class TakeGiftsFromtheRichestPile {

    static class Solution {
        public long pickGifts(int[] gifts, int k) {
            PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
            for (int g : gifts) {
                pq.add(g);
            }
            for (int i = 0; i < k && !pq.isEmpty(); i++) {
                int leftBehind = (int) Math.floor(Math.sqrt(pq.poll()));
                if (leftBehind > 0) {
                    pq.offer(leftBehind);
                }
            }
            return pq.stream().mapToLong(Integer::longValue).sum();
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().pickGifts(new int[]{25,64,9,4,100}, 4));
    }
}
