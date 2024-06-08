public class FindTheDuplicateNumber {

    public static int findDuplicate(int[] nums) {
        int i = 0;
        while (true) {
            if (i > 0 && nums[i] == nums[(i * 2) % nums.length]) {
                return nums[i];
            }
            i++;
            if (i == nums.length) {
                i = 0;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(findDuplicate(new int[]{3,1,3,4,2}));
    }
}
