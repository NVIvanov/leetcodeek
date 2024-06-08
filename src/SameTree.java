public class SameTree {
    
     public static class TreeNode {
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

    public static boolean isSameTree(TreeNode p, TreeNode q) {
         if (p == null && q == null) {
             return true;
         }
         if (p == null || q == null) {
             return false;
         }
         boolean eq = p.val == q.val;
         return eq && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static void main(String[] args) {
        System.out.println(isSameTree(new TreeNode(0, new TreeNode(-5), null),
                new TreeNode(0, new TreeNode(-8), null)));
    }
}
