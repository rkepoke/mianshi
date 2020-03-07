package com.rkepoke.leetcode字符串问题;
/*请你来实现一个 atoi 函数，使其能将字符串转换成整数。
        首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。
        当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
        该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。
        注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。
        在任何情况下，若函数不能进行有效的转换时，请返回 0。
        说明：
        假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−231,  231 − 1]。如果数值超过这个范围，请返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。
        再结合示例，就能做了，这题最终要的就是考虑各种细节

        思路：
        result=result*10+sign*(str[i]-'0');这表示，每次我都做加一个正数，或加一个负数；是这个意思
         if(result>INT_MAX/10||(result==INT_MAX/10&&(str[i]-'0')>INT_MAX%10)) return INT_MAX;这是把超过界限的问题分成两步解决
         解题思路
1.前期判断： 优先考虑若为空字符串则返回0。然后排除前面的非空字符，若此时已无字符，返回0；若此时字符非'+''-'，也非数字，返回0。
2.核心： 拼接数字。

————————————————————————————————————————————————

2.1基本思路（正数）：

while(i<str.length()&&str[i]>='0'&&str[i]<='9'){
    result=result*10+(str[i]-'0');
    i++;
}
2.2考虑到正负数问题：

while(i<str.length()&&str[i]>='0'&&str[i]<='9'){
    result=result*10+sign*(str[i]-'0');
    i++;
}
2.3考虑到上下界问题：

while(i<str.length()&&str[i]>='0'&&str[i]<='9'){
    if(result>INT_MAX/10||(result==INT_MAX/10&&(str[i]-'0')>INT_MAX%10)) return INT_MAX;
    if(result<INT_MIN/10||(result==INT_MIN/10&&(str[i]-'0')>-(INT_MIN%10))) return INT_MIN;
    //小细节：负数%10为负数。

    result=result*10+sign*(str[i]-'0');
    i++;
}
知识点
1. 在脑海中又增加了一种新的测试用例'+-42'（同时出现两个符号）。
2. 负数取余还是负数。
3. INT_MAX,INT_MIN由标准头文件<limits.h>定义。
4. INT_MAX=2^31-1(2,147,483,647)
5. INT_MIN=-2^31(-2,147,483,648)

感悟
日常崩溃。其实这道题的思路很简单，几分钟就能想出来，但是我不断完善，不断改bug的过程却持续了1个多小时，提交报错10多次。
以我现在的水平看来：码代码很多时候大方向上不会有问题，但是在某个细微的点上，一直不断的犯错。太磨人的性子了。
加油YY。

class Solution {
public:
    int myAtoi(string str) {
        int i=0,sign=1,result=0;
        if(str==" ") return 0;
        //去除前面空格。
        for(i=0;i<str.length();++i){
            if(str[i]!=' ')
                break;
        }
        //如果第一个非空字符为：符号。
        if(str[i]=='-'){//错误点1：如果同时遇到例如(+-42)这种有两个符号的情况怎么处理。
            sign=-1;
            i++;
        }
        else if(str[i]=='+') i++;
        //如果第一个非空不为：非整数字符或仅包含空白字符。
        if(i==str.length()||str[i]<'0'||str[i]>'9')
            return 0;

        while(i<str.length()&&str[i]>='0'&&str[i]<='9'){//错误点2：错写成str[i]>'0'，脑子抽了。
            if(result>INT_MAX/10||(result==INT_MAX/10&&(str[i]-'0')>INT_MAX%10)) return INT_MAX;
            if(result<INT_MIN/10||(result==INT_MIN/10&&(str[i]-'0')>-(INT_MIN%10))) return INT_MIN;
            //错误点3：INT_MIN%10之后还为负数。
            result=result*10+sign*(str[i]-'0');//错误点4：最初没有考虑到sign问题，直接写成了result=result*10+(str[i]-'0')。
            i++;
        }
    return result;
    }
};

作者：yang-yang-yang-73
链接：https://leetcode-cn.com/problems/string-to-integer-atoi/solution/yyxue-xi-bi-ji-20-by-yang-yang-yang-73/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。


        */
public class 字符串转换整数 {
    public int myAtoi(String str) {
       if(str==null||str.trim().length()==0){
           return 0;
       }
       //首先去空格
        int i=0;//i也要用于之后的定位，所以提出来
        for(int len1=str.length();i<len1;i++){
            if(str.charAt(i)!=' '){
                break;
            }
        }
        //考虑正负号，用于之后的运算;因为之后要参与运算，所以不用true/false，而是用+1、-1
        int sign=1;
        if(str.charAt(i)=='-'){
            sign=-1;
            i++;
        } else if(str.charAt(i)=='+'){//有+1的情况
            i++;//判断完符号，就要移到下一位，用于在以后的运算
        }
//        如果第一个非空不为：非整数字符或仅包含空白字符。
        if(i==str.length()||str.charAt(i)<'0'||str.charAt(i)>'9'){
            return 0;
        }
        int result=0;
        while(i<str.length()&&str.charAt(i)>='0'&&str.charAt(i)<='9'){
            if(result>Integer.MAX_VALUE/10||(result==Integer.MAX_VALUE/10&&(str.charAt(i)-'0')>Integer.MAX_VALUE%10)){
                return Integer.MAX_VALUE;
            }
            if(result<Integer.MIN_VALUE/10||(result==Integer.MIN_VALUE/10&&(str.charAt(i)-'0')>-(Integer.MIN_VALUE%10))){//因为这是负数啊
                return Integer.MIN_VALUE;
            }
//            result=result*10+sign*(str.charAt(i));运算的时候一定要是数
            result=result*10+sign*(str.charAt(i)-'0');
            i++;
        }
        return result;

        /*while(i<str.length()&&str[i]>='0'&&str[i]<='9'){//错误点2：错写成str[i]>'0'，脑子抽了。
            if(result>INT_MAX/10||(result==INT_MAX/10&&(str[i]-'0')>INT_MAX%10)) return INT_MAX;
            if(result<INT_MIN/10||(result==INT_MIN/10&&(str[i]-'0')>-(INT_MIN%10))) return INT_MIN;
            //错误点3：INT_MIN%10之后还为负数。
            result=result*10+sign*(str[i]-'0');//错误点4：最初没有考虑到sign问题，直接写成了result=result*10+(str[i]-'0')。
            i++;
        }*/



    }
}
