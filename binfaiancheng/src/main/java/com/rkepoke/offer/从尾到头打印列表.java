package com.rkepoke.offer;
/*题目描述：
        给定一个链表，从尾部到头部打印输出链表结点的值。看到这个题目我的基本思路是：首先遍历一遍链表，统计出结点的个数，
        然后进行第二次遍历把每次访问的结点的值方到一个临时数组中，遍历结束之后，该临时数组中的值与正向遍历链表的值的顺序是一样的。
        那么在第三次遍历的时候，把上面的临时数组拷贝到另外一个临时数组中，只不过这次拷贝是从最后一个位置的值开始拷贝的，
        这样第三次遍历结束之后，第二个临时数组中的值的顺序就是从尾到头遍历链表的值的顺序了。
        最后一次遍历就是把第二个临时数组转化为一个ArrayList对象，并返回。

        已知如下条件：
public class ListNode{
    int val;
    ListNode next = null;
    ListNode(int val){
        this.val = val;
    }
    考点：链表
}*/

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

public class 从尾到头打印列表 {
    //节点的定义是内部类。
    static class ListNode{
        int val;
        ListNode next=null;
        ListNode(int val){
            this.val=val;
        }
    }
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode){//牛客网你是哪种情况没通过，它会告诉你
        //1:如果我一开始就用arrayList就没办法逆序遍历了
        int count=0;
        ListNode tempNode=listNode;
        while (tempNode!=null){
            count++;
            tempNode=tempNode.next;
        }
//        if(count==0||listNode==null){====3.有这段代码就不会报空指针异常，只会返回null，所以把这段删去即可
//            return null;
//        }
        ArrayList<Integer> list=new ArrayList<Integer>();
        int[] array=new int[count];
        int index=0;
        while (listNode!=null){//2:问题出在这，两次遍历导致listNode已经到尾了，所以应该用临时指针去遍历
            array[index++]=listNode.val;
            listNode=listNode.next;
        }
        for(int i=count-1;i>=0;i--){
            list.add(array[i]);
        }
        return list;
    }
    public static void main(String[] args) {
        //com.rkepoke.offer.从尾到头打印列表.this' cannot be referenced from a static context
        ListNode root = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);


        root.next = node1;
        node1.next = node2;
        node2.next = node3;

        List<Integer> list = new 从尾到头打印列表().printListFromTailToHead(root);
        for (Integer integer : list) {
            out.print(integer + "\t");
        }
    }

}
