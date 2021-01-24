package com.gy.algorithm.offer2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <p> 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 *
 *
 * <p> 示例 1：
 * <p> 输入：m = 2, n = 3, k = 1
 * <p> 输出：3
 *
 *
 * <p> 示例 2：
 * <p> 输入：m = 3, n = 1, k = 0
 * <p> 输出：1
 * <p>
 * 链接：https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof
 *
 * @author : leelipeng
 * @date : 2021-01-24 14:33
 */
public class MovingCount13 {

    /**
     * 个人: 刚拿到此题, 感觉跟第12题, 矩阵搜索单词一样。
     * <p> 同时有点动态规则的思想. </p>
     * <p> 根据第12题的解题方法, 自己先实现了dfs的基本, 及initMatrix方法.</p>
     * <p> 问题: 有一个问题没有想通: 该题与字符串不同的是, 字符串可以反复访问, 而该矩阵不可以反复访问, 反复访问会有重复.</p>
     * <p>
     * 学习:
     * https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/solution/ji-qi-ren-de-yun-dong-fan-wei-by-leetcode-solution/
     * 明显: 本题是一个搜索问题, 需要 遍历矩阵. 对于这类问题 递归实现的深度优先, 或 借助队列实现的广度优先是最优解法。
     * <p>
     * 方法1: 深度优先
     * <p> 深度优先 需要面临: 子问题 和 状态 2个基本问题.
     * <p> 假如当前是 (i,j) 状态,
     * <p> 通过递归搜索 (i-1,j), (i+1,j), (i, j+1), (i, j-1) 从这几个格子出发分别有几种状态, 假设 我们获得了所有子问题的解,
     * <p> 就获得了原问题的解, 把所有子问题解融合 再+1(即: i,j单元格的解)。
     * <p> 对于矩阵的搜索, 需要一个二维数组, 记录当前的格子是否被访问过, 一旦访问过, 就要返回0, 避免重复记录.
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(movingCount(2, 3, 1));
        System.out.println(movingCount(3, 1, 0));
        System.out.println(bfs(2, 3, 1));
        System.out.println(bfs(3, 1, 0));
    }

    public static int movingCount(int row, int col, int num) {
        // 先构建一个初始矩阵
        int[][] matrix = initMatrix(row, col);
        // 从0,0开始在矩阵中搜索符合条件的格子
        return dfs(matrix, 0, 0, num);
    }

    public static int dfs(int[][] matrix, int r, int c, int num) {
        /** ---- guyue ----*/
        if (r < 0 || r >= matrix.length) {
            // 行超出矩阵搜索范围
            return 0;
        } else if (c < 0 || c >= matrix[0].length) {
            // 列超出矩阵搜索范围
            return 0;
        } else if (getNum(r) + getNum(c) > num) {
            // 矩阵的索引超过了 num 值.
            return 0;
        } else if (matrix[r][c] == 1) {
            return 0;
        }

        matrix[r][c] = 1;
        // 向下一行的搜索结果
        int downRes = dfs(matrix, r + 1, c, num);
        // 向上一行的搜索结果
        int upRes = dfs(matrix, r - 1, c, num);
        // 向右一列的搜索结果
        int rightRes = dfs(matrix, r, c + 1, num);
        // 向左一列的搜索结果
        int leftRes = dfs(matrix, r, c - 1, num);
        /** ---- guyue ----*/

        /** ---- 参考网络学习 ----*/
        // 1是 (i,j) 的访问.
        return 1 + downRes + upRes + rightRes + leftRes;
    }

    /**
     * 构造初始矩阵
     *
     * @param row
     * @param col
     * @return
     */
    public static int[][] initMatrix(int row, int col) {
        int[][] matrix = new int[row][col];
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                // 设置矩阵的初始状态, 设置为1说明已经访问过.
                matrix[r][c] = 0;
            }
        }
        return matrix;
    }

    public static int getNum(int i) {
        int sum = 0;
        while (i > 0) {
            sum = sum + i % 10;
            i = i / 10;
        }
        return sum;
    }

    /**
     * <p> 广度优先遍历 BFS
     * <p> BFS/DFS ： 两者目标都是遍历整个矩阵，不同点在于搜索顺序不同。
     * <p> 1. DFS 是朝一个方向走到底，再回退，以此类推。
     * <p> 2. BFS 则是按照“平推”的方式向前搜索。
     *
     *
     * <p> BFS 实现： 通常利用队列实现广度优先遍历。
     *
     * <p> 算法解析：
     * <p> 初始化： 将机器人初始点 (0, 0)加入队列 queue ；
     * <p> 迭代终止条件： queue 为空。代表已遍历完所有可达解。
     * <p> 迭代工作：
     * <p>  1. 单元格出队： 将队首单元格的 索引、数位和 弹出，作为当前搜索单元格。
     * <p>  2. 判断是否跳过：
     * <p>     ① 行列索引越界
     * <p>     ② 数位和超出目标值 k
     * <p>     ③ 当前元素已访问过 时，执行 continue 。
     * <p>  3. 标记当前单元格 ：将单元格索引 (i, j) 存入 Set visited 中，代表此单元格 已被访问过 。
     * <p>  4. 单元格入队： 将当前元素的 下方、右方 单元格的 索引、数位和 加入 queue 。
     * <p> 返回值： Set visited 的长度 len(visited) ，即可达解的数量。
     * <p>
     * 链接：https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/solution/mian-shi-ti-13-ji-qi-ren-de-yun-dong-fan-wei-dfs-b/
     *
     * @return
     */
    public static int bfs(int row, int col, int num) {
        boolean[][] visited = new boolean[row][col];
        Queue<int[]> queue = new LinkedList<int[]>();
        int res = 0;
        // int[]{r=行,c=列}
        queue.add(new int[]{0, 0});
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int r = cell[0];
            int c = cell[1];
            int cellNum = getNum(r) + getNum(c);
            if (r >= visited.length) {
                continue;
            } else if (c >= visited[0].length) {
                continue;
            } else if (cellNum > num) {
                continue;
            } else if (visited[r][c]) {
                continue;
            }
            visited[r][c] = true;
            res++;
            // 参考:
            // https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/solution/jian-zhi-offerer-shua-javadfs-bfs-tu-jie-py05/
            // TODO 向右边移动
            // 向下一行,当前 col
            queue.add(new int[]{r + 1, c});
            // TODO 向下移动 (如果只是向右移动, 到了矩阵最右边怎么办?)
            // 向右一列,当前 row
            queue.add(new int[]{r, c + 1});
        }
        return res;
    }


}
