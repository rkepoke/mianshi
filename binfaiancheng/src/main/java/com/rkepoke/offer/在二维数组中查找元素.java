package com.rkepoke.offer;
//题目描述：
//        在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
//        请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数
//思路：
//如果这题用直接遍历的方式，那么当数组很大的时候查询效率是很慢的
//        由于题目条件的成立，所以使得这道题可以使用对角线的方法完成，可以从右上角的元素考虑，
//        如果目标查找元素小于右上角的元素，那么不可能在右上角元素所在的列，如果目标大于剩余列的右上角的元素，
//        那么不可能在该右上角元素所在的行。依照这个规律，就可以完成目标元素的查找（参考剑指offer书中的思路）。
//        基于此，我写出如下的代码（已被牛客OJ平台AC）：

//思路的意思：即从右上角开始，依照三种情况收缩即可逐步确定范围
//
public class 在二维数组中查找元素 {//最后要重看一边剑指offer的解题思路，书上的解题思路应该是没得说的

    public boolean find(int[][] array, int target) {
        boolean flag = false;
        int rows = array.length;
        int cols = array[0].length;
        int row = 0;
        int col = cols - 1;
        while (row < rows && col >= 0) {//x循环的书写，这里写的是循环的结束条件，数组的结束条件就是到边界了。
            if (array[row][col] == target) {
                flag = true;
                break;
            } else if (array[row][col] > target) {
                col--;
            } else {
                row++;
            }

        }
        return flag;
    }
}
