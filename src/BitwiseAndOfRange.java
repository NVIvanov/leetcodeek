public class BitwiseAndOfRange {
    public static int rangeBitwiseAnd(int left, int right) {
        byte shifted = 0;
        while (left != right) {
            left >>= 1;
            right >>= 1;
            shifted++;
        }
        return left << shifted;
    }

    public static void main(String[] args) {
        System.out.println(rangeBitwiseAnd(1, 2147483647));
    }
}
