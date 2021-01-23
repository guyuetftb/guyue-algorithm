package com.gy.algorithm.offer2;

/**
 * <p> 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 * <p> 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 * <p> 示例 1：
 * <p> 输入：n = 2
 * <p> 输出：2
 *
 * <p> 示例 2：
 * <p> 输入：n = 7
 * <p> 输出：21
 *
 * <p> 示例 3：
 *
 * <p> 输入：n = 0
 * <p> 输出：1
 *
 * <p> 提示：
 * <p> 0 <= n <= 100
 * <p>
 * 链接：https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof
 *
 * @author : leelipeng
 * @date : 2021-01-23 21:37
 */
public class ClimbingStairs10_2 {

    /**
     * 该题的解法与 Fib10 题(斐波那契)一样
     * TODO 注意 爬台阶与斐波那契数 在初始值上不同
     * n = 0, rst = 0;
     * n = 1, rst = 1;
     * n = 2, rst = 2: 方式1 (一次跨2个) 或 方式2 (一次跨1个)
     * n = 3, rst = 如果在第2阶上, 有多少种爬法, 如果在第1阶上有多少种爬法, 然后把 两者相加即可.
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(climbingStairs(7));
    }

    public static int climbingStairs(int n) {
        if (n == 0) {
            return 1;
        }

        if (n == 1) {
            return 1;
        }
        // TODO 注意, 这里与 斐波那契 树不同.
        //  只有1个台阶时, 有1种爬法
        //  只有2个台阶时, 有2种爬法
        int stepN_2 = 1;
        int stepN_1 = 2;
        int stepN = 0;
        for (int i = 3; i <= n; i++) {
            stepN = stepN_1 + stepN_2;
            stepN = stepN % 1000000007;
            stepN_2 = stepN_1;
            stepN_1 = stepN;
        }
        System.out.println("stepN = " + stepN);
        return stepN;
    }
}
