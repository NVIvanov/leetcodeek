import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BestTimeToBuyAndSellStock {

    public static int maxProfit(int[] prices) {
        int max = 0;
        int minNumber = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i] > minNumber) {
                continue;
            } else {
                minNumber = prices[i];
            }
            for (int j = i + 1; j < prices.length; j++) {
                max = Math.max(max, prices[j] - prices[i]);
            }
        }
        return max;
    }

    /*
         7 1 5 3 6 4
       7 0 0 0 0 0 0
       1 0 0 4 4 5 5
       5 > 1
       3 > 1
       6 > 1
       4 > 1
     */
    public static void main(String[] args) {
//        System.out.println(maxProfit();
    }
}
