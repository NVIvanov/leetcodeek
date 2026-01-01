import java.util.HashSet;
import java.util.Set;

public class FindthePrefixCommonArrayofTwoArrays {

    static class Solution {
        public int[] findThePrefixCommonArray(int[] A, int[] B) {
            Set<Integer> set = new HashSet<>();
            int[] res = new int[A.length];
            int commonNumberCount = 0;
            for (int i = 0; i < A.length; i++) {
                if (set.contains(A[i])) {
                    commonNumberCount++;
                } else {
                    set.add(A[i]);
                }
                if (set.contains(B[i])) {
                    commonNumberCount++;
                } else {
                    set.add(B[i]);
                }
                res[i] = commonNumberCount;
            }
            return res;
        }
    }

    public static void main(String[] args) {

    }
}
