import java.math.BigInteger;
import java.util.Arrays;
import java.util.Stack;

public class DoubleaNumberRepresentedasaLinkedList {

    public ListNode doubleIt(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode current = head;
        int add = 0;
        while (current != null) {
            stack.push(current);
            current = current.next;
        }
        while (!stack.isEmpty()) {
            current = stack.pop();
            current.val = current.val * 2 + add;
            if (current.val > 9) {
                add = current.val / 10;
                current.val = current.val % 10;
            } else {
                add = 0;
            }
        }
        if (add > 0) {
            ListNode newHead = new ListNode(add);
            newHead.next = head;
            return newHead;
        }
        return head;
    }

    public static void main(String[] args) {

    }
}
