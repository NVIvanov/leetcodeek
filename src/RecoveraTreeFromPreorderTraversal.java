import java.util.LinkedList;
import java.util.Queue;

public class RecoveraTreeFromPreorderTraversal {

    static class Solution {
        public TreeNode recoverFromPreorder(String traversal) {
            Queue<LevelToValue> levelToValues = parseTraversal(traversal);
            TreeNode root = new TreeNode(levelToValues.poll().value);
            fillTree(root, levelToValues, 0);
            return root;
        }

        private void fillTree(TreeNode root, Queue<LevelToValue> levelToValues, int level) {
            if (levelToValues.isEmpty()) {
                return;
            }
            if (levelToValues.peek().level > level) {
                if (root.left == null) {
                    root.left = new TreeNode(levelToValues.poll().value);
                    fillTree(root.left, levelToValues, level + 1);
                } else if (root.right == null) {
                    root.right = new TreeNode(levelToValues.poll().value);
                    fillTree(root.right, levelToValues, level + 1);
                }
            }
            if (!levelToValues.isEmpty() && levelToValues.peek().level > level) {
                if (root.right == null) {
                    root.right = new TreeNode(levelToValues.poll().value);
                    fillTree(root.right, levelToValues, level + 1);
                }
            }
        }

        record LevelToValue(int level, int value) {}

        Queue<LevelToValue> parseTraversal(String traversal) {
            Queue<LevelToValue> result = new LinkedList<>();
            int level = 0;
            int num = 0;
            for (int i = 0; i < traversal.length(); i++) {
                if (traversal.charAt(i) == '-') {
                    if (num != 0) {
                        result.add(new LevelToValue(level, num));
                        level = 0;
                        num = 0;
                    }
                    level++;
                } else {
                    num = num * 10 + traversal.charAt(i) - '0';
                }
            }
            result.add(new LevelToValue(level, num));
            return result;
        }
    }

    public static void main(String[] args) {
        var result  = new Solution().recoverFromPreorder("1-401--349---90--88");
        System.out.println(result);
    }


}
