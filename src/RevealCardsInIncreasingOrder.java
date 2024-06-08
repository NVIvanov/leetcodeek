import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;

public class RevealCardsInIncreasingOrder {

    public static int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        Deque<Integer> stack = new ArrayDeque<>(deck.length);
        for (int i = deck.length - 1; i >= 0; i--) {
            if (stack.size() > 1) {
                stack.addFirst(stack.pollLast());
            }
            stack.addFirst(deck[i]);
        }
        for (int i = 0; i < deck.length; i++) {
            deck[i] = stack.pollFirst();
        }
        return deck;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(deckRevealedIncreasing(new int[]{17,13,11,2,3,5,7})));
    }
}
