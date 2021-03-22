package com.gy.algorithm.offer2;

/**
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
 * <p>
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 * <p>
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 * <p>
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 * <p>
 *  
 * <p>
 * 示例 1：
 * 输入：root = [1,2,2,3,4,4,3]
 * 输出：true
 * <p>
 * 示例 2：
 * 输入：root = [1,2,2,null,3,null,3]
 * 输出：false
 * <p>
 * 链接：https://leetcode-cn.com/problems/dui-cheng-de-er-cha-shu-lcof
 *
 * @author : leelipeng
 * @date : 2021-03-17 20:21
 */
public class TreeisSymmetric28 {

    public static void main(String[] args) {
        TreeNode root = initTree();
        System.out.println("is_symmetric=" + isSymmetric(root.left, root.right));
    }

    public static boolean isSymmetric(TreeNode left, TreeNode right) {
        return isCur(left, right);
    }

    public static boolean isCur(TreeNode left, TreeNode right) {
        // 需要先判断, 因为有可能left,right就有可能为null了。
        if (left == null && right == null) {
            // 左null, 右null
            return true;
        } else if (left == null && right != null) {
            // 左null, 右不null, false
            return false;
        } else if (left != null && right == null) {
            // 左不Null, 右null, false
            return false;
        } else if (left.val != right.val) {
            // 左 != 右, false
            return false;
        }

        /**
         * 能走到这一步, 就说明上面的情况都不满足, 且2个值相等.
         */
        boolean leftEquals = isCur(left.left, right.right);
        boolean rightEquals = isCur(left.right, right.left);
        return leftEquals && rightEquals;
    }

    private static TreeNode initTree() {
        TreeNode root4 = new TreeNode(4);
        TreeNode node2LevelL = new TreeNode(2);
        TreeNode node2LevelR = new TreeNode(2);
        root4.left = node2LevelL;
        root4.right = node2LevelR;

        TreeNode node1 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        node2LevelL.left = node1;
        node2LevelL.right = node3;


        TreeNode node6 = new TreeNode(4);
        TreeNode node9 = new TreeNode(3);
        node2LevelR.left = node6;
        node2LevelR.right = node9;
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
