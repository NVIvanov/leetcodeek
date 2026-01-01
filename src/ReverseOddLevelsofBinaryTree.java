import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReverseOddLevelsofBinaryTree {

    static class Solution {
        public TreeNode reverseOddLevels(TreeNode root) {
            Map<Integer, List<TreeNode>> map = new HashMap<>();
            fillMap(map, root, 0);
            int maxLevel = map.keySet().stream().max(Integer::compareTo).orElse(0);

            for (int i = 1; i <= maxLevel; i += 2) {
                var nodesAtSameLevel = map.get(i);
                var values = nodesAtSameLevel.stream().map(node -> node.val).toList();
                for (int j = 0; j < nodesAtSameLevel.size(); j++) {
                    nodesAtSameLevel.get(j).val = values.get(values.size() - 1 - j);
                }
            }

            return root;
        }

        private void fillMap(Map<Integer, List<TreeNode>> map, TreeNode root, int level) {
            if (root == null) {
                return;
            }
            if (level % 2 == 1) {
                map.computeIfAbsent(level, l -> new ArrayList<>()).add(root);
            }
            fillMap(map, root.left, level + 1);
            fillMap(map, root.right, level + 1);
        }
    }

    public static void main(String[] args) {
        TreeNode tree = TreeNode.createTreeFromArray(new Integer[]{7, 11, 13});
        System.out.println(new Solution().reverseOddLevels(tree));
    }
}
