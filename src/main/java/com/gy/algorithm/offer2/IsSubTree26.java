package com.gy.algorithm.offer2;

/**
 * Friendship is a sheltering tree.
 *
 * @author : leelipeng
 * @date : 2021-02-24 11:50
 */
public class IsSubTree26 {

    /**
     * 个人想法:
     * 判断B树是否是A树的子树, 逻辑上需要判断B树的每个节点都与A树的节点相同.
     * 那么需要先在 A-树中 找到与 B树的根相同的节点, 然后再遍历A, B两棵树的所有节点.
     * 步骤如下:
     * 1. 先使用DFS算法在A树中找到与 B树根节点相等的节点 C
     * 2. 判断 以C为根的子树 是否与 B树相等
     * 3. 如果 以C为根的子树 等于 B树 返回.
     * 4. 如果 以C为根的子树 不等于 B树, 就在 A树中 继续寻找与 B树根节点相同的节点 C2, 以该节C2点为根的子树 继续与 B树比较.
     * <p>
     * 终止条件:
     * 1. 如果A, 或 B为空, 返回false.
     * 2.
     *
     * @param args
     */
    public static void main(String[] args) {

    }

    static boolean result = false;

    public static boolean isSubTree(TreeNode A, TreeNode B) {
        // TODO 终止条件
        if (null == A || null == B) {
            return false;
        }

        dfs(A, B);
        return result;
    }

    /**
     * 深度优先的先序遍历, 根->左->右.
     *
     * @param a
     * @param b
     */
    public static void dfs(TreeNode a, TreeNode b) {
        if (null == a) {
            return;
        }
        // TODO 在 A 中找到了 与 B树根节点相同的节点.
        if (a.val == b.val) {
            // TODO
            if (isSubTreeHelper(a, b)) {
                result = true;
                return;
            }
        }

        // 递归A.left 左子树
        dfs(a.left, b);

        // 递归A.right 右子树
        dfs(a.right, b);
    }

    /**
     * 判断是否为子树, 需要分3步骤判断
     * 1. 2个子树的其中某1个节点不能为空
     * 2. 相关节点值必须相等.
     * 3. 左节点相等
     * 4. 右节点相等.
     * 5. 不断迭代递归
     */
    public static boolean isSubTreeHelper(TreeNode a, TreeNode b) {
        if (a == null && b != null) {
            return false;
        }
        if (a != null && b == null) {
            return false;
        }
        boolean nodeVal = a.val == b.val;
        boolean leftVal = isSubTreeHelper(a.left, b.left);
        boolean rightVal = isSubTree(a.right, b.right);
        return nodeVal && leftVal && rightVal;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


}
