public class MergeTwoSortedLists {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        var node1 = list1;
        var node2 = list2;
        ListNode prevNode = null;
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        while (node1 != null && node2 != null) {
            if (node2.val <= node1.val) {

                int tmp = node1.val;
                node1.val = node2.val;
                node2.val = tmp;

                ListNode tmpNode = node1.next;
                node1.next = node2;
                ListNode tmp2 = node2.next;
                node1.next.next = tmpNode;
                node2 = tmp2;
            }
            prevNode = node1;
            node1 = node1.next;
        }
        if (prevNode != null && node2 != null) {
            prevNode.next = node2;
        }
        return list1;
    }
}
