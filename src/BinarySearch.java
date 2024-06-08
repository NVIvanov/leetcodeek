public class BinarySearch {

    static public int binarySearch(int[] array, int x) {
        if (array.length == 0) {
            return -1;
        }
        int r = array.length - 1;
        int l = 0;
        do {
            int index = (r + l) / 2;
            if (array[index] > x) {
                r = index - 1;
            } else if (array[index] < x) {
                l = index + 1;
            } else {
                return index;
            }
        } while (l <= r);
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(binarySearch(new int[]{1, 2, 3},3));
    }
}