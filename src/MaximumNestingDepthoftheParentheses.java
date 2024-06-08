public class MaximumNestingDepthoftheParentheses {

    public static int maxDepth(String s) {
        int depth = 0, maxDepth = 0;
        for (var c: s.toCharArray()) {
            if (c == '(') {
                depth += 1;
            } else if (c == ')') {
                depth -= 1;
            }
            maxDepth = Math.max(maxDepth, depth);
        }
        return maxDepth;
    }

    public static void main(String[] args) {

    }
}
