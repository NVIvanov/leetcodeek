public class AddOneRowtoTree {

    public static DiameterOfBinaryTree.TreeNode addOneRow(DiameterOfBinaryTree.TreeNode root, int val, int depth) {
        if (depth == 1) {
            var node = new DiameterOfBinaryTree.TreeNode();
            node.val = val;
            node.left = root;
            root = node;
        } else {
            addRow(root, val, depth - 2);
        }
        return root;
    }

    private static void addRow(DiameterOfBinaryTree.TreeNode root, int val, int depth) {
        if (root == null) {
            return;
        }
        if (depth > 0) {
            addRow(root.left, val, depth - 1);
            addRow(root.right, val, depth - 1);
        } else {
            if (root.left != null) {
                var left = new DiameterOfBinaryTree.TreeNode();
                left.val = val;
                left.left = root.left;
                root.left = left;
            } else {
                root.left = new DiameterOfBinaryTree.TreeNode();
                root.left.val = val;
            }
            if (root.right != null) {
                var right = new DiameterOfBinaryTree.TreeNode();
                right.val = val;
                right.right = root.right;
                root.right = right;
            } else {
                root.right = new DiameterOfBinaryTree.TreeNode();
                root.right.val = val;
            }
        }
    }

    public static void main(String[] args) {
        var result = addOneRow(
                new DiameterOfBinaryTree.TreeNode(4,
                        new DiameterOfBinaryTree.TreeNode(2,
                                new DiameterOfBinaryTree.TreeNode(3),
                                new DiameterOfBinaryTree.TreeNode(1)
                        ),
                        new DiameterOfBinaryTree.TreeNode(6,
                                new DiameterOfBinaryTree.TreeNode(5)
                                , null
                        )
                ),1, 2
        );
        System.out.println();
    }
}
