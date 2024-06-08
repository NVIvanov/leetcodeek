public class MajorityElement {

    class Solution {
        public int majorityElement(int[] nums) {

            int majority = 0;
            int num = 0;
            for (int j : nums) {
                if (majority == 0) {
                    num = j;
                    majority++;
                } else {
                    if (j == num) {
                        majority++;
                    } else {
                        majority--;
                    }
                }
            }
            return num;
        }
    }
}
