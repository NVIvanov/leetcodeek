package contest;

public class SmallestDivisibleDigitProductI {

    static class Solution {
        public static int smallestNumber(int n, int t) {
            while (digitMult(n) % t != 0) {
                n++;
            }
            return n;
        }
    }


    private static int digitMult(int n) {
        int res = 1;
        while (n > 0) {
            res *= n % 10;
            n /= 10;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Solution.smallestNumber(15, 3));
    }
}
