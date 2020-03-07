package com.rkepoke.offer;
/*题目描述
        输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
思路：
        这实际上          二叉树遍历算法的一种应用
        ，要在原二叉树中查找是否具有某课子树，只需要判断每个节点是否都在二叉树中是否出现即可
        。所以需要先判断头结点，只有头结点符合要求才继续比较其子树是否符合，一样依次从头结点开始比较直到其左右子树进行比较，
        如果都符合则说明B是A的子结构。下面是基于这种思路实现的代码


        子树概念：设T是有根树，a是T中的一个顶点，由a以及a的所有后裔（后代）导出的子图称为有向树T的子树。
        用递归来实现，从A树的根节点开始，判断其所有的节点是不是依次和B树相同,不行再比较左右子树

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val) {
        this.val = val;
    }
}
//输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
public class Test2 {
    public static boolean HasSubtree(TreeNode root1, TreeNode root2) {
        boolean result = false;
        //当Tree1和Tree2都不为零的时候，才进行比较。否则直接返回false
        if (root2 != null && root1 != null) {
            //如果找到了对应Tree2的根节点的点
            if (root1.val == root2.val) {
                //以这个根节点为为起点判断是否包含Tree2
                result = doesTree1HaveTree2(root1, root2);
            }
            //如果找不到，那么就再去root的左儿子当作起点，去判断时候包含Tree2
            if (!result) {
                result = HasSubtree(root1.left, root2);
            }

            //如果还找不到，那么就再去root的右儿子当作起点，去判断时候包含Tree2
            if (!result) {
                result = HasSubtree(root1.right, root2);
            }
        }
        //返回结果
        return result;
    }

    public static boolean doesTree1HaveTree2(TreeNode node1, TreeNode node2) {
        //如果Tree2已经遍历完了都能对应的上，返回true
        if (node2 == null) {
            return true;
        }
        //如果Tree2还没有遍历完，Tree1却遍历完了。返回false
        if (node1 == null) {
            return false;
        }
        //如果其中有一个点没有对应上，返回false
        if (node1.val != node2.val) {
            return false;
        }

        //如果根节点对应的上，那么就分别去子节点里面匹配
        return doesTree1HaveTree2(node1.left, node2.left) && doesTree1HaveTree2(node1.right, node2.right);
    }
}
*/


public class 十六树的子结构 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        boolean result = false;
        if (root1 == null || root2 == null) {
            return false;
        }
        result = doesTree1HaveTree2(root1, root2);
        if (!result) {
            result = doesTree1HaveTree2(root1.left, root2);
        }
        if (!result) {
            result = doesTree1HaveTree2(root1.right, root2);
        }
        return result;
    }

    public static boolean doesTree1HaveTree2(TreeNode node1, TreeNode node2) {//这个函数判断的是
        //每次传来的节点值是否相等，或节点比较是否已经结束。
        if (node2 == null) {
            return true;
        }
        if (node1 == null) {
            return false;
        }
        //如果其中有点没对上，则返回false;
        if (node1.val != node2.val) {
            return false;
        }
        return doesTree1HaveTree2(node1.left, node2.left) && doesTree1HaveTree2(node1.right, node2.right);

    }

}
