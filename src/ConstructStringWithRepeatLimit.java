import java.util.*;

public class ConstructStringWithRepeatLimit {

    static class Solution {
        public String repeatLimitedString(String s, int repeatLimit) {
            char current;
            int currentNumber = 0;
            StringBuilder stringBuilder = new StringBuilder();
            PriorityQueue<Character> pq = new PriorityQueue<>(Comparator.reverseOrder());

            for (int i = 0; i < s.length(); i++) {
                pq.add(s.charAt(i));
            }
            current = pq.peek();

            PriorityQueue<Character> delayed = new PriorityQueue<>(Comparator.reverseOrder());

            while (currentNumber <= repeatLimit && !pq.isEmpty()) {
                char poll = pq.poll();
                if (poll == current) {
                    currentNumber++;
                } else {
                    currentNumber = 1;
                    current = poll;
                }
                if (currentNumber > repeatLimit) {
                    do {
                        delayed.offer(poll);
                    } while (!pq.isEmpty() && (current == (poll = pq.poll())));
                    if (current != poll) {
                        currentNumber = 1;
                        current = poll;
                    }
                }
                if (currentNumber <= repeatLimit) {
                    stringBuilder.append(current);
                }
                for (int i = 0; i < repeatLimit && !delayed.isEmpty(); i++) {
                    pq.offer(delayed.poll());
                }
            }

            return stringBuilder.toString();
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().repeatLimitedString("jwqyyngextfizadbrydpvqjinkjcyplwfolxmjisjjce", 2));
    }
}
