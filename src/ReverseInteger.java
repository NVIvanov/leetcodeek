public class ReverseInteger {

    public static int reverse(int x) {
        int signum = Integer.signum(x);
        int res = 0, prevRes;
        while (x != 0) {
            prevRes = res;
            int digit = x % 10;
            res = prevRes * 10;
            if (res / 10 != prevRes) {
                return 0;
            }
            prevRes = res;
            res += digit;
            if (signum > 0 && res < prevRes || signum < 0 && res > prevRes) {
                return 0;
            }
            x /= 10;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(reverse(-1));
    }
}
