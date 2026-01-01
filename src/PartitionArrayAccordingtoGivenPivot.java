import java.util.LinkedList;
import java.util.Queue;

public class PartitionArrayAccordingtoGivenPivot {

    static class Solution {
        public int[] pivotArray(int[] nums, int pivot) {
            int[] res = new int[nums.length];
            int count = 0;
            int index = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == pivot) {
                    count++;
                }
                if (nums[i] < pivot) {
                    res[index++] = nums[i];
                }
            }
            for (int i = 0; i < count; i++) {
                res[index++] = pivot;
            }
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > pivot) {
                    res[index++] = nums[i];
                }
            }
            return res;
        }
    }

    public static void main(String[] args) {

    }
}
