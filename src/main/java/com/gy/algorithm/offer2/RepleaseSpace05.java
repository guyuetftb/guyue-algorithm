package com.gy.algorithm.offer2;

/**
 * @ClassName RepleaseSpace5
 * @Description TOOD
 * @Author guyuetftb
 * @date : 2021-01-18 19:20
 */
public class RepleaseSpace05 {


    /**
     * 拿到题的想法:
     * 想法1: 由于Java中的数组是不可变的, 要替换旧字符串的 空格, 需要创建一个新的字符串数组。
     * 想法2:
     *
     * @param args
     */
    public static void main(String[] args) {
        char[] srcdata = "we are happy.".toCharArray();
        char[] data = new char[20];
        for (int i = 0; i < srcdata.length; i++) {
            data[i] = srcdata[i];
        }
        System.out.println(srcdata);

        replaceSpace1(data, srcdata.length);
        System.out.print(data);
    }

    /**
     * Question: 有同学问了，为什么要从后向前填充，从前向后填充不行么？
     * A: 从前向后填充就是O(n^2)的算法了，因为每次把 '空格' 变为 '%20' 都要将添加元素之后的所有元素向后移动，这无形就中多了许多操作
     * 实时复杂度就上去了。
     * 其实很多数组填充类的问题，都可以先预先给数组扩容带填充后的大小，然后在从后向前进行操作。
     * <p>
     * 作者：carlsun-2
     * 链接：https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/solution/cshuang-100dong-hua-zhan-shi-xiang-xi-zhu-shi-by-c/
     *
     * @param newData
     * @param srcDataLength
     */
    public static void replaceSpace1(char[] newData, int srcDataLength) {

        /**
         * 参考Link: https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/solution/cshuang-100dong-hua-zhan-shi-xiang-xi-zhu-shi-by-c/
         *
         * 1. 先循环一次,找出所有空格个数.
         * 2. 替换后的长度=原长度 + 空格个数 * 2
         */
        int newDataLength = srcDataLength;
        for (int i = 0; i < srcDataLength; i++) {
            if (newData[i] == ' ') {
                newDataLength += 2;
            }
        }

        for (
            // 数组位置 = 数组长度减1
                int indexOld = srcDataLength - 1, indexNew = newDataLength - 1;
            // indexOfOld, indexOfNew 不能小于0, 并且两者不能相等.
                indexOld >= 0 && indexNew >= 0 && indexOld != indexNew;
            // 两个指针不断的前移.
                indexNew--, indexOld--
        ) {
            /**
             * 以旧数组指针为轴, 向前遍历, 处理空格字符串.
             */
            if (newData[indexOld] == ' ') {
                // indexOfNew--
                // 先赋值操作
                // 再对indexOfNew减1.
                newData[indexNew--] = '0';
                newData[indexNew--] = '2';
                newData[indexNew] = '%';
            } else {
                newData[indexNew] = newData[indexOld];
            }
        }
    }


}

