import java.util.Arrays;

public class BagofTokens {

    public static int bagOfTokensScore(int[] tokens, int power) {
        /*
           токены делим на две группы - ту, что принесет нам power, и ту, что принесет нам token.

           жадный подход:
           мы можем потратить power на все токены и нам это принесет кучу scores.
           Тратить легче всего на tokens с меньшими значениями, так мы медленнее опустошим power и накопим больше scores

           когда power < очередной token, нужно взять максимальный token с правого края, потратить score, но запастись power
           и дальше идем, пока у нас не закончатся power или scores, либо пока не обойдем все токены.

         */

        int score = 0, maxScore = 0;
        int l = 0, r = tokens.length - 1; //r - для получения power за scores

        Arrays.sort(tokens); // сортируем для корректного обхода

        while (l <= r) {
            if (power >= tokens[l]) {
                power -= tokens[l++];
                score++;
                maxScore = Math.max(maxScore, score);
            } else if (score > 0) {
                power += tokens[r--];
                score--;
            } else {
                break;
            }
        }

        return maxScore;
    }

    public static void main(String[] args) {
        System.out.println(bagOfTokensScore(new int[]{200,100}, 150));
    }
}
