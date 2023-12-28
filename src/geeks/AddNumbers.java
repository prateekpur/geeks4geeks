package geeks;

//https://leetcode.com/problems/add-two-numbers/
public class AddNumbers {
    public static void main(String args[])  {
        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(9);
        l1.next.next = new ListNode(9);
        l1.next.next.next = new ListNode(9);
        l1.next.next.next.next = new ListNode(9);
        l1.next.next.next.next.next = new ListNode(9);
        l1.next.next.next.next.next.next = new ListNode(9);
        //l1.next = new ListNode(4);
        //l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(9);
        l2.next.next = new ListNode(9);
        l2.next.next.next = new ListNode(9);
        //l2.next = new ListNode(6);
        //l2.next.next = new ListNode(4);

        ListNode head = addTwoNumbers(l1, l2);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head, tmp, last;
        tmp = new ListNode();
        head = null; last = null;
        boolean carryFwd = false;
        int val;
        while (l1 != null && l2 != null)    {
            tmp = new ListNode();
            val = l1.val + l2.val;
            if (carryFwd)   {
                ++val;
            }
            carryFwd = false;
            if (val >= 10)   {
                carryFwd = true;
                val %= 10;
            }
            tmp.val = val;
            if (head == null)  {
                head = tmp;
                last = tmp;
            }   else {
                last.next = tmp;
                last = tmp;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        if (l1 != null) {
            tmp = l1;
        }   else if (l2 != null) {
            tmp = l2;
        }   else {
            tmp = null;
            if (carryFwd)   {
                last.next = new ListNode(1);
            }
        }
        while (tmp != null) {
            int val1 = tmp.val;
            if (carryFwd)   {
                carryFwd = false;
                ++val1;
                if (val1 >= 10) {
                    carryFwd = true;
                    val1 %= 10;
                }
            }
            ListNode tmp1 = new ListNode(val1);
            last.next = tmp1;
            last = last.next;
            tmp = tmp.next;
        }
        if (carryFwd)   {
            last.next = new ListNode(1);
        }
        return head;
    }
}
