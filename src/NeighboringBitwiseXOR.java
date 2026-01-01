import java.util.Arrays;

public class NeighboringBitwiseXOR {

    static class Solution {
        public boolean doesValidArrayExist(int[] derived) {
            return Arrays.stream(derived).reduce(0, (a, b) -> a ^ b) == 0;
        }
    }

    public static void main(String[] args) {

    }
}
