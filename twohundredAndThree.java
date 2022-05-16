package leetcode2;

/**
 * @author : ljg
 * @ClassName: twohundredAndThree
 * @Description 203. 移除链表元素
 * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
 * @date : 2022/5/16 20:41
 */

public class twohundredAndThree {
    //方式三：递归
    public ListNode removeElements(ListNode head, int val) {
        if (head == null){
            return null;
        }
        head = removeElements(head.next,val);
        if (head.val == val) {
            return head.next;
        }else {
            return head;
        }
    }
    //方式二：添加虚拟头节点
//    public ListNode removeElements(ListNode head, int val) {
//        //加一个头节点
//        ListNode virtualNode = new ListNode(val - 1);
//        virtualNode.next = head;
//        ListNode p = virtualNode;
//        while (p.next != null) {
//            if (p.next.val == val) {
//                p.next = p.next.next;
//            }else {
//                p = p.next;
//            }
//        }
//        return virtualNode.next;
//    }

    //方式一：头节点另作考虑
//    public ListNode removeElements(ListNode head, int val) {
//        //当链表表头元素需要去除时
//        while (head != null && head.val == val) {
//            head = head.next;
//        }
//        if(head==null){
//            return head;
//        }
//        ListNode p = head;
//        while(p.next != null) {
//            if (p.next.val == val){
//                p.next = p.next.next;
//            }else{
//                p = p.next;
//            }
//        }
//        return head;
//    }
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}


