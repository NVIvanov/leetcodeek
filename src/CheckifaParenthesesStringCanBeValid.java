import java.util.Stack;

public class CheckifaParenthesesStringCanBeValid {

    static class Solution {
        public boolean canBeValid(String s, String locked) {
            Stack<Character> stack = new Stack<>();
            Stack<Integer> indexStack = new Stack<>();
            for (int i = 0; i < locked.length(); i++) {
                char ch = s.charAt(i);
                if (ch == '(') {
                    stack.push(ch);
                    indexStack.push(i);
                } else if (ch == ')') {
                    if (stack.isEmpty()) {
                        if (locked.charAt(i) == '1') {
                            return false;
                        } else {
                            stack.push(ch);
                            indexStack.push(i);
                        }
                    } else {
                        stack.pop();
                        indexStack.pop();
                    }
                }
            }
            int count = 0;
            while (!indexStack.isEmpty()) {
                int index = indexStack.pop();
                if (locked.charAt(index) == '1') {
                    return false;
                }
                count++;
            }
            return count % 2 == 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().canBeValid("(()())","000000"));
    }
}
