package com.rkepoke.offer;
/*题目描述
        把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
        输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
        例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
        NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
  思路：
    方法（3）：利用二分查找。如果中间元素值>最后一个元素值，说明最小值右半区间，如果中间元素<最后一个元素区间，
    说明最小值在左半区间，如果相等说明有相同元素，
    需要将判断区间往前缩一下，继续判断，不断循环，当二分查找的的左右区间相等了，就说明找到最小值了
 */
/*int minNumberInRotateArray(vector<int> rotateArray)
        {
        int length = rotateArray.size();
        if (length == 0)
        return 0;
        int pre = 0;//第一个元素下标
        int last = length - 1;//最后一个元素下标
        while (pre < last)
        {
        int mid = (pre + last) / 2;

        //当中间元素 大于 最后一个元素，说明最小值在右半区间
        //更新pre下标
        if (rotateArray[mid] > rotateArray[last])
        {
        pre = mid + 1;
        }
        //当中间元素 小于 最后一个元素，说明最小值在左半区间
        //但是中间这个元素，可能就是最小值，因此是 last=mide,而不是
        //last=mid-1
        else if (rotateArray[mid] < rotateArray[last]) {
        last = mid;
        }
        //当中间元素 等于 最后一个元素，说明有重复元素，将区间缩小一个
        else {
        last = last - 1;  这里作者缩小的速度太慢了，感觉完全可以last = mid;这样，直接缩小，
        }
        }
        return rotateArray[pre];
        }*/

public class 旋转数组的最小值 {
    //方法1：直接遍历，但不是问题初衷，
    //方法2：利用中分法，缩小查询范围，才是题目初衷
    public int minNumberInRotateArray(int[] array) {
        int left = 0;
        int right = array.length - 1;
        while (left < right) {//循环结束的条件是左右下标相逢，那个值就是最小值
            int mid = (left + right) / 2;
            if (array[mid] > array[right]) {
                left = mid + 1;
            } else if (array[mid] <= array[right]) {//   其实小于等于情况可以算在一起考虑
                right = mid;
            }
        }
        return array[left];
    }
}
