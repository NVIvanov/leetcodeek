import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class EvenOddTree {

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

    public boolean isEvenOddTree(TreeNode root) {

        int level = 0;
        int prevNumber = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        TreeNode node;
        while (!q.isEmpty()) {
            List<TreeNode> l = new LinkedList<>();
            while (!q.isEmpty()) {
                node = q.poll();
                if (node == null) {
                    continue;
                }
                if (level % 2 == 0) {
                    if (node.val % 2 == 0 || node.val <= prevNumber) {
                        return false;
                    }
                } else {
                    if (node.val % 2 != 0 || node.val >= prevNumber) {
                        return false;
                    }
                }
                System.out.println(node.val);
                l.add(node.left);
                l.add(node.right);
                prevNumber = node.val;
            }
            q.addAll(l);
            level++;
            if (level % 2 == 0) {
                prevNumber = 0;
            } else {
                prevNumber = Integer.MAX_VALUE;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        new EvenOddTree().isEvenOddTree(
                new TreeNode(1,
                        new TreeNode(10,
                                new TreeNode(3,
                                        new TreeNode(12), new TreeNode(8)),
                                null
                        ),
                        new TreeNode(4,
                                new TreeNode(7, new TreeNode(6), null),
                                new TreeNode(9, null, new TreeNode(2))
                        )
                )
        );
    }
}
