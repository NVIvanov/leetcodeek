import java.util.Arrays;
import java.util.List;

public class LargestPerimiterPolygon {

    public static long largestPerimeter(int[] nums) {
        long maxSum = 0;
        Arrays.sort(nums);

        for (int num : nums) {
            maxSum += num;
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] >= maxSum - nums[i]) {
                maxSum -= nums[i];
            } else {
                break;
            }
        }

        return maxSum;
    }

    public static void main(String[] args) {
        System.out.println(largestPerimeter(new int[]{1,12,1,2,5,50,3}));
    }
}
