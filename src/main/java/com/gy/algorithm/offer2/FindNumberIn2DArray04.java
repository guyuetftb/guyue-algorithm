package com.gy.algorithm.offer2;

/**
 * <p>在一个 n * m 的二维数组中，每一行都按照 从左到右 递增的顺序排序，每一列都按照 从上到下 递增的顺序排序。
 * <p>请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * <p>现有矩阵 matrix 如下：
 *
 * <p> [
 * <p>   [1,   4,  7, 11, 15],
 * <p>   [2,   5,  8, 12, 19],
 * <p>   [3,   6,  9, 16, 22],
 * <p>   [10, 13, 14, 17, 24],
 * <p>   [18, 21, 23, 26, 30]
 * <p> ]
 *
 * <p> 给定 target = 5，返回 true。
 * <p> 给定 target = 20，返回 false。
 * <p>
 * 链接：https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof
 * @Author guyuetftb
 */
public class FindNumberIn2DArray04 {

    public static void main(String[] args) {
        int[][] data = new int[5][5];
        data[0] = new int[]{1, 4, 7, 11, 15};
        data[1] = new int[]{2, 5, 8, 12, 19};
        data[2] = new int[]{3, 6, 9, 16, 22};
        data[3] = new int[]{10, 13, 14, 17, 24};
        data[4] = new int[]{18, 21, 23, 26, 30};

        System.out.println(findNumberIn2DArray(data, 5));
        System.out.println(findNumberIn2DArray(data, 20));
    }

    /**
     * 解题思路:
     * <p>因为数据每一行 从左向右 都是递增的, 第一列 从上到下 都是递增的。</p>
     * <p>所以，可以从表格 右上角 开始查找, 即 row=0, col=data.length -1.</p>
     * <p>当遇到比Num大的数据时, 向 左 移动一列. </p>
     * <p>当遇到比Num小的数据时, 向 下 移动一行. </p>
     * <p>直到找到所需要的数据</p>
     * @param data
     * @param num
     * @return
     */
    public static boolean findNumberIn2DArray(int[][] data, int num) {
        int row = 0;
        int col = data[0].length - 1;
        while (row < data.length - 1 && col >= 0) {
            if (data[row][col] == num) {
                return true;
            } else if (data[row][col] > num) {
                // TODO 如果当前元素大于 num, 则:左移一列
                //  因为 当前元素已经大于 num, 说明当前行下所有元素都大于 num.
                col--;
            } else if (data[row][col] < num) {
                // TODO 如果当前元素小于 num, 则:下移一行
                //  因为当前元素已经小于num, 而:该行下 "所有行的元素" 都大于 "本行元素", 所以需要下移
                row++;
            }
        }
        return false;
    }
}
