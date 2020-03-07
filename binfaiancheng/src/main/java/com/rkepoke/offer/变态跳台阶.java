package com.rkepoke.offer;
/*题目描述
        一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
  思路：
  1.n级台阶，第一步有n种跳法：跳1级、跳2级、到跳n级

2.跳1级，剩下n-1级，则剩下跳法是f(n-1)
3.跳2级，剩下n-2级，则剩下跳法是f(n-2)
4.因此f(n)=f(n-1)+f(n-2)+...+f(1)；
  又因为f(n-1)=f(n-2)+f(n-3)+...+f(1)；
  两式相减， 所以f(n)=2*f(n-1)；

    竟然使用数学推导，推出公式的

  所以f(n)=2^(n-1)

        */
public class 变态跳台阶 {
    public int JumpFloorII(int target) {
       if(target==1){
           return 1;
       }
       return (int) Math.pow(2,(target-1));
    }
}
