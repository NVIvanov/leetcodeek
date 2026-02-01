import java.util.ArrayList;
import java.util.List;

public class MaximumLevelSumofaBinaryTree {

    class Solution {
        List<Integer> sums = new ArrayList<>();
        public int maxLevelSum(TreeNode root) {
            calculateLevelSums(root, 0);
            int maxLevel = 0;
            for (int i = 0; i < sums.size(); i++) {
                if (sums.get(maxLevel) < sums.get(i)) {
                    maxLevel = i;
                }
            }
            return maxLevel + 1;
        }

        void calculateLevelSums(TreeNode node, int level) {
            if (node == null) {
                return;
            }
            if (sums.size() < level + 1) {
                sums.add(0);
            }
            sums.set(level, sums.get(level) + node.val);
            calculateLevelSums(node.left, level + 1);
            calculateLevelSums(node.right, level + 1);
        }
    }

    public static void main(String[] args) {

    }
}
