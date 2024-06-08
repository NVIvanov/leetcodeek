import java.util.Arrays;

public class LargestPositiveIntegerThatExistsWithItsNegative {

    public static int findMaxK(int[] nums) {
        Arrays.sort(nums);
        int i = 0, j = nums.length - 1;
        while (nums[i] < 0 && nums[j] >= 0) {
            if (-nums[i] > nums[j]) {
                i++;
            } else if (-nums[i] < nums[j]) {
                j--;
            } else {
                return nums[j];
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(findMaxK(new int[]{-10,8,6,7,-2,-3}));
    }
}
