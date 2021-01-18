package com.gy.algorithm.offer2;

import java.util.Arrays;
import java.util.Objects;

/**
 * Problem 3-1：找出数组中重复的数字。
 * <p>题目描述：在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。**重点**
 * <p>数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。
 * <p>请找出数组中任意一个重复的数字。
 * <p>例如，如果输入长度为7的数组{2, 3, 1, 0, 2, 5, 3}
 * <p>那么对应的输出是重复的数字2或者3。</p>
 * <p> 链接：https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof
 *
 * @author : guyuetftb
 */
public class FindRepeatNumber03 {
    public static void main(String[] args) {
        int[] num = new int[]{2, 3, 1, 0, 2, 5, 3};

        System.out.println(findRepeatNumber1(num));

        System.out.println(findRepeatNumber2(num));
    }

    /**
     * 方法1：此方法时间复杂度为O(nlgn)，还有一个缺点是原数组会被修改。
     * 此方法先将数组排序，然后比较前后的两个数是否相同。
     *
     * @param nums
     * @return
     */
    public static int findRepeatNumber1(int[] nums) {
        if (Objects.isNull(nums)) {
            return -1;
        }

        if (nums.length == 0) {
            return -1;
        }

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 1; i++) {
            // TODO 题目规定, 数组中所有数据都必须在 0 至 n-1 的范围内.
            //  不符合规定就退出.
            if (nums[i] < 0 || nums[i] > nums.length - 1) {
                throw new IllegalArgumentException("数组内元素不满足题意。");
            }
            if (nums[i] == nums[i + 1]) {
                return nums[i];
            }
        }

        return -1;
    }

    /**
     * 方法2：时间复杂度为O(n),空间复杂度为O(1)，同时也修改了数组的结构。
     * 代码中尽管有一个两重循环，但每个数字最多只要交换两次就能找到属于它自己的位置，因此总的时间复杂度为O(n)。
     * 又因为是in-place操作，所以空间复杂度为O(1)。
     *
     * @param nums
     * @return
     */
    public static int findRepeatNumber2(int[] nums) {
        if (Objects.isNull(nums)) {
            return -1;
        }

        if (nums.length == 0) {
            return -1;
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0 || nums[i] > nums.length - 1) {
                throw new IllegalArgumentException("数组内元素不满足题意。");
            }
            while (nums[i] != i) {
                // TODO 获取nums[i]的数字: 比如是 5, 然后与 数组 nums 索引等于5的元素做对比.
                if (nums[i] == nums[nums[i]]) {
                    //  TODO 如果相等, 说明有重复元素.
                    return nums[i];
                } else {
                    // TODO 如果不相等, 设:i = 2, nums[i] = 5;
                    int tmp = nums[i];
                    nums[i] = nums[tmp];   // 把 nums[5]的 值 放到 num[2] 上.
                    nums[tmp] = tmp;    // 把5放到nums[5]的位置上.
                }
            }

        }

        return -1;
    }
}
