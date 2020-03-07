package com.rkepoke.leetcode字符串问题;
/*
14. 最长公共前缀
        编写一个函数来查找字符串数组中的最长公共前缀。
        如果不存在公共前缀，返回空字符串 ""。
        示例 1:
        输入: ["flower","flow","flight"]
        输出: "fl"
        示例 2:
        输入: ["dog","racecar","car"]
        输出: ""
        解释: 输入不存在公共前缀。
        说明:
        所有输入只包含小写字母 a-z 。
解答一：两层for循环
        误区1：刚开始考虑了先数组元素遍历，然后再元素（字符串）从头到尾比较，但实际上要先以第一个元素strs[0]为基准。
        漏洞1：没有考虑strs元素为空字符串的情况，如[""]，未考虑连续元素都相等的情况如["c","c"]，结果这些在提交时都是要判断的。
        个人思路：
        1、若传入为空数组[]或空字符串[""]则直接返回空字符串；
        2、取传入数组的第一个元素为基准字符串，并声明common数组，用于存放公共前缀；
        3、第一层i循环（可以想像指针指向strs[0]，且从strs[0][0]往str[0][1、2、3…]移动），第二层j循环（可以想像指针指向strs[1]，且从strs[1]往str[2、3…]移动），即题中"flower"中的"f"，与"flow"中的"f"相比较；
        4、相同则j自增，即"flower"中的"f"继续与"flight"中的"f"比较；
        5、若j循环未彻底完成，即说明当前的str[i]已经不是公共前缀了，就可以返回common了；若此次j循环彻底完成，则将当前的str[i]，push进common；
        6、外层的i循环结束后，若未触发过j循环内的return的话，类似["a","a","a"]["ab","abc","abcd"]等等情况的，直接返回strs[0]，即str即可。
        var longestCommonPrefix = function(strs) {
        if (strs.length===0 ||strs[0].length===0){return "";}
        var str=strs[0],
            common=[];
        for(let i=0,len1=str.length;i<len1;i++){
            for(let j=1,len2=strs.length;j<len2;j++){
                if(str[i]!==strs[j][i]){
                    return common.join("");
                }
            }
            common.push(str[i]);
        }return str;
    };
    解答二：水平扫描法
    参考平台提供题解，提供的第一种方法是“水平扫描法”:
    仍然是先把数组中第一个元素str取出来，然后以这个元素为基准，
    使用stringObject.indexOf(searchvalue,fromindex)方法查找,
    查一下str是否在strs[i]索引为0的位置，
    如果不在索引为0的位置，使用stringObject.substring(start,stop)删减字符串长度，
    把str长度减1，再继续查，直到str长度减到0为止。
*/
public class 最长公共前缀 {
    public static String longestCommonPrefix(String[] strs) {//字符串数组本来就可以理解为二维数组
        if(strs.length==0){
            return null;
        }
        String prefix=strs[0];
        for(int i=1;i<strs.length;i++){
            while(strs[i].indexOf(prefix)!=0){
                prefix=prefix.substring(0,prefix.length()-1);
                if(prefix.length()==0){
                    return "";
                }
            }
        }
        return prefix;
    }

    public static void main(String[] args) {
        String[] strs=new String[]{"aa","a"};
        longestCommonPrefix(strs);
    }
}
