package com.rkepoke.offer;
/*
题目描述
        输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
自己的思路：
    1:就是两个链表取值，就是先考虑都不为空的情况，在考虑其中有为空的情况，最后在暗含一个都为空的处理
    以后想这类问题都这么去想
    2：应该有一个头结点不动，还有一个移动节点

    方法2：递归
    public ListNode Merge(ListNode list1, ListNode list2) {
        if(list1 == null) return list2;
        if(list2 == null) return list1;

        ListNode mergeListHead = null;
        if(list1.val < list2.val){
            mergeListHead = list1;
            mergeListHead.next = Merge(list1.next, list2);
        }else{
            mergeListHead = list2;
            mergeListHead.next = Merge(list1, list2.next);
        }

        return mergeListHead;
    }
————————————————
版权声明：本文为CSDN博主「rhwayfunn」的原创文章，遵循 CC 4.0 BY-SA 版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/u011116672/article/details/50207615
*/

public class 十五合并两个排序的链表 {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode Merge(ListNode list1, ListNode list2) {
        ListNode node = null;
        ListNode head=null;
        if(list1==null){
            return list2;
        }
        if (list2==null){
            return list1;
        }//能在往下执行就说明list1,list2都不为null了。
        while (list1 != null && list2 != null) {
            if (node == null) {//考虑第一个节点的特殊情况,对对，可以把这段代码提出去，这样就不用每次判断了，提高可读性
                if (list1.val < list2.val) {
                    head=node = list1;
                    list1 = list1.next;
                } else {
                    head=node = list2;
                    list2 = list2.next;
                }
            } else {
                if (list1.val < list2.val) {
                    node.next = list1;
                    node=list1;
                    list1 = list1.next;
                } else {
                    node.next = list2;
                    node=list2;//这一步是连接之后的移动
                    list2 = list2.next;
                }
            }
        }
        while (list1 != null) {//1出来的时候，node.next==null应该是这个状态; 2把if改成while；3这种是list2到头了的情况
            node.next = list1;
            node=list1;
            list1 = list1.next;
        }
        while (list2 != null) {
            node.next = list2;
            node=list2;
            list2 = list2.next;
        }
        return head;//这一步也暗含了，当list1，list2都为空的情况，如此所有的情况就都考虑到了，完美
    }
}
