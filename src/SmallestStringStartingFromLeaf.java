public class SmallestStringStartingFromLeaf {

    public String smallestFromLeaf(TreeNode root) {
        return smallestFromLeaf(root, "");
    }

    public String smallestFromLeaf(TreeNode root, String suffix) {
        if (root.left == null && root.right == null) {
            return ((char)(root.val + 'a')) + suffix;
        }
        if (root.left != null && root.right != null) {
            return getLexicographicallySmallerString(
                    smallestFromLeaf(root.left, ((char)(root.val + 'a')) + suffix),
                    smallestFromLeaf(root.right, ((char)(root.val + 'a')) + suffix)
            );
        }
        if (root.right != null) {
            return smallestFromLeaf(root.right, ((char)(root.val + 'a')) + suffix);
        }
        return smallestFromLeaf(root.left, ((char)(root.val + 'a')) + suffix);
    }

    public static String getLexicographicallySmallerString(String str1, String str2) {
        if (str1.compareTo(str2) < 0) {
            return str1;
        } else {
            return str2;
        }
    }

    public static void main(String[] args) {
        System.out.println(new SmallestStringStartingFromLeaf().smallestFromLeaf(
                TreeNode.createTreeFromArray(new int[]{0,1,2,3,4,3,4})
        ));
    }
}
