package com.rkepoke.offer;

import java.util.Stack;
/*
题目描述
        用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
思路：
        思路：由于队列是先进先出的，而栈是先进后出的，所以要用2个栈来实现队列的入队出队功能，队列的入队功能与栈的一样，
        出队时，先将第一个栈中的元素全部弹出，并倒入到第二个栈中，将第二个栈中栈顶元素弹出，
        并将stack2中剩下的元素倒回到stack1中，即实现一次出队

*/

public class 用两个栈实现队列 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        while (!stack1.empty()){
            stack2.push(stack1.pop());
        }
        int number=stack2.pop();
        while (!stack2.empty()){
            stack1.push(stack2.pop());
        }
        return number;
    }
    public static void main(String[] args) {
        用两个栈实现队列 cq = new 用两个栈实现队列();
        cq.push(1);
        cq.push(2);
        cq.push(3);

        System.out.println(cq.pop());
        System.out.println(cq.pop());
        System.out.println(cq.pop());

        cq.push(4);
        System.out.println(cq.pop());
    }

}
