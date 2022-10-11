package LeetCode;

public class Add_Two_Numbers {
    public static void main(String[] args) {

    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode listNode = new ListNode();
        ListNode answer = listNode;
        int roundUp = 0;

        while (l1 != null || l2 != null) {
            int sum = roundUp;

            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            roundUp = sum / 10;
            sum %= 10;

            listNode.next = new ListNode(sum);
            listNode = listNode.next;
        }

        if (roundUp > 0) {
            listNode.next = new ListNode(roundUp);
        }

        return answer;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
