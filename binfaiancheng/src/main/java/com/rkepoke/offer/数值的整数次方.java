package com.rkepoke.offer;

/*
题目描述
        给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
        保证base和exponent不同时为0

考点：代码的健壮性
思路：
        1：首先，我觉得这道题思路应该很简单，幂的情况无非是三种：正数、0和负数。当幂是0的时候，直接返回1；
        当幂是负数的时候，需要先把其转化为正数来处理，然后返回其倒数就可以了；当幂是正数的时候，按照正常的计算方法就可以。
        实际上这道题主要考察时代码的健壮性——就是对幂的情况的考虑是否周全
       2：作者并没有用原始的类库函数pow，而是自己通过循环去实现数的次方运算
*/

public class 数值的整数次方 {
    public double Power(double base, int exponent) {
        double result = base;//因为是自己通过循环去求解的，所以要用一个临时变量来记录结果
        if (exponent == 0) {
            return 1;
        }
        if (exponent > 0) {
            for (int i = 1; i < exponent; i++) {//幂为1的时候就是它自己，所以不用运算
                result *= base;
            }
            return result;
        } else {
            int temExponent = -exponent;
            for (int i = 1; i < temExponent; i++) {
                result *= base;
            }
            return 1 / result;
        }
    }
}
