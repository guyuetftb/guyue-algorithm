package com.gy.algorithm.offer2;

import java.util.HashMap;
import java.util.Map;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * <p>例如，给出
 *
 * <p>前序遍历 preorder = [3,9,20,15,7]
 * <p>中序遍历 inorder = [9,3,15,20,7]
 * <p>返回如下的二叉树：
 *
 * <p>    3
 * <p>   / \
 * <p>  9  20
 * <p>    /  \
 * <p>   15   7
 *
 * <p> 限制：
 * <p> 0 <= 节点个数 <= 5000
 * <p>
 * 链接：https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof
 *
 * @author : leelipeng
 * @date : 2021-01-23 16:56
 */
public class BuildTree07 {
    static Map<Integer, Integer> inOrderMap = new HashMap<Integer, Integer>();
    static int[] preOrder = new int[]{3, 9, 20, 15, 7};
    static int[] inOrder = new int[]{9, 3, 15, 20, 7};

    public static void main(String[] args) {

        for (int i = 0; i < inOrder.length; i++) {
            inOrderMap.put(inOrder[i], i);
        }

        TreeNode treeNode = buildTree(preOrder, inOrder);
        System.out.println(treeNode);
    }

    /**
     * 思考:
     * <p>
     * <p>问题1: 前序, 中序, 后序遍历的中心或者主角是: 中心节点.
     * <p>问题2: 前序的顺序是: 根节点, 左子树, 右子树
     * <p>问题3: 中序的顺序是: 左子树, 根节点, 右子树
     * <p>问题4: 所以前序的第1个节点,必然是tree的root节点
     * <p> [3,9,20,15,7], 即3可以确定是tree的root节点.
     * <p> [9,3,15,20,7], 由中序顺序可知, 9是3的左子树.
     * <p> 同理, 20,15,7 是3的右子树. 即20是右子树的根节点. </p>
     * <p> 又由中序 15,20,7 得, 15是20的左子树, 7是20的右子树. </p>
     * <p>
     * <p>
     * 解题过程
     * <p>前序: {1,2,4,7,3,5,6,8}, 中序: {4,7,2,1,5,3,8,6}</p>
     * <p>1: 由前序得: 1为tree的 root</p>
     * <p>2: 由中序得: 4,7,2为左子树, 5,3,8,6为右子树 </p>
     * <p>3: 在左子树: 4,7,2中, 再由前序得: 2是 root, 再由中序得: 4,7为左子树, 无右子树</p>
     * <p>4: 在右子树: 5,3,8,6中, 再由前序得: 3是root, 再由中序得: 5为左子树, 8,6为右子树</p>
     * <p>5: 重复3-4步</p>
     * <p>
     * <p>
     * <p>
     * 总结:
     * <p>1. 前序能确定每层树的root节点</p>
     * <p>2. 中序能确定树的左子树, 右子树</p>
     * <p>3. 重复1，2步,就可构建一棵树.</p>
     */
    public static TreeNode buildTree(int[] preOrder, int[] inOrder) {

        // 当前tree的根节点索引
        // 当前tree的左边界
        // 当前tree的右边界
        return recursive(0, 0, inOrder.length - 1);
    }

    public static TreeNode recursive(int preRootIndex, int inLeftBorder, int inRightBorder) {
        if(inLeftBorder > inRightBorder)
            return null;

        // 获取当前tree的根节点.
        int root = preOrder[preRootIndex];
        TreeNode treeNode = new TreeNode(root);

        // 获取当前root节点在 中序树中的 索引.
        int inIndex = inOrderMap.get(root);

        // leftTree
        // leftTree.root = curRoot.index+1: 左子树root的index, 是先序tree 的root的index+1.
        // leftTree.left = inLeftBorder: 左子树 左边界(left_border)是: 原先 中序tree 的左边界
        // leftTree.right = curRoot.index-1: 左子树 右边界(right_border)是: 中序tree中 root节点索引 -1
        treeNode.left = recursive(preRootIndex + 1, inLeftBorder, inIndex - 1);

        // rightTree
        // rightTree.root = curRoot.index + leftTree.size + 1: 右子树 root 的index, 是先序树root索引+左子树元素个数+1
        // rightTree.left = inIndex + 1: 右子树 左边界(left_border)的index, 是当前节点在 中序tree 中的位置 + 1
        // rightTree.right = inRightBorder : 右子树 右边界(right_border)的index, 是原先 中序tree 的右边界.
        treeNode.right = recursive(preRootIndex + (inIndex - inLeftBorder) + 1, inIndex + 1, inRightBorder);

        return treeNode;
    }

    static public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
