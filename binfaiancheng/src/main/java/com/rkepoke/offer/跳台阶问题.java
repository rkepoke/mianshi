package com.rkepoke.offer;
/*题目描述
        一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
思路
        这种问题的思路一般是采用数学归纳法，仍然是一个斐波那契数列问题*/
public class 跳台阶问题 {
    public int JumpFloor(int target) {
        if(target==1){
            return 1;
        }else if(target==2){
            return 2;
        }
        int one=1;
        int two=2;
        int sum=0;
        for(int i=3;i<=target;i++){
            sum=one+two;
            one=two;
            two=sum;
        }
        return sum;
    }
}
