public class MiddleoftheLinkedList {

    public RemoveNthNodeFromEndofList.ListNode middleNode(RemoveNthNodeFromEndofList.ListNode head) {
        if (head == null) {
            return null;
        }
        int length = 0;
        RemoveNthNodeFromEndofList.ListNode start = head;
        while (head.next != null) {
            head = head.next;
            length++;
        }
        length = length / 2 + length % 2 == 0 ? 1: 0;
        head = start;
        for (int i = 0; i < length; i++) {
            head = head.next;
        }
        return head;
    }

    public static void main(String[] args) {

    }
}
