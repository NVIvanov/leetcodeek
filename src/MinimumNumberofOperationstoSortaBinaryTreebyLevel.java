import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimumNumberofOperationstoSortaBinaryTreebyLevel {

    static class Solution {
        public int minimumOperations(TreeNode root) {
            Map<Integer, List<TreeNode>> map = new HashMap<>();
            fillMap(map, root, 0);
            int maxLevel = map.keySet().stream().max(Integer::compareTo).orElse(0);

            int res = 0;

            for (int i = 1; i <= maxLevel; i += 2) {
                var nodesAtSameLevel = map.get(i);
                var values = nodesAtSameLevel.stream().map(node -> node.val).toList();
                var sorted = values.stream().sorted().toList();
                int count = 0;
                for (int j = 0; j < sorted.size(); j++) {
                    if (sorted.get(j).equals(values.get(j))) {
                        count++;
                    }
                }
                if (count % 2 == 1) {
                    count++;
                }
                res += count / 2;
            }

            return res;
        }

        private void fillMap(Map<Integer, List<TreeNode>> map, TreeNode root, int level) {
            if (root == null) {
                return;
            }
            map.computeIfAbsent(level, l -> new ArrayList<>()).add(root);
            fillMap(map, root.left, level + 1);
            fillMap(map, root.right, level + 1);
        }
    }

    public static void main(String[] args) {
        TreeNode.createTreeFromArray(
                new Integer[]{1,4,3,7,6,8,5,null,null,null,null,9,null,10}
        );
    }
}
