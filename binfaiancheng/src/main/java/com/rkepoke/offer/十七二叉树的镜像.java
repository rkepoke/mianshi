package com.rkepoke.offer;
/*
题目描述
        操作给定的二叉树，将其变换为源二叉树的镜像。
        二叉树的镜像定义：源二叉树
        8
        /  \
        6   10
        / \  / \
        5  7 9 11
        镜像二叉树
        8
        /  \
        10   6
        / \  / \
        11 9 7  5
自己的思路：
    每个节点的左子树变成右子树，右子树变成左子树。所以必然涉及到递归：凡树有关的题目，都涉及到递归。
别人的思路：
//采用递归的方式进行交换
public void Mirror(TreeNode root) {
        if (root == null || (root.left == null && root.right == null))
        return;

        TreeNode nodeTemp = root.left;
        root.left = root.right;
        root.right = nodeTemp;

        if (root.left != null) {
        Mirror(root.left);
        }
        if (root.right != null) {
        Mirror(root.right);
        }
        }

*/

public class 十七二叉树的镜像 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    //没想到我自己的这段代码就真的通过了
    public void Mirror(TreeNode root) {
        if(root==null){
            return;
        }//能往下执行就绝对不是空树
        TreeNode rightNode=root.right;
        TreeNode leftNode=root.left;
        root.left=reverseNode(rightNode);
        root.right=reverseNode(leftNode);
    }
    public TreeNode reverseNode(TreeNode node){
        //一开始就要判空
        if(node==null){
            return null;
        }
        TreeNode rightNode=node.right;
        TreeNode leftNode=node.left;
        if(rightNode==null&&leftNode==null){
            return node;
        }
        node.left=reverseNode(rightNode);
        node.right=reverseNode(leftNode);
        return node;
    }
}
