package LeetCode;

public class Remove_Nth_Node_From_End_of_List {
    public static void main(String[] args) {
        ListNode listNode = new ListNode();
        ListNode head = listNode;

        for (int i = 1; i <= 5; i++) {
            listNode.next = new ListNode(i, null);
            listNode = listNode.next;
        }

        ListNode result = removeNthFromEnd(head.next, 2);

        while (result.next != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
        System.out.println(result.val);
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode begin = new ListNode(0);
        ListNode n1 = begin, n2 = begin;
        n2.next = head;

        for (int i = 0; i < n + 1; i++) {
            n2 = n2.next;
        }

        while (n2 != null) {
            n1 = n1.next;
            n2 = n2.next;
        }

        n1.next = n1.next.next;
        return begin.next;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {}

        ListNode(int val) {

            this.val = val;
        }

        ListNode(int val, ListNode next) {

            this.val = val;
            this.next = next;
        }
    }
}
