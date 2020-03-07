package com.rkepoke.offer;

//题目描述：
//        请实现一个函数，将一个字符串中的空格替换成”%20”。例如，当字符串为We Are Happy，则经过替换之后的字符串为We%20Are%20Happy。
//思路：解字符串的题，考虑转为数组去解。从头到尾一次去判断为' '就替换，否则就直接复制
//stringbuffer==string==array,三者之间的转化，必须相当清楚啊  如下：
//String s = str.toString();
//        s.toCharArray()
//        new String(tempArray)
public class 字符串空格替换 {//写算法，也能检验你底层的基本功怎么样，

    public String replaceSpace(StringBuffer str) {
        String s = str.toString();
        char[] chars = s.toCharArray();
        int count = getSpaceNumber(s);
        char[] newChars = new char[2 * count + s.length()];
        for(int i=0,j=0;i<chars.length;i++){
            if(chars[i]==' '){
                newChars[j++]='%';
                newChars[j++]='2';
                newChars[j++]='0';
            }else{
                newChars[j++]=chars[i];
            }
        }
        return new String(newChars);
    }

    private int getSpaceNumber(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                count++;
            }
        }
        return count;
    }
}
