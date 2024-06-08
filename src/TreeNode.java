import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
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

    public static TreeNode createTreeFromArray(int[] array) {
        if (array == null || array.length == 0) {
            return null;
        }

        TreeNode root = new TreeNode(array[0]); // Initialize the root with the first element
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int i = 1; // Start with the second element in the array
        while (i < array.length) {
            TreeNode current = queue.poll(); // Remove and get the front of the queue

            // Check and assign the left child
            if (i < array.length) {
                if (array[i] != Integer.MIN_VALUE) { // Check if the value is a placeholder for 'null'
                    current.left = new TreeNode(array[i]);
                    queue.offer(current.left);
                }
                i++;
            }

            // Check and assign the right child
            if (i < array.length) {
                if (array[i] != Integer.MIN_VALUE) { // Check if the value is a placeholder for 'null'
                    current.right = new TreeNode(array[i]);
                    queue.offer(current.right);
                }
                i++;
            }
        }

        return root;
    }
}
