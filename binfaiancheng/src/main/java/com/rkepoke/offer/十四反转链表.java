package com.rkepoke.offer;

/*题目描述
        输入一个链表，反转链表后，输出新链表的表头。
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
思路：
        在遍历链表上的每个节点的时候，就修改其指针，当遍历到最后一个结点的时候，整个链表就反转完成了。所以需要创建三个变量：
        一个是当前遍历的结点，一个是遍历结点的前一个结点，还有一个是当前遍历结点的下一个结点。基于这种思路可以写出如下的实现代码
就是看你能不能想到所有情况，并对每种情况做出处理，   最重要的是对结果的处理要归一
*/
public class 十四反转链表 {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode ReverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode headNode = null;
        ListNode curNode = head;
        ListNode preNode = null;
        if(curNode.next==null){//特殊情况，只有一个节点的时候
            headNode=curNode;
        }
        while (curNode.next != null) {
//            if (curNode.next == null) {//
//                headNode = curNode;
//            }
            headNode=curNode.next;
            curNode.next = preNode;//这里思考始终有一个问题就是前一个节点如何处置
            preNode = curNode;
            curNode=headNode;
//            curNode = curNode.next;
        }
        //第一遍时我忘记了处理最后一个节点
        headNode.next=preNode;
        return headNode;
    }

}
