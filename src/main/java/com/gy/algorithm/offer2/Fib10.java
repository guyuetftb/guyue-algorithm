package com.gy.algorithm.offer2;

/**
 * Friendship is a sheltering tree.
 *
 * @author : leelipeng
 * @date : 2021-01-23 20:40
 */
public class Fib10 {

    private static int fibN_2 = 0;
    private static int fibN_1 = 1;
    private static int mod = 1000000007;

    public static void main(String[] args) {
        fibDynamic(7);
    }

    /**
     * 本题是采用动态规则完成的. 而且也未定义额外的存储空间.
     * @param n
     * @return
     */
    public static int fibDynamic(int n) {
        int tmpFibN_2 = fibN_2;
        int tmpFibN_1 = fibN_1;
        int tmpFibN = 0;
        for (int i = 2; i <= n; i++) {
            tmpFibN = tmpFibN_1 + tmpFibN_2;
            tmpFibN = tmpFibN % mod;
            tmpFibN_2 = tmpFibN_1;
            tmpFibN_1 = tmpFibN;
        }
        System.out.println("tmpFibN = " + tmpFibN);
        return tmpFibN;
    }
}
