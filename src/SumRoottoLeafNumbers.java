public class SumRoottoLeafNumbers {


    public int sumNumbers(DiameterOfBinaryTree.TreeNode root) {
        return sumNumbers(root, 0);
    }

    private int sumNumbers(DiameterOfBinaryTree.TreeNode root, Integer prefixNumber) {
        if (root == null) {
            return prefixNumber;
        }
        if (root.left == null) {
            return sumNumbers(root.right, prefixNumber*10 + root.val);
        }
        if (root.right == null) {
            return sumNumbers(root.left, prefixNumber*10 + root.val);
        }
        return sumNumbers(root.left, prefixNumber*10 + root.val)
                + sumNumbers(root.right, prefixNumber*10 + root.val);
    }

    public static void main(String[] args) {

    }
}
