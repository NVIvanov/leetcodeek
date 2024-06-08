import java.util.Arrays;

public class SpecialArrayWithXElementsGreaterThanorEqualX {

    public static int specialArray(int[] nums) {
        Arrays.sort(nums);
        int lessIndex = 0;
        for (int i = 0; i <= nums.length; i++) {
            while (lessIndex < nums.length && nums[lessIndex] < i) {
                lessIndex++;
            }
            if (nums.length - lessIndex == i) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(specialArray(new int[]{3,5}));
    }
}
