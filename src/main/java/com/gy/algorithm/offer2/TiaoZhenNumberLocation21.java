package com.gy.algorithm.offer2;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 * <p>
 * 示例：
 * <p>
 * 输入：nums = [1,2,3,4]
 * 输出：[1,3,2,4]
 * 注：[3,1,2,4] 也是正确的答案之一。
 * <p>
 * 链接：https://leetcode-cn.com/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof
 *
 * @author : leelipeng
 * @date : 2021-02-03 11:18
 */
public class TiaoZhenNumberLocation21 {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
        show(nums);
        int[] resNums = exchange(nums);
        show(resNums);

        System.out.println("-------------------------------------------------");
        int[] nums2 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
        show(nums2);
        int[] resNums2 = exchangeSlowFastPoint(nums2);
        show(resNums2);
    }

    /**
     * 个人想法: 可以使用 [首尾双指针] 来解决. 定义两个指针,
     * <p>
     * 解题步骤:
     * <p> 1. 定义头指针 leftleft ，尾指针 rightright .
     * <p> 2. leftleft 一直往右移，直到它指向的值为偶数
     * <p> 3. rightright 一直往左移， 直到它指向的值为奇数
     * <p> 4. 交换 nums[left]nums[left] 和 nums[right]nums[right] .
     * <p> 5. 重复上述操作，直到 left == rightleft==right .
     *
     * <p> https://leetcode-cn.com/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof/solution/ti-jie-shou-wei-shuang-zhi-zhen-kuai-man-shuang-zh/
     *
     * @param nums
     * @return
     */
    public static int[] exchange(int[] nums) {
        // TODO 数组为空, 退出
        if (null == nums) {
            return null;
        }

        // TODO 双指针
        //  lowPoint低指针.
        //  highPoint高指针, 注意需要对高指针减1.
        int lowPoint = 0;
        int highPoint = nums.length - 1;
        int tmp = -1;
        while (lowPoint < highPoint) {
            if (nums[lowPoint] % 2 != 0) {
                // TODO 低位是奇数（对2取余不为0）
                //  奇数指针加1.
                lowPoint++;
                continue;
            }

            if (nums[highPoint] % 2 == 0) {
                // TODO 高位是偶数（对2取余为0）
                //  偶数指针减1
                highPoint--;
                continue;
            }

            // TODO 如果循环走到这里, 说明符合交换条件
            //  swap: lowPoint=1, nums[lowPoint]=2 -- highPoint=12, nums[highPoint]=13
            //  swap: lowPoint=3, nums[lowPoint]=4 -- highPoint=10, nums[highPoint]=11
            //  swap: lowPoint=5, nums[lowPoint]=6 -- highPoint=8, nums[highPoint]=9
            System.out.println("swap: lowPoint=" + lowPoint + ", nums[lowPoint]=" + nums[lowPoint] + " -- highPoint=" + highPoint + ", nums[highPoint]=" + nums[highPoint]);
            tmp = nums[lowPoint];
            nums[lowPoint] = nums[highPoint];
            nums[highPoint] = tmp;
        }

        return nums;
    }

    /**
     * 个人想法: 上面的算法是使用 [首尾双指针] 从2个方向扫描数据.
     * 也可以定义 [快慢双指针] 从1个方向扫描数据.
     *
     * @param nums
     * @return
     */
    public static int[] exchangeSlowFastPoint(int[] nums) {
        // TODO 数组为空, 退出
        if (null == nums) {
            return null;
        }

        // TODO 双指针
        //  slowPoint 慢指针, 指奇数.
        //  fastPoint 快指针, 指偶数.
        int slowPoint = 0;
        int fastPoint = 0;
        int tmp = -1;
        // TODO 循环终止条件, 两个坐标不能超过数组长度
        while (slowPoint < nums.length && fastPoint < nums.length) {
            if (nums[fastPoint] % 2 != 0) {
                // TODO 慢指针是奇数（对2取余不为0）
                //  奇数指针加1.
                System.out.println("swap: slowPoint=" + slowPoint + ", nums[slowPoint]=" + nums[slowPoint] + " -- fastPoint=" + fastPoint + ", nums[fastPoint]=" + nums[fastPoint]);
                tmp = nums[slowPoint];
                nums[slowPoint] = nums[fastPoint];
                nums[fastPoint] = tmp;
                slowPoint++;
            }
            fastPoint++;
        }

        return nums;
    }

    public static void show(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }


}
