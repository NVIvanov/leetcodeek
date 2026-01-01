public class FruitsIntoBasketsII {

    static class Solution {
        public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
            int count = 0;
            for (int fruit : fruits) {
                boolean placed = false;
                for (int j = 0; j < baskets.length; j++) {
                    if (fruit <= baskets[j]) {
                        baskets[j] = 0;
                        placed = true;
                        System.out.println("fruit " + fruit + " placed into " + j);
                        break;
                    }
                }
                if (!placed) {
                    count++;
                }
            }
            return count;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().numOfUnplacedFruits(
                new int[]{4,2,5}, new int[]{3,5,4}
        ));
    }
}
