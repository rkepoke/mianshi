package com.rkepoke.offer;
//做树  的算法 的第一题
//题目描述
//        输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
//        例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回
//public class TreeNode {
//     int val;
//     TreeNode left;
//     TreeNode right;
//     TreeNode(int x) { val = x; }
// }
//思路：  基本功扎实：就是我给你序列，先不说代码实现，你要能画出来。实现看一看就会了，因为你画出来了，按照画的思路去写代码即可
//    因为树的定义就是递归去定义的，所以在重建时也用递归。          树和递归是绑在一起的。
//==============================
/*别人的代码：
public class Solution {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if(pre == null || in == null || pre.length != in.length){
            return null;
        }
        return ConstructBinaryTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }

    public TreeNode ConstructBinaryTree(int [] pre, int ps, int pe,int [] in, int is, int ie){
        if(ps > pe || is > ie){	 //递归调用的出口
            return null;
        }
        TreeNode root = new TreeNode(pre[ps]);
        for(int i = is; i<=ie; i++){
            if(in[i] == pre[ps]){
                root.left = ConstructBinaryTree(pre, ps+1, ps+i-is, in, is, i-1); //左子树  这块是本题的难点，尤其是前序遍历的起始位置
                root.right = ConstructBinaryTree(pre, ps+i-is+1, pe, in, i+1, ie); //右子树
                break;
            }
        }
        return root;
    }
}

    递归左子树中的 ps+i-is。
        （i-is),是通过中序遍历找到左子树的偏移量（因为中序遍历中，在当前节点的左边的，那就是当前节点的左子树），再加上ps,即找到在前序遍历的左子树的最后一个节点。
        上面理解了，那么理解 ps+ i - is+ 1。就简单多了。
        在前序遍历中，当前节点左子树的最后一个节点的下一个节点肯定是右子树的起始节点。*/


public class 重建二叉树 {//================牛客上AC成功
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        return constructCore(pre,0,pre.length-1,in,0,in.length-1);
    }
    //1:书写代码的时候，按照一个数组即一个区间的理念去写
    //2:一边判断下标，一边判断值。下标确定长度，值确定位置
    //3：变量的命名要规范，见名知意，否则很难读懂啊
    //4：传值传的是每一次的 递归处理数据的区间:4.2：考虑树，就是考虑，根，左右子树。注意切分
    private TreeNode constructCore(int[] pre, int startPre, int endPre, int[] in, int startIn, int endIn) {
        //递归结束的条件
        if(startPre>endPre||startIn>endIn){//只有左大于右了，才表示没有节点了，那么等于都表示还有节点
            return null;
        }
        //构建根节点
        TreeNode root = new TreeNode(pre[startPre]);
        //再去中序数组中定位，分左右，递归重构
        for(int i=startIn;i<=endIn;i++){//遍历肯定是整个区间，从头到尾的遍历，每一个位子都有可能是根节点
            if(in[i]==pre[startPre]){//i-startIn是左子树的长度，这个长度是根据中序数组算出的，充当新子树的右边界
                root.left=constructCore(pre,startPre+1,startPre+i-startIn,in,startIn,i-1);
                root.right=constructCore(pre,startPre+i-startIn+1,endPre,in,i+1,endIn);
            }
        }
        return root;

    }
    public static void main(String[] args) {
        int[] pre = {1,2,4,7,3,5,6,8};
        int[] in = {4,7,2,1,5,3,8,6};
        TreeNode root = new 重建二叉树().reConstructBinaryTree(pre, in);
        System.out.println(root);
    }

}
