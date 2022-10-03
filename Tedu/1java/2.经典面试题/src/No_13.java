import java.util.List;

/**
 第13题：
 题目：输入一个单向链表，输出该链表中倒数第k个结点。链表的倒数第0个结点为链表的尾指针。
 链表结点定义如下：
 struct ListNode
 {
 int m_nKey;
 ListNode* m_pNext;
 };

 */
public class No_13 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        LinkList linkList = new LinkList();
        linkList.add(node1);
        linkList.add(node2);
        linkList.add(node3);
        linkList.add(node4);
        linkList.add(node5);
        linkList.show();

        linkList.findLastIndexNode(linkList.getHead(), 2);
    }
}


class ListNode {
    int key;
    ListNode next;

    public ListNode(int key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "key=" + key + "}";
    }
}

class LinkList {
    private ListNode head = new ListNode(0);

    public ListNode getHead() {
        return head;
    }

    public ListNode findLastIndexNode(ListNode head, int index) {
        ListNode cur = head.next;
        int size = 0;
        while (true) {
            if (cur == null) {
                break;
            }
            size++;
            cur = cur.next;
        }
        cur = head.next;
        for (int i = 0; i < size - index; i++) {

            cur = cur.next;
        }
        System.out.print(cur.key + " ");
        return cur;
    }

    public void add(ListNode newNode) {
        ListNode cur = head;
        while (true) {
            if (cur.next == null) {
                cur.next = newNode;
                break;
            }
            cur = cur.next;
        }
    }

    public void show() {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        ListNode temp = head.next;
        while (true) {
            if (temp == null) {
                break;
            }
            System.out.println(temp.toString());
            temp = temp.next;
        }
    }
}