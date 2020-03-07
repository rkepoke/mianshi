package com.rkepoke.offer;

/*题目描述
        我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？

        比如n=3时，2*3的矩形块有3种覆盖方法：  图像省略了
思路：
        依旧是斐波那契数列
        2n的大矩形，和n个21的小矩形
        其中target2为大矩阵的大小

        21代表竖着放，12代表横着放

        有以下几种情形：
        1⃣️target <= 0 大矩形为<= 20,直接return 1；
        2⃣️target = 1大矩形为21，只有一种摆放方法，return1；
        3⃣️target = 2 大矩形为22，有两种摆放方法，return2；21+21,12+12这两种方法
        4⃣️target = n 分为两步考虑：
        第一次摆放一块 21 (即竖着放)的小矩阵，则摆放方法总共为f(target - 1)

        第一次摆放一块12(即横着放，这样另外一个空间也只能横着放)的小矩阵，则摆放方法总共为f(target-2)
        因为，摆放了一块12的小矩阵（用√√表示），对应下方的12（用××表示）摆放方法就确定了，所以为f(targte-2)
        所以，这样看来，依旧是斐波那契数列
       */
public class 矩形覆盖问题 {
    public int RectCover(int target) {
        if (target == 1) {
            return 1;
        } else if (target == 2) {
            return 2;
        }
        int one = 1;
        int two = 2;
        int sum = 0;
        for (int i = 3; i <= target; i++) {
            sum = one + two;
            one = two;
            two = sum;
        }
        return sum;
    }
}
