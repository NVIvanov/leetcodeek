public class PivotInteger {

    static public int binarySearch(int n) {
        int r = n;
        int l = 1;
        do {
            int index = (r + l) / 2;
            int lsum = (1 + index) * index / 2;
            int rsum = (index + n) * (n - index + 1) / 2;
            if (lsum > rsum) {
                r = index - 1;
            } else if (lsum < rsum) {
                l = index + 1;
            } else {
                return index;
            }
        } while (l <= r);
        return -1;
    }

    public static int pivotInteger(int n) {
        return binarySearch(n);
    }

    public static void main(String[] args) {
        System.out.println(pivotInteger(4));
    }
}
