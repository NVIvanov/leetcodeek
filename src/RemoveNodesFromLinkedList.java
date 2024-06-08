public class RemoveNodesFromLinkedList {

    public static ListNode removeNodes(ListNode head) {
        var max = new int[1];
        removeNodes(head, max);
        if (head.next != null && head.val < max[0]) return head.next;
        return head;
    }

    private static void removeNodes(ListNode head, int[] max) {
        if (head.next != null) {
            removeNodes(head.next, max);
            if (max[0] > head.next.val) {
                head.next = head.next.next;
            } else {
                max[0] = head.next.val;
            }
        } else {
            max[0] = head.val;
        }
    }

    public static void main(String[] args) {
        var result = removeNodes(new ListNode(5, new ListNode(2, new ListNode(13, new ListNode(3, new ListNode(8))))));
        System.out.println("res");
    }
}
