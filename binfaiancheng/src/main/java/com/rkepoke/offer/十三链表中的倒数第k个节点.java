package com.rkepoke.offer;
/*
题目描述
        输入一个链表，输出该链表中倒数第k个结点
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
思路：
    1：倒数第k，即顺数第length-k+1位。
    2：因为java中节点都是new的，所以链表都是不带头结点的，第一个元素就是含有值的。
    3：这题难就难在你能不能把所有的情况都想到，并描述出来。比如：k的范围判断，最后的判决条件

    方法2：还有一种思路就是创建两个指针，一个指针先走k-1部，当第k部的时候，另一个指针从第一个节点开始走，
    这样，第一个指针到达最后一个指针的时候，第二个指针刚好到达倒数第k个节点的位置。实现代码如下（已被牛客AC）：
    public ListNode FindKthToTail2(ListNode head,int k) {
        if(head == null || k <= 0) return null;
        ListNode pre = head;
        ListNode behind = null;
        for (int i = 0; i < k - 1; i++) {
            if(pre.next != null){
                pre = pre.next;
            }else {
                return null;
            }
        }

        behind = head;
        while(pre.next != null){
            pre = pre.next;
            behind = behind.next;
        }
        return behind;
    }
*/

public class 十三链表中的倒数第k个节点 {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode FindKthToTail(ListNode head, int k) {
        if (head == null || k < 0) {//把这两种特殊情况先说明
            return null;
        }
        int nodeNum = 1;//既然链表非空，那么最起码长度为1
        ListNode node = head;
        while (node.next != null) {
            nodeNum++;
            node = node.next;
        }
        int i = 1;//记录的是顺数的位子
        node = head;//重新回到首尾，进行第二轮遍历
        while (k <= nodeNum && i != nodeNum - k + 1) {//谁能想到在这限定k的范围呢， k<=nodeNum这个判断在一开始是无法进行的，因为不知道总长度
            i++;
            node = node.next;
        }
        if (k <= nodeNum) {//k符合规范，才返回正确的节点
            return node;
        }
        return null;
    }
}
