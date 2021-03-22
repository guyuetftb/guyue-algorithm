package com.gy.algorithm.offer2;

import java.util.Objects;
import java.util.Stack;

/**
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 * <p>
 * 例如输入：
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * <p>
 * 镜像输出：
 * <p>
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 * <p>
 * 示例 1：
 * <p>
 * 输入：root = [4,2,7,1,3,6,9]
 * 输出：[4,7,2,9,6,3,1]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-cha-shu-de-jing-xiang-lcof
 *
 * @author : leelipeng
 * @date : 2021-03-01 11:30
 */
public class MirrorTree27 {

    /**
     * 个人思想:
     * 刚拿到本题没钥匙思路, 但有一些初步想法: (经过验证, 基本正确, 少了交换节点的步骤.）
     * 1. 感觉需要用到 层序遍历(WFS广度优先算法), 借助栈来实现.
     * 2. 先把root节点入栈
     * 3. 进入迭代while, 栈不为空
     * 4. 弹出root
     * 5. 判断root的left是否为Null, 不为null, 把root的 left 入栈.
     * 6. 判断root的right是否为Null, 不为null, 把root的 right 入栈.
     * 7. 输出弹出的节点.
     * 8. 重复 4-7 步。
     *
     * @param args
     */
    public static void main(String[] args) {
        TreeNode root = initTree();
        mirrorTree(root);
        System.out.println("完成, 断点处!.");
    }

    private static void mirrorTree(TreeNode root) {
        if (null == root) {
            return;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode curNode = stack.pop();
            System.out.println(curNode.val);

            if (Objects.nonNull(curNode.left)) {
                stack.push(curNode.left);
            }

            if (Objects.nonNull(curNode.right)) {
                stack.push(curNode.right);
            }
            // TODO 我只是想到这里, 只是把 镜像输出来了, 没有把树中的节点交换
            TreeNode tmp = curNode.left;
            curNode.left = curNode.right;
            curNode.right = tmp;
        }
    }

    private static TreeNode initTree() {
        TreeNode root4 = new TreeNode(4);
        TreeNode node2 = new TreeNode(2);
        TreeNode node7 = new TreeNode(7);
        root4.left = node2;
        root4.right = node7;

        TreeNode node1 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);
        node2.left = node1;
        node2.right = node3;


        TreeNode node6 = new TreeNode(6);
        TreeNode node9 = new TreeNode(9);
        node7.left = node6;
        node7.right = node9;
        return root4;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
