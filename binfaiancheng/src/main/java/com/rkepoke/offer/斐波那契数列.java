package com.rkepoke.offer;
/*
题目描述
        大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
        n<=39
思路：
    不用递归，用迭代，才是王道，递归当N很大的时候就不适用了
        package com.rhwayfun.offer;

public class Fibonacci {

    public int getN(int n){
        if(n == 0){
            return 0;
        }else if(n == 1){
            return 1;
        }

        int one = 1;
        int two = 0;
        int sum = 0;
        for (int i = 2; i <= n; i++) {
            sum = one + two;
            two = one;
            one = sum;
        }
        return sum;
    }

    public static void main(String[] args) {
        long a = new Fibonacci().getN(3);
        System.out.println(a);
    }
}
*/

public class 斐波那契数列 {
    public int Fibonaccil(int n){
        if(n==0){
            return 0;
        }else if(n==1){
            return 1;
        }
        int one=0;
        int two=1;
        int sum=0;
        for(int i=2;i<=n;i++){//从n>=2的时候就开始用迭代来解决问题了;;每次都有新的one，每次都有新的two
            sum=one+two;
            one=two;
            two=sum;
        }
        return sum;
    }

    public int Fibonacci1(int n) {
        if(n==0){
            return 0;
        }
        if(n==1||n==2){
            return 1;
        }
        return Fibonacci1(n-1)+Fibonacci1(n-2);
    }
    public static void main(String[] args) {
        long a = new 斐波那契数列().Fibonaccil(3);
        System.out.println(a);
    }
}
