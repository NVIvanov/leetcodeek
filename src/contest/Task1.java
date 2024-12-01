package contest;

public class Task1 {

    static class Solution {
        public boolean canAliceWin(int n) {
            boolean aliceWin = false;
            int start = 10;
            while (start <= n) {
                n -= start--;
                aliceWin = !aliceWin;
            }
            return aliceWin;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().canAliceWin(19));
    }
}
