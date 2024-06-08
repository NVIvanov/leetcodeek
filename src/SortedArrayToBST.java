import com.sun.source.tree.Tree;

public class SortedArrayToBST {

     public static class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode() {}
         TreeNode(int val) { this.val = val; }
         TreeNode(int val, TreeNode left, TreeNode right) {
             this.val = val;
             this.left = left;
             this.right = right;
         }
     }


    public static TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    public static TreeNode sortedArrayToBST(int[] nums, int l, int r) {
         if (l > r) {
             return null;
         }

         var mid = (l + r) / 2;
         var node = new TreeNode(nums[mid]);

         node.left = sortedArrayToBST(nums, l, mid - 1);
         node.right = sortedArrayToBST(nums, mid + 1, r);
         return node;
    }

    public static void main(String[] args) {
        int n = Integer.parseUnsignedInt("00000010100101000001111010011100", 2);
        System.out.println(n);
        System.out.println(Integer.toBinaryString(n));
//        int zeros = Integer.numberOfLeadingZeros(n);
        var res = n ^ (n >>> 1 << 1);
        n = n >>> 1;
        for (int i = 0; i < 31; i++) {
            res = (res << 1) + (n ^ (n >>> 1 << 1));
            n = n >>> 1;
        }
//        res <<= zeros;
        System.out.println(Integer.toBinaryString(res));
    }
}
