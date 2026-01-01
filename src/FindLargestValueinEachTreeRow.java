import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindLargestValueinEachTreeRow {

    static class Solution {
        public List<Integer> largestValues(TreeNode root) {
            Map<Integer, Integer> maximum = new HashMap<>();
            helper(root, maximum, 0);
            return new ArrayList<>(maximum.values());
        }

        private void helper(TreeNode root, Map<Integer, Integer> largest, int level) {
            if (root == null) {
                return;
            }
            largest.putIfAbsent(level, Integer.MIN_VALUE);
            largest.compute(level, (k, v) -> Math.max(v, root.val));
            helper(root.left, largest, level + 1);
            helper(root.right, largest, level + 1);
        }
    }

    public static void main(String[] args) {

    }
}
