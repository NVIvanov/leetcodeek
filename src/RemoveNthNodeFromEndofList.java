import java.util.List;

public class RemoveNthNodeFromEndofList {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(val);
            if (next != null) {
                sb.append(" -> (").append(next).append(")");
            }
            return sb.toString();
        }

        public static ListNode of(int... vals) {
            ListNode current = null;
            ListNode head = null;
            for (var val: vals) {
                ListNode prev = current;
                current = new ListNode(val);
                if (head == null) {
                    head = current;
                }
                if (prev != null) {
                    prev.next = current;
                }
            }
            return head;
        }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        int length = 1;
        ListNode curr = head;
        while ((curr = curr.next) != null) length++;
        int nFromB = length - n - 1;
        if (nFromB < 0) {
            if (length == 1) {
                return null;
            } else {
                return head.next;
            }
        }
        curr = head;
        for (int i = 0; i < nFromB; i++) {
            curr = curr.next;
        }
        if (curr.next.next == null) {
            curr.next = null;
        } else {
            curr.next = curr.next.next;
        }
        return head;
    }

    public static void main(String[] args) {
        System.out.println(removeNthFromEnd(ListNode.of(1, 2, 3, 4, 5), 5));
        System.out.println(removeNthFromEnd(ListNode.of(1), 1));
    }
}
