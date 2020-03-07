package com.rkepoke.offer;
/*题目描述
        输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
        所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
自己的思路：
    双指针法，从头到尾,适用于可改变相对位置的情况
    由于题目规定不能改变原来元素的相对位置，所以只能采用这种方法。
    但是剑指offer原题中并没有这个要求——如果可以改变元素的相对位置的话，可以采用双指针的方法，
    让第一个指针指向偶数，第二个指针指向奇数，并且第一个指针在第二个指针的前面，就交换两个元素。
    这样，当第一个指针在第二个指针的后面的时候，就说明所有的奇数都移动到所有偶数的前面了。这时候的循环就可以结束了
    public void reOrderArray(int[] array) {
        if(array == null || array.length == 0) return;

        int evenIndex = 0;
        int oddIndex = array.length - 1;
        while(evenIndex < oddIndex){
            while(evenIndex < oddIndex && (array[evenIndex] & 0x1) != 0){//(array[evenIndex] & 0x1) != 0这是模2的另一种写法
                evenIndex++;//找到偶数则停止
            }
            while(evenIndex < oddIndex && (array[oddIndex] & 0x1) == 0){
                oddIndex--;
            }
            //如果指向偶数的指针仍再指向奇数指针的前面，则交换两个数的值
            if(evenIndex < oddIndex){//这个判断条件，换完后就不换了
                swap(array,evenIndex,oddIndex);
            }
        }
    }
    1：双指针的写法我都不会写，还要看别人的
    2：&运算中1&1=1,1&0=0,0&0=0  array[oddIndex] & 0x1  有个规律，奇数最后一位一定是1，偶数最后一位是0，根据&运算，就可以判断奇偶了

    对于不可改变相对位置的
    方法（2）：类似于冒泡排序，从头开始，相邻元素只要是前偶后奇就交换，不同的是内循环每次都从头开始，
    防止一开始就有许多连续的偶数情况
    void reOrderArray(vector<int> &array) {

	int len = array.size();

	for (int i = 0; i < len; i++)
	{
		for (int j = 0; j < len-1; j++)
		{
			if (array[j] % 2 == 0 && array[j + 1] % 2 != 0)
			{
				int tmp = array[j];
				array[j] = array[j + 1];
				array[j + 1] = tmp;
			}
		}
	}
}

    */

import java.util.Arrays;

import static java.lang.System.out;

public class 十二调整数组顺序使奇数位于偶数前面 {
    public static void reOrderArray(int[] array) {
        for (int i = 0; i < array.length; i++) {//外循环记得是次数，内循环做的是交替
            for (int j = 0; j < array.length-1; j++) {//注意数组越界，因为要交换，所以最多只能到倒数第二位
                if (array[j] % 2 == 0 && array[j + 1] % 2 != 0) {
                    int temp=array[j];
                    array[j]=array[j+1];
                    array[j+1]=temp;
                }
            }
        }

    }

    public static void main(String[] args) {
        int[] array = new int[6];
        array[0] = 2;
        array[1] = 4;
        array[2] = 6;
        array[3] = 1;
        array[4] = 3;
        array[5] = 5;
        out.println(Arrays.toString(array));
        reOrderArray(array);
        out.println(Arrays.toString(array));
    }
}
