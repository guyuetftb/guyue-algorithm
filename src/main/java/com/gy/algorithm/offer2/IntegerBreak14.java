package com.gy.algorithm.offer2;

/**
 * <p> 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m-1] 。
 * 请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 *
 * <p> 示例 1：
 * <p> 输入: 2
 * <p> 输出: 1
 * <p> 解释: 2 = 1 + 1, 1 × 1 = 1
 *
 *
 * <p> 示例 2:
 * <p> 输入: 10
 * <p> 输出: 36
 * <p> 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36
 * <p>
 * <p>
 * 提示：
 * 2 <= n <= 58
 * <p>
 * 链接：https://leetcode-cn.com/problems/jian-sheng-zi-lcof
 *
 * @author : leelipeng
 * @date : 2021-01-24 21:57
 */
public class IntegerBreak14 {

    /**
     * 个人: 看到本题, 感觉有点动态规则, 或者 子问题拆分的感觉.
     * 根据数学公式可知: 当每一边都相等时,算出来的面积最大.
     * https://leetcode-cn.com/problems/jian-sheng-zi-lcof/solution/mian-shi-ti-14-i-jian-sheng-zi-tan-xin-si-xiang-by/
     *
     * @param args
     */
    public static void main(String[] args) {
        int n = 3;
        System.out.println(" cuttingRope n = " + n + ", value = " + cuttingRope(n));
        System.out.println(" cuttingRopeBack n = " + n + ", value = " + cuttingRopeBack(n));
        System.out.println(" cuttingRobeDynamic n = " + n + ", value = " + cuttingRobeDynamic(n));
    }

    /**
     * TODO 递归算法
     * <p>
     * 解题:
     * <p> 1. 之前看过bobo老师的视频,对该题有一点印象, 但印象不深刻了. 但是需要切分绳子是有印象的，但是忘记怎么比较到底是该切还是不该切.
     * <p>  我们每次将一段绳子剪成两段时，剩下的部分可以继续剪，也可以不剪，由于要求乘积最大值，所以需要比较到底是剪还是不剪
     * <p> i * cuttingRope(n-i): 表示继续向下剪绳子
     * <p> i * (n-i) ;表示不在继续剪绳子 </p>
     * <p> 链接：https://leetcode-cn.com/problems/jian-sheng-zi-lcof/solution/jian-zhi-offerer-shua-java-di-gui-bei-wa-1pax/
     *
     * @param n
     * @return
     */
    public static int cuttingRope(int n) {
        // 如果绳子长度为2,则只有一种切法.
        if (n == 2) {
            return 1;
        }

        int res = 0;
        for (int i = 2; i < n; i++) {
            // TODO
            //  Max (res当前结果, Max (继续切, 不继续切))
            //  A: i * (n-1) 表示绳子只切2断,就不再切分了.
            //  B: i * F(memo,n-1) 表示绳子切掉了i后, 剩下的部分再求最大值.
            //  然后取 A, B中最大的那一个.
            res = Math.max(res, Math.max(i * cuttingRope(n - i), i * (n - i)));
        }
        return res;
    }

    /**
     * TODO 备忘录法
     * 在之前我们计算中, 我们重复计算了很多次，我们可以把这些重复计算的保存下来, 供后面使用，这就是备忘录法》
     *
     * @param n
     * @return
     */
    public static int cuttingRopeBack(int n) {
        int[] memo = new int[n + 1];
        // 设置初始值
        memo[2] = 1;
        return F(memo, n);
    }

    public static int F(int[] memo, int n) {
        // TODO 备忘录里已经记录了计算过的值.
        if (memo[n] != 0) {
            return memo[n];
        }

        int res = 0;
        for (int i = 2; i < n; i++) {
            // TODO
            //  A: i * (n-1) 表示绳子只切2断,就不再切分了.
            //  B: i * F(memo,n-1) 表示绳子切掉了i后, 剩下的部分再求最大值.
            //  然后取 A, B中最大的那一个.
            res = Math.max(res, Math.max(i * (n - i), i * F(memo, (n - 1))));
        }
        // TODO 保存计算过的值.
        memo[n] = res;
        return res;
    }

    /**
     * TODO 动态规则
     * 动态规则需要定义状态, 状态转移方程, 状态初始值,
     * 状态定义: dp[i] 是绳子长度为i时的最大值.
     * 状态初始值: dp[2] = 1;
     * 状态转移方程: dp[i] = Math(dp[i], Math(i * dp[n-i], i * (n-i)):
     * |- i * (n-i) 表示绳子不切的结果
     * |- i * dp[n-i] 表示 i 与 继续切绳子的计算结果.
     * 动态规划: 思路是-> 从底向上
     *
     * @param n
     * @return
     */
    public static int cuttingRobeDynamic(int n) {
        // 初始化数组长度大于绳长.
        int[] dynamicRobe = new int[n + 1];
        dynamicRobe[2] = 1;
        for (int i = 3; i < n + 1; i++) {
            // TODO 计算每个绳长的值.
            for (int j = 2; j < i; j++) {
                // TODO Max(dp当前值, Max(绳子不再切分值, 切掉j * 剩余部分最大值))
                dynamicRobe[i] = Math.max(dynamicRobe[i], Math.max(j * (i - j), j * dynamicRobe[i - j]));
            }
        }
        return dynamicRobe[n];
    }
}
