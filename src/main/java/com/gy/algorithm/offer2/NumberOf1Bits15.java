package com.gy.algorithm.offer2;

/**
 * 编写一个函数，输入是一个无符号整数（以二进制串的形式），返回其二进制表达式中数字位数为 '1' 的个数（也被称为汉明重量）。
 * <p>
 * 提示：
 * 请注意，在某些语言（如 Java）中，没有无符号整数类型。在这种情况下，输入和输出都将被指定为有符号整数类型，并且不应影响您的实现，因为无论整数是有符号的还是无符号的，其内部的二进制表示形式都是相同的。
 * 在 Java 中，编译器使用二进制补码记法来表示有符号整数。因此，在上面的 示例 3 中，输入表示有符号整数 -3。
 * <p>
 * 进阶：
 * 如果多次调用这个函数，你将如何优化你的算法？
 * <p>
 * 示例 1：
 * 输入：00000000000000000000000000001011
 * 输出：3
 * 解释：输入的二进制串 00000000000000000000000000001011 中，共有三位为 '1'。
 * 示例 2：
 * <p>
 * 输入：00000000000000000000000010000000
 * 输出：1
 * 解释：输入的二进制串 00000000000000000000000010000000 中，共有一位为 '1'。
 * 示例 3：
 * <p>
 * 输入：11111111111111111111111111111101
 * 输出：31
 * 解释：输入的二进制串 11111111111111111111111111111101 中，共有 31 位为 '1'。
 * <p>
 * <p>
 * 链接：https://leetcode-cn.com/problems/number-of-1-bits
 *
 * @author : leelipeng
 * @date : 2021-02-02 07:41
 */
public class NumberOf1Bits15 {

    public static void main(String[] args) {

        System.out.println(hammingWeight1(5));
        System.out.println(hammingWeight2(5));
    }

    /**
     * 通过 掩码 + & 的方式确定1的个数.
     * 掩码是1，&运算符与任何数 进行逻辑&操作，都能得到该位的第1位是 1或0.
     * 然后依次向左移动1位掩码，直到所有位都已经计算完成。
     *
     * @param n
     * @return
     */
    public static int hammingWeight1(int n) {
        int bitNum = 0;
        int mark = 1;
        for (int i = 0; i < 32; i++) {
            // TODO 条件判断时 必须使用 != 运算符.
            if((mark & n) != 0){
                bitNum++;
            }
            mark <<= 1;
        }
        return bitNum;
    }

    /**
     * 我们可以把前面的算法进行优化。
     * 我们不再检查数字的每一个位，而是不断把数字最后一个 1 反转，并把答案加一。
     * 当数字变成 00 的时候偶，我们就知道它没有 1 的位了，此时返回答案。
     *
     * 这里关键的想法是对于任意数字 n，将 n 和 n - 1 做与运算，会把最后一个 1 的位变成 0。为什么？
     * 考虑 n 和 n - 1 的二进制表示：
     * <p> 5的二进制数是: 0101, 4的二进制数是: 0100, 2数与运算: 得 0100
     * <p> 4的二进制数是: 0100, 3的二进制数是: 0011, 2数与运算: 得 0000
     * <p> 3的二进制数是: 0011, 2的二进制数是: 0010, 2数与运算: 得 0010
     * <p> 2的二进制数是: 0010, 1的二进制数是: 0001, 2数与运算: 得 0000
     * <p>
     * <p> 图片地址： https://pic.leetcode-cn.com/abfd6109e7482d70d20cb8fc1d632f90eacf1b5e89dfecb2e523da1bcb562f66-image.png </p>
     *
     * 链接：https://leetcode-cn.com/problems/number-of-1-bits/solution/wei-1de-ge-shu-by-leetcode/
     * @param n
     * @return
     */
    public static int hammingWeight2(int n){
        int bitNum = 0;
        while(n != 0){
            bitNum++;
            n = n & (n - 1);
        }

        return bitNum;
    }
}
