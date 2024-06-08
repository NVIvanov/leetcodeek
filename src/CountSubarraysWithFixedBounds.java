import java.util.Arrays;

public class CountSubarraysWithFixedBounds {

    public long countSubarrays(int[] nums, int minK, int maxK) {
        return countSubarrays(nums, minK, maxK, 0, nums.length - 1);
    }

    private static long countSubarrays(int[] nums, int minK, int maxK, int l, int r) {
        if (l >= r) {
            return 0;
        }
        for (int i = l; i <= r; i++) {
            if (nums[i] < minK || nums[i] > maxK) {
                return countSubarrays(nums, minK, maxK, l, i-1) + countSubarrays(nums, minK, maxK, i + 1, r);
            }
        }
        int lPos = -1, rPos = -1;
        for (int i = l; i <= r; i++) {
            if (nums[i] == minK || nums[i] == maxK) {
                if (lPos == -1) {
                    lPos = i;
                } else {
                    rPos = i;
                }
            }
        }
        if (lPos == -1 || rPos == -1) {
            return 0;
        }
        int count = 1;
        return 0;
    }

    public static void main(String[] args) {

    }
}
