public class Sqrt {

    public static int mySqrt(int x) {
        int a = 0;
        int b = (int) Math.pow(2, 15.5);
        int mid = (a + b) / 2;
        while (a <= b) {
            int sqr = mid * mid;
            System.out.println(a + " " + mid + " " + b + " sqr=" + sqr);
            if (sqr > x) {
                b = mid - 1;
            } else if (sqr < x) {
                a = mid + 1;
            } else {
                return mid;
            }
            mid = (a + b) / 2;
        }
        return a - 1;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(2147395599));
    }
}
