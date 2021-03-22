package com.gy.algorithm.offer2;

import java.util.Stack;

/**
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。例如，序列 {1,2,3,4,5} 是某栈的压栈序列，
 * 序列 {4,5,3,2,1} 是该压栈序列对应的一个弹出序列，
 * 但 {4,3,5,1,2} 就不可能是该压栈序列的弹出序列。
 * <p>
 * 示例 1：
 * <p>
 * 输入：pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
 * 输出：true
 * 解释：我们可以按以下顺序执行：
 * push(1), push(2), push(3), push(4), pop() -> 4,
 * push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
 * 示例 2：
 * <p>
 * 输入：pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
 * 输出：false
 * 解释：1 不能在 2 之前弹出。
 *
 * @author : leelipeng
 * @date : 2021-03-19 15:05
 */
public class ValidateStackSequences31 {

    /**
     * 个人想法：
     * 刚拿到题目时，没有什么思路, 但想到2点：
     * 1. 需要借䢁栈，实际模拟入栈顺序。
     * 2. 需要出栈的栈顶元素去作对比。
     * 个人问题：
     * 1. 没有想到程序如何结果循环.
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] pushed = new int[]{1, 2, 3, 4, 5};
        int[] popped = new int[]{4, 5, 3, 2, 1};
        boolean b = validateStackSequences(pushed, popped);
        System.out.println(b);

    }

    public static boolean validateStackSequences(int[] pushed, int[] poped) {
        if (pushed.length != poped.length) {
            return false;
        }
        // 1. 构造1个栈
        Stack<Integer> stack = new Stack<>();
        int popedIndex = 0;
        for (Integer i : pushed) {
            // 2. 遍历pushed数组, 将pushed数组挨个入栈.
            stack.push(i);
            /**
             * 这个循环条件我没有想清楚, 没有写上来, 其他部分与网上一致.
             */
            // 3. 对比poped中的元素, 如果顺序一致, 就将Pushed中的元素弹出
            while (!stack.isEmpty() && stack.peek() == poped[popedIndex]) {
                // 3-a: 如果栈不为空, 且 栈顶的元素与 弹出栈的相关位置元素相等
                // 3-b: 就弹出栈顶元素
                stack.pop();
                // 3-c: popedIndex 指针接着向后移动, 接着比较stack的下一个元素.
                popedIndex++;
            }
        }
        if (stack.isEmpty()) {
            return true;
        }
        return false;
    }


}
