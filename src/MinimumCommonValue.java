public class MinimumCommonValue {

    public static int getCommon(int[] nums1, int[] nums2) {
        int first = 0, second = 0;
        while (first < nums1.length && second < nums2.length) {
            while (first < nums1.length && nums1[first] < nums2[second]) first++;
            while (first < nums1.length && second < nums2.length && nums2[second] < nums1[first]) second++;
            if (first < nums1.length && second < nums2.length && nums1[first] == nums2[second]) {
                return nums1[first];
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(getCommon(
                new int[]{1,2,3},
                new int[]{4,5,6}
        ));
    }
}
