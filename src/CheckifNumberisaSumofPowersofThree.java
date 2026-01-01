public class CheckifNumberisaSumofPowersofThree {

    static class Solution {
        public boolean checkPowersOfThree(int n) {
            return Integer.toUnsignedString(n, 3)
                    .chars()
                    .noneMatch(c -> c != '0' && c != '1');
        }
    }


}
