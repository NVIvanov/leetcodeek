public class MergeKLists {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    public static class Solution {
        public static ListNode mergeKLists(ListNode[] lists) {
            if (lists.length == 0) {
                return new ListNode();
            }
            mergeLists(lists, 0, lists.length / 2, lists.length);
            return lists[0];
        }

        public static void mergeLists(ListNode[] lists, int l, int mid, int r) { //мержим листы в l и возвращаем l
            if (l == mid) {
                // вырожденный случай
                return;
            }
            if (l != r - 1) {// не соседние листы, значит идем вглубь
                mergeLists(lists, l, (mid + l) / 2, mid);
                //мержим
                mergeLists(lists, mid, (r + mid) / 2, r);
            }
            if (l == mid - 1) {
                if (lists[l] == null) {
                    lists[l] = lists[mid];
                } else {
                    merge(lists[l], lists[mid]);
                }
            } else {
                merge(lists[l], lists[mid]);
            }
        }

        public static void merge(ListNode l1, ListNode l2) {
            var node1 = l1;
            var node2 = l2;
            ListNode prevNode = null;
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
        }

        public static void main(String[] args) {
            ListNode l1 = new ListNode(1, new ListNode(4, new ListNode(5)));
            ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));
            ListNode l3 = new ListNode(2, new ListNode(6));
            var arr = new ListNode[]{l1, l2, l3};
            mergeKLists(arr);
            while (l1 != null) {
                System.out.println(l1.val);
                l1 = l1.next;
            }
        }
    }

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
    }
}
