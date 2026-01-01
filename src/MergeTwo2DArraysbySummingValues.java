import java.util.ArrayList;
import java.util.List;

public class MergeTwo2DArraysbySummingValues {

    static class Solution {
        public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
            int l = 0, r = 0;
            List<int[]> res = new ArrayList<>();

            while (l < nums1.length || r < nums2.length) {
                if (l < nums1.length && r < nums2.length) {
                    if (nums1[l][0] < nums2[r][0]) {
                        res.add(new int[] {nums1[l][0], nums1[l][1]});
                        l++;
                    } else if (nums1[l][0] > nums2[r][0]) {
                        res.add(new int[] {nums2[r][0], nums2[r][1]});
                        r++;
                    } else {
                        res.add(new int[] {nums1[l][0], nums1[l][1] + nums2[r][1]});
                        l++;
                        r++;
                    }
                } else if (l < nums1.length) {
                    res.add(new int[] {nums1[l][0], nums1[l][1]});
                    l++;
                } else {
                    res.add(new int[] {nums2[r][0], nums2[r][1]});
                    r++;
                }
            }
            return res.toArray(new int[res.size()][]);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] nums1 = {{1, 2}, {2, 3}, {4, 5}};
        int[][] nums2 = {{1, 4}, {3, 2}, {4, 1}};
        int[][] result = solution.mergeArrays(nums1, nums2);
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}
