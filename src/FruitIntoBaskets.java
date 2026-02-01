import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class FruitIntoBaskets {
    class Solution {
        public int totalFruit(int[] fruits) {
            if (fruits.length == 1) return 1;
            if (fruits.length == 2) return 2;
            int firstFruit = 0, secondFruit = 1;
            int maxNumber = 0;
            for (int i = 2; i < fruits.length; i++) {
                if (fruits[i] != fruits[secondFruit] && fruits[i] != fruits[firstFruit]) {
                    if (fruits[firstFruit] == fruits[secondFruit]) {
                        secondFruit = i;
                    } else {
                        maxNumber = Math.max(maxNumber, i - firstFruit);
                        firstFruit = secondFruit;
                        secondFruit = i;
                    }
                }
            }
            return Math.max(maxNumber, fruits.length - firstFruit);
        }
    }

    public static void main(String[] args) {
        FruitIntoBaskets solution = new FruitIntoBaskets();
        Solution s = solution.new Solution();
        int[] fruits = {3,3,3,1,2,1,1,2,3,3,4};
        System.out.println("Maximum number of fruits in two baskets: " + s.totalFruit(fruits));
    }
}
