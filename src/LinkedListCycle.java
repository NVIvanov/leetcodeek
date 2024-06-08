public class LinkedListCycle {
    public boolean hasCycle(RemoveNthNodeFromEndofList.ListNode head) {
        if (head == null) {
            return false;
        }
        while (head.next != null) {
            if (head.val == 1000000) {
                return true;
            }
            head.val = 1000000;
            head = head.next;
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
