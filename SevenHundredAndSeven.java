package leetcode2;

import java.util.Calendar;

/**
 * @author : ljg
 * @ClassName: SevenHundredAndSeven
 * @Description 707. 设计链表
 *
 * 设计链表的实现。您可以选择使用单链表或双链表。
 * 单链表中的节点应该具有两个属性：val 和 next。val 是当前节点的值，next 是指向下一个节点的指针/引用。
 * 如果要使用双向链表，则还需要一个属性 prev 以指示链表中的上一个节点。假设链表中的所有节点都是 0-index 的。
 *
 * 在链表类中实现这些功能：
 *
 *     get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1。
 *     addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
 *     addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。
 *     addAtIndex(index,val)：在链表中的第 index 个节点之前添加值为 val  的节点。
 *          如果 index 等于链表的长度，则该节点将附加到链表的末尾。如果 index 大于链表长度，则不会插入节点。
 *          如果index小于0，则在头部插入节点。
 *     deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。
 * @date : 2022/5/17 19:47
 */
public class SevenHundredAndSeven {

}

class MyLinkedList {
    //单链表
    public class ListNode {
        int val;
        ListNode next;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    int len;
    //虚拟节点
    ListNode head;

    //初始化链表
    public MyLinkedList() {
        len = 0;
        head = new ListNode();
    }

    //get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1。
    public int get(int index) {
        if(index < 0 || index > len){
            return -1;
        }
        ListNode tmp = head;
        for (int i = 0;i <= index;i++) {
            tmp = tmp.next;
        }
        return tmp.val;
    }
    //addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
    public void addAtHead(int val) {
        ListNode p = new ListNode(0);
        p.val = val;
        p.next = head.next;
        head.next = p;
        len++;
    }
    //addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。
    public void addAtTail(int val) {
        ListNode p = new ListNode(0);
        ListNode q = head;
        p.val = val;
        while (q.next != null) {
            q = q.next;
        }
        q.next = p;
        p.next = null;
        len++;
    }
    //addAtIndex(index,val)：在链表中的第 index 个节点之前添加值为 val  的节点。
    // 如果 index 等于链表的长度，则该节点将附加到链表的末尾。如果 index 大于链表长度，则不会插入节点。
    // 如果index小于0，则在头部插入节点。
    public void addAtIndex(int index, int val) {
        if (index > len) {
            return;
        }else if (index == len) {
            addAtTail(val);
        }else if (index < 0) {
            addAtHead(val);
        }else {
            ListNode p = new ListNode(0);
            ListNode q = head;
            p.val = val;
            for (int i = 0;i < index;i++) {
                q = q.next;
            }
            p.next = q.next;
            q.next = p;
            len++;
        }

    }
    //deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。
    public void deleteAtIndex(int index) {
        if (index > 0 && index < len) {
            ListNode q = head;
            for (int i = 0;i < index;i++) {
                q = q.next;
            }
            q.next = q.next.next;
            len--;
        }
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */