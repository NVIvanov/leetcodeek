public class FindthePunishmentNumberofanInteger {

    static class Solution {
        public int punishmentNumber(int n) {
            return 0;
        }

        public boolean canBeSplitAndEqual(int n, int target) {
            if (n == target) {
                return true;
            }
            if (n < 10) {
                return false;
            }
            int rightPart = 0;
            while (n > 0) {
                rightPart = rightPart * 10 + n % 10;
                n /= 10;
                if (canBeSplitAndEqual(rightPart, target - n)) {
                    return true;
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.canBeSplitAndEqual(11, 9));
    }
}
