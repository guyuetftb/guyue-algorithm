package com.gy.algorithm.offer2;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 * 示例 1：
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * <p>
 * 示例 2：
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 *
 * @author : leelipeng
 * @date : 2021-03-18 12:45
 */
public class MatrixSpiralOrder29 {

    /**
     * 个人思路:
     * 刚拿到题时, 感觉没有什么思路, 但仔细想想, 有点模糊的想法, 但又不敢肯定自己想的是对的, 以为有数学公式的高极解法.
     * 比较笨的解法是: 按层读取matrix中的数据, 一层一层的往里读, 直到读到最核心位置.
     * 这就需要定义4个边界: left, right, top, bottom.
     * 程序退出条件是: 每个边界不能超过指定的值.
     * <p>
     * 参考解决思路:
     * 1. 空值处理： 当 matrix 为空时，直接返回空列表 [] 即可。
     * 2. 初始化： 矩阵 左、右、上、下 四个边界 l , r , t , b ，用于打印的结果列表 res 。
     * 3. 循环打印： “从左向右、从上向下、从右向左、从下向上” 四个方向循环，每个方向打印中做以下三件事 （各方向的具体信息见下表） ；
     * --3-1. 根据边界打印，即将元素按顺序添加至列表 res 尾部；
     * --3-2. 边界向内收缩 11 （代表已被打印）；
     * --3-3. 判断是否打印完毕（边界是否相遇），若打印完毕则跳出。
     * 4. 返回值： 返回 res 即可。
     * <p>
     * <p>
     * 链接：https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof/solution/mian-shi-ti-29-shun-shi-zhen-da-yin-ju-zhen-she-di/
     *
     * @param args
     */
    public static void main(String[] args) {
        int[][] matrixArr = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16},
        };

        int[] res = spiralOrder(matrixArr);
        for (int re : res) {
            System.out.println(re);
        }
    }

    public static int[] spiralOrder(int[][] matrix) {
        // 定义数组的4个连累
        int left = 0;
        int right = matrix[0].length - 1;
        int top = 0;
        int bottom = matrix.length - 1;

        // 定义返回结果
        // 数组的初始化是根据容量来算的, bottom, right都是下标.
        int[] res = new int[(bottom + 1) * (right + 1)];

        //
        int index = 0;
        while (true) {
            // 从left到right, 不能超过right.
            for (int i = left; i <= right; i++) {
                res[index++] = matrix[top][i];
            }
            if (++top > bottom) {
                /** 顶部输出完了, top代表顶层值, 需要+1*/
                break; // 指针向下走, 向下走, 不能超过bottom
            }
            // 从top 到 bottom, 不能超过bottom
            for (int i = top; i <= bottom; i++) {
                res[index++] = matrix[i][right];
            }
            if (left > --right) {
                /** 右侧输出完了, right代表右侧值, 需要 -1 */
                break; // 指针向左走, 向左走, 不能超过left.
            }

            // 从右到左, 不能超过left
            for (int i = right; i >= left; i--) {
                res[index++] = matrix[bottom][i];
            }
            if (top > --bottom) {
                /** 底部输出完了, bottom代表底部值, 需要 -1 */
                break; // 指针向上走, 向上走, 不能超过top.
            }

            // 从下到上, 不能超过top
            for (int i = bottom; i >= top; i--) {
                res[index++] = matrix[i][left]; // 指针向上走, 向上走, 不能超过top
            }
            if (++left > right) {
                break;
            }
        }
        return res;
    }
}
