public class MaximumProductofSplittedBinaryTree {

    static class TreeNode {
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

    static class Solution {
        public int maxProduct(TreeNode root) {
            int rootSum = sum(root);
            return Math.toIntExact(maxProductHelper(root, rootSum) % 1_000_000_007);
        }

        long maxProductHelper(TreeNode root, int rootSum) {
            if (root == null) {
                return 1;
            }
            int leftSum = sum(root.left);
            int sumRight = sum(root.right);
            long leftSplit = (long) leftSum * (rootSum - leftSum);
            long rightSplit = (long) sumRight * (rootSum - sumRight);
            return Math.max(Math.max(leftSplit, rightSplit), Math.max(maxProductHelper(root.left, rootSum), maxProductHelper(root.right, rootSum)));
        }

        int sum(TreeNode node) {
            if (node == null) {
                return 0;
            }
            return node.val + sum(node.left) + sum(node.right);
        }

    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode();
        node.val = 1;
        TreeNode node2 = new TreeNode();
        node2.val = 2;
        TreeNode node3 = new TreeNode();
        node3.val = 3;
        node.left = node2;
        node.right = node3;

        TreeNode node4 = new TreeNode();
        node4.val = 4;
        TreeNode node5 = new TreeNode();
        node5.val = 5;
        node2.left = node4;
        node2.right = node5;

        TreeNode node6 = new TreeNode();
        node6.val = 6;
        node3.left = node6;

        System.out.println(new Solution().maxProduct(node));
    }
}
