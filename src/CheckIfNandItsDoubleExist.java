import java.util.*;

public class CheckIfNandItsDoubleExist {

    static class Solution {
        public boolean checkIfExist(int[] arr) {
            Set<Integer> set = new HashSet<>();
            int zeroCount = 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == 0) {
                    zeroCount++;
                }
                set.add(arr[i]);
            }

            for (int i = 0; i < arr.length; i++) {
                if (set.contains(arr[i] * 2) || ((arr[i] % 2 == 0 && set.contains(arr[i] / 2)))) {
                    if (arr[i] == 0) {
                        if (zeroCount > 1) {
                            return true;
                        }
                    } else {
                        return true;
                    }
                }
            }

            return false;
        }
    }

    public static void main(String[] args) {

    }
}
