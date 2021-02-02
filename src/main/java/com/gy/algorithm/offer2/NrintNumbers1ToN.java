package com.gy.algorithm.offer2;

/**
 * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
 * <p>
 * 示例 1:
 * 输入: n = 1
 * 输出: [1,2,3,4,5,6,7,8,9]
 * <p>
 * 链接：https://leetcode-cn.com/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof
 *
 * @author : leelipeng
 * @date : 2021-02-02 08:44
 */
public class NrintNumbers1ToN {

    public static void main(String[] args) {
        show(printNumbers1(1));
        show(printNumbers1(2));
        show(printNumbers1(3));
        show(printNumbers1(4));
    }

    /**
     * 根据题意, 当输入n时, 打印从1到 (n位)的所有数.
     * <p>比如1: 打印1-9</p>
     * <p>比如2: 打印1-99</p>
     * <p>比如3: 打印1-999</p>
     * <p>比如4: 打印1-9999</p>
     * <p>
     * 所以需要解决:
     * 1. 终止条件问题: 可以根据情况判断出结束条件是: 10 ^ n -1.
     * 2. 数据越界问题
     *
     * @param n
     * @return
     */
    public static int[] printNumbers1(int n) {
        int end = (int) (Math.pow(10, n)) - 1;
        int[] array = new int[end];
        for (int i = 0; i < end; i++) {
            array[i] = i + 1;
        }
        return array;
    }


    /**
     * 第2种实现方法.
     * TODO 参考LeetCode实现.
     *
     * https://leetcode-cn.com/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof/solution/mian-shi-ti-17-da-yin-cong-1-dao-zui-da-de-n-wei-2/
     *
     */
    StringBuilder res;
    int count = 0, n;
    char[] num, loop = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    public String printNumbers2(int n) {
        this.n = n;
        res = new StringBuilder(); // 数字字符串集
        num = new char[n]; // 定义长度为 n 的字符列表
        dfs(0); // 开启全排列递归
        res.deleteCharAt(res.length() - 1); // 删除最后多余的逗号
        return res.toString(); // 转化为字符串并返回
    }

    void dfs(int x) {
        if(x == n) { // 终止条件：已固定完所有位
            res.append(String.valueOf(num) + ","); // 拼接 num 并添加至 res 尾部，使用逗号隔开
            return;
        }
        for(char i : loop) { // 遍历 ‘0‘ - ’9‘
            num[x] = i; // 固定第 x 位为 i
            dfs(x + 1); // 开启固定第 x + 1 位
        }
    }


    public static void show(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            System.out.print(",");
        }
        System.out.print("");
    }
}
