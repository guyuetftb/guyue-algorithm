package com.gy.algorithm.offer2;

/**
 * <p> 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。  
 *
 * <p>
 * <p> 示例 1：
 *
 * <p> 输入：[3,4,5,1,2]
 * <p> 输出：1
 *
 * <p>
 * <p> 示例 2：
 * <p> 输入：[2,2,2,0,1]
 * <p> 输出：0
 * <p>
 * 链接：https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof
 *
 * <p> 解题1: </p>
 * <p> 如下图所示，寻找旋转数组的最小元素即为寻找 右排序数组 的首个元素 nums[x]，称 x 为 旋转点 。</p>
 * <p> 循环二分： 设 m = (i + j) / 2，
 * <p> m=(i+j)/2 为每次二分的中点（ "/" 代表向下取整除法，因此恒有 i \leq m < ji≤m<j ），可分为以下三种情况：
 * <p> 1. 当 nums[m] > nums[j] 时： m 一定在 左排序数组 中，即旋转点 x 一定在 [m + 1, j] 闭区间内，因此执行 i = m + 1
 * <p> 2. 当 nums[m] < nums[j] 时： m 一定在 右排序数组 中，即旋转点 x 一定在[i, m] 闭区间内，因此执行 j = m
 * <p> 3. 当 nums[m] = nums[j] 时： 无法判断 m 在哪个排序数组中，即无法判断旋转点 x 在 [i, m] 还是 [m + 1, j] 区间中。
 * <p> 解决方案： 执行 j = j - 1 缩小判断范围
 * <p> 返回值： 当 i = j 时跳出二分循环，并返回 旋转点的值 nums[i] 即可。
 * <p>
 * 链接：https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/solution/mian-shi-ti-11-xuan-zhuan-shu-zu-de-zui-xiao-shu-3/
 *
 * @author : leelipeng
 * @date : 2021-01-23 22:07
 */
public class FindMinimumInRotatedSortedArray11 {

    public static void main(String[] args) {
        int[] arr = new int[]{4, 5, 6, 7, 1, 2, 3};
        System.out.println(" minimum = " + findMinimum(arr));
        int[] arr1 = new int[]{2, 2, 2, 2, 0, 1, 2};
        System.out.println(" minimum = " + findMinimum2(arr1));
    }

    public static int findMinimum(int[] array) {
        int minimumIndex = -1;
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i - 1]) {
                minimumIndex = i;
                break;
            }
            continue;
        }
        return minimumIndex == -1 ? array[0] : array[minimumIndex];
    }

    /**
     * <p> 排序数组的查找问题首先考虑使用 二分法 解决，其可将 遍历法 的 线性级别 时间复杂度降低至 对数级别.
     * <p> Link: https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/solution/mian-shi-ti-11-xuan-zhuan-shu-zu-de-zui-xiao-shu-3/
     * <p>
     * <p>
     * 问题: 拿到问题想得简单了, 以为只要遍历数组, 找到第1个, n-1比n大的就是想要的数据.
     * 看了网上的回答学习到, 这种问题也可以使用2分法来解决.
     *
     * <p> 思路:</p>
     * <p> 使用数组中特殊的位置, 最左侧, 最右侧, 中间的数据来判断最小的数据在数组的哪部分.</p>
     * <p> 个人想法: 不能使用左侧的数据与mid进行比较, 因为比较不出来. 由于数组是递增的, 而且是旋转的 性质 及 小的数据应该在右侧
     * <p> 所以应该使用数组右侧数据对数组比较。
     * <p> [3, 4, 5, 1, 2]
     * [1, 2, 3, 4, 5]
     * 不能使用左边数与中间数比较，这种做法不能有效地减治
     *
     * <p> [1, 2, 3, 4, 5]
     * <p> [3, 4, 5, 1, 2]
     * <p> [2, 3, 4, 5 ,1]
     * <p>
     * 链接：https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/solution/er-fen-jian-zhi-si-xiang-fen-zhi-si-xiang-by-liwei/
     *
     * @param array
     * @return
     */
    public static int findMinimum2(int[] array) {
        if (array.length <= 0) {
            return 0;
        }

        int low = 0;
        int high = array.length - 1;
        /**
         * <p> 输入：[4,5,6,7,1,2,3]
         * <p> 输入：[2,2,2,2,0,1,2]
         */
        while (low < high) {
            int mid = (low + high) / 2;
            if (array[mid] > array[high]) {
                // mid的左侧一定不是最小数的范围
                // 下一轮从[mid+1, right] 开始找
                low = mid + 1;
            } else if (array[mid] == array[high]) {
                // 像下面这种情况 [2,2,2,2,0,1,2] 无法确定旋转点在哪个数组中.
                // 即执行: j = j-1
                high = high - 1;
            } else if (array[mid] < array[high]) {
                // mid的右侧一定不是最小数字, mid有可能是最小数字, 下一轮从 [low, mid] 开始找
                high = mid;
            }
        }
        return array[low];
    }
}
