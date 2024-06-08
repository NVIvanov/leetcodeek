import io.nvivanov.leetcode.utils.InitUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindtheMaximumSumofNodeValues {
    public static long maximizeSum(int[] nums, int k, int[][] edges) {
//        boolean changed;
//        do {
//            changed = false;
//            for (int i = 0; i < edges.length; i++) {
//                for (int j = 0; j < edges.length; j++) {
//                    if (edges[i][0] != edges[j][1]) {
//                        if (nums[edges[i][0]] + nums[edges[j][1]] < (nums[edges[i][0]] ^ k) + (nums[edges[j][1]] ^ k)) {
//                            nums[edges[i][0]] = nums[edges[i][0]] ^ k;
//                            nums[edges[j][1]] = nums[edges[j][1]] ^ k;
//                            changed = true;
//                            long sum = 0;
//                            for (int num : nums) {
//                                sum += num;
//                            }
//                            System.out.println(sum);
//                        }
//                    }
//                    if (edges[i][1] != edges[j][0]) {
//                        if (nums[edges[i][1]] + nums[edges[j][0]] < (nums[edges[i][1]] ^ k) + (nums[edges[j][0]] ^ k)) {
//                            nums[edges[i][1]] = nums[edges[i][1]] ^ k;
//                            nums[edges[j][0]] = nums[edges[j][0]] ^ k;
//                            changed = true;
//                        }
//                    }
//
//                }
//            }
//        } while (changed);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < (nums[i] ^ k)) {
                System.out.println(i);
            }
        }
        long sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }


    public static void main(String[] args) {
        int[] nums = {3,45,1,27,87,43,62};
        int k = 8;
        int[][] edges = InitUtils.fromSquareBrackets("[[1,0],[1,2],[3,2],[3,4],[3,5],[6,5]]");
        System.out.println(maximizeSum(nums, k, edges));
    }
}
