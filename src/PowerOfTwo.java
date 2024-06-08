public class PowerOfTwo {

    public static boolean isPowerOfTwo(int n) {
        return n > 0 && ((n | (n - 1)) - (n - 1)) == n;
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println(Integer.toBinaryString(n));
        System.out.println(Integer.toBinaryString(n-1));
        System.out.println(Integer.toBinaryString(n | (n - 1)));

        System.out.println(isPowerOfTwo(8));
    }
}
