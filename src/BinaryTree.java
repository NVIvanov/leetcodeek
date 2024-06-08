import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTree<T extends Comparable<T>> {
    private final T key;
    private BinaryTree<T> left;
    private BinaryTree<T> right;
    private BinaryTree<T> parent;

    public BinaryTree(T key) {
        this.key = key;
    }

    public void add(Collection<T> keys) {
        for (var key: keys) {
            add(key);
        }
    }

    public void add(T key) {
        add(new BinaryTree<>(key));
    }

    public void add(BinaryTree<T> kid) {
        if (kid.key.compareTo(key) <= 0) {
            if (left == null) {
                left = kid;
                kid.parent = this;
            } else {
                left.add(kid);
            }
        } else {
            if (right == null) {
                right = kid;
                kid.parent = this;
            } else {
                right.add(kid);
            }
        }
    }

    public void inorderTreeWalk() {
        inorderTreeWalk(this);
    }

    private static void inorderTreeWalk(BinaryTree<?> binaryTree) {
        if (binaryTree.left != null) {
            inorderTreeWalk(binaryTree.left);
        }
        System.out.println(binaryTree.key);
        if (binaryTree.right != null) {
            inorderTreeWalk(binaryTree.right);
        }
    }

    public void preorderTreeWalk() {
        preorderTreeWalk(this);
    }

    public static void preorderTreeWalk(BinaryTree<?> binaryTree) {
        System.out.println(binaryTree.key);
        if (binaryTree.left != null) {
            preorderTreeWalk(binaryTree.left);
        }
        if (binaryTree.right != null) {
            preorderTreeWalk(binaryTree.right);
        }
    }

    public void postorderTreeWalk() {
        postorderTreeWalk(this);
    }


    public static void postorderTreeWalk(BinaryTree<?> binaryTree) {
        if (binaryTree.left != null) {
            postorderTreeWalk(binaryTree.left);
        }
        if (binaryTree.right != null) {
            postorderTreeWalk(binaryTree.right);
        }
        System.out.println(binaryTree.key);
    }

    public void levelorderTreeWalk() {
        levelorderTreeWalk(this);
    }

    private static void levelorderTreeWalk(BinaryTree<?> binaryTree) {
        if (binaryTree == null) {
            return;
        }
        Queue<BinaryTree<?>> nodes = new LinkedList<>();
        nodes.add(binaryTree);
        while (true) {
            int nodeCount = nodes.size();
            if (nodeCount == 0) {
                break;
            }
            while (nodeCount > 0) {
                nodeCount--;
                var node = nodes.poll();
                if (node == null) {
                    continue;
                }
                System.out.print("(" + node.key + ")");
                System.out.print(" ");
                nodes.add(node.left);
                nodes.add(node.right);
            }
            System.out.println();
        }
    }


    public int depth() {
        return depth(this);
    }

    private static int depth(BinaryTree<?> binaryTree) {
        if (binaryTree == null) {
            return 0;
        }
        return Math.max(depth(binaryTree.left), depth(binaryTree.right)) + 1;
    }

    public BinaryTree<T> search(T key) {
        if (this.key.compareTo(key) == 0) {
            return this;
        }
        if (this.key.compareTo(key) > 0) {
            if (left != null) {
                return left.search(key);
            } else {
                return null;
            }
        } else {
            if (right != null) {
                return right.search(key);
            } else {
                return null;
            }
        }
    }

    public BinaryTree<T> min() {
        if (left != null) {
            return left.min();
        }
        return this;
    }

    public BinaryTree<T> max() {
        if (right != null) {
            return right.max();
        }
        return this;
    }

    public BinaryTree<T> successor() {
        if (right != null) {
            return right.min();
        }
        if (parent != null && this == parent.right) {
            return parent.successor();
        }
        return this;
    }

    public static void main(String[] args) {
        var tree = new BinaryTree<>(5);
        tree.add(List.of(1,2,3,4,6,7,8));
        System.out.println(tree.successor().key);
    }
}
