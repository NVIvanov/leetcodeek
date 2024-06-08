public class FindBottomLeftTreeValue {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    Integer leftMost;
    Integer depth = 1;

    public int findBottomLeftValue(TreeNode root) {
        leftMost = root.val;
        helper(root, 1);
        return leftMost;
    }

    public void helper(TreeNode root, int d) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null && d > depth) {
            depth = d;
            leftMost = root.val;
        }
        helper(root.left, d + 1);
        helper(root.right, d + 1);
    }
    public static void main(String[] args) {

    }
}
