public class Factorial {

    static long factorial(long x) {
        if (x == 0) {
            return 1;
        }
        return x * factorial(x - 1);
    }

    public static void main(String[] args) {
        for (int i = 0; i <= 20; i++) {
            System.out.println(factorial(i));
        }
    }
}
