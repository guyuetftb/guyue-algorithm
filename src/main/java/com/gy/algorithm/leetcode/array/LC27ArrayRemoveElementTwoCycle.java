package com.gy.algorithm.leetcode.array;

import java.util.Arrays;

/**
 * Friendship is a sheltering tree.
 *
 * @author : leelipeng
 * @date : 2020-11-16 20:18
 */
public class LC27ArrayRemoveElementTwoCycle {


    /**
     * <p>
     * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。<br/>
     * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。<br/>
     * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。<br/>
     * <p>
     * <br/><p> 示例 1:
     * 给定 nums = [3,2,2,3], val = 3,
     * 函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。
     * <p>
     * 你不需要考虑数组中超出新长度后面的元素。
     * <p>
     * <br/><p>
     * 示例 2:
     * 给定 nums = [0,1,2,2,3,0,4,2], val = 2,
     * 函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。
     * 注意这五个元素可为任意顺序。
     * 你不需要考虑数组中超出新长度后面的元素。
     * <p>
     * 链接：https://leetcode-cn.com/problems/remove-element
     *
     * @param args
     */
    public static void main(String[] args) {

        int[] nums = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
        int removeValue = 2;
        int newLength = removeElementTwoCycle(nums, removeValue);
        System.out.println("new-length=" + newLength);
        Arrays.stream(nums).forEach(System.out::print);
    }

    public static int removeElementTwoCycle(int[] arr, int removeValue) {
        int newSize = 0;
        for (int outIndex = 0; outIndex < arr.length; outIndex++) {
            if (removeValue == arr[outIndex]) { // 找到『被移除』的元素
                // 将『当前元素』 至 『数组结尾』的所有元素 『前移1位』.
                for (int inIndex = outIndex; inIndex < arr.length - 1; inIndex++) {
                    arr[inIndex] = arr[inIndex + 1];
                }
                outIndex--; // 因为 outIndex 所有元素都向前移动了一位, 所有 outIndex 的索引也向前移一位.
            }
            newSize++;
        }
        return newSize;
    }
}
