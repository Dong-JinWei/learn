import java.util.Deque;
import java.util.LinkedList;

public class Solution2 {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Deque<Integer> s1 = new LinkedList<>();
        Deque<Integer> s2 = new LinkedList<>();
        ListNode p1 = l1;
        ListNode p2 = l2;
        while (p1 != null) {
            s1.push(p1.val);
            p1 = p1.next;
        }
        while (p2 != null) {
            s2.push(p2.val);
            p2 = p2.next;
        }
        ListNode ans = new ListNode(0);
        ListNode head = ans;
        while (s1 != null && s2 != null) {
            int n1 = s1.poll();
            int n2 = s2.poll();
            int n3 = n1 + n2;
            head.val = n3;
            head = head.next;
        }
        head = ans;
        while (head != null) {
            if (head.val >= 10) {
                int n1 = head.val % 10;
                int n2 = head.val / 10;
                head.next.val += n2;
                head.val = n1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        ListNode node3 = new ListNode(3, null);
        ListNode node2 = new ListNode(4, node3);
        ListNode l1 = new ListNode(2, node2);

        ListNode node5 = new ListNode(4, null);
        ListNode node4 = new ListNode(6, node5);
        ListNode l2 = new ListNode(5, node4);

        ListNode ans = addTwoNumbers(l1, l2);
        System.out.println(ans.toString());
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}