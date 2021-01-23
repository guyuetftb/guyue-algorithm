package com.gy.algorithm.offer2;

import java.util.Stack;

/**
 * <p> 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
 * <p> 分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1)
 * <p>
 * 输入：
 * ["CQueue","appendTail","deleteHead","deleteHead"]
 * [[],[3],[],[]]
 * 输出：[null,null,3,-1]
 * 示例 2：
 * <p>
 * 输入：
 * ["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
 * [[],[],[5],[2],[],[]]
 * 输出：[null,-1,null,null,5,2]
 * 提示：
 * <p>
 * 1 <= values <= 10000
 * 最多会对 appendTail、deleteHead 进行 10000 次调用
 * <p>
 * 链接：https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof
 *
 * @author : leelipeng
 * @date : 2021-01-23 19:55
 */
public class CQueue09 {

    /**
     * 问题:
     * 刚开始看到该题目,字符串与数字混合输入没有看懂题意，看了答案才明白，不用关心字符串。
     *
     * 问题1: 栈只能是先进后出, 后进先出.
     * 问题2: 单纯使用栈无法实现 队列的功能.
     * 问题3: 可以使用2栈实现队列功能, 1个队列负责插入元素, 2个队列负责输出元素.
     * 问题4: 输出元素时, deleteStack中没有元素, 把addStack中元素 弹栈, 再插入 deleteStack中, 再从deleteStack中出栈,就实现了栈的功能.
     * @param args
     */
    public static void main(String[] args) {
        CQueue cQueue = new CQueue();
        cQueue.appendTail(11);
        cQueue.appendTail(22);
        cQueue.appendTail(33);

        System.out.println(cQueue.deleteHead());
        System.out.println(cQueue.deleteHead());
        cQueue.appendTail(44);
        System.out.println(cQueue.deleteHead());
        cQueue.appendTail(55);
        cQueue.appendTail(66);
        System.out.println(cQueue.deleteHead());
        System.out.println(cQueue.deleteHead());
        System.out.println(cQueue.deleteHead());
    }

    public static class CQueue {
        private Stack<Integer> addStack;
        private Stack<Integer> deleteStack;

        public CQueue() {
            addStack = new Stack<>();
            deleteStack = new Stack<>();
        }

        public void appendTail(int value) {
            // 只负责添加元素即可.
            addStack.add(value);
        }

        public int deleteHead() {
            // deleteStack为空, 把addStack的元素全部倒入deleteStack, 元素的顺序就 正了.
            if (deleteStack.isEmpty()) {
                while (!addStack.isEmpty()) {
                    deleteStack.add(addStack.pop());
                }
            }

            // deleteStack为空, 直接返回-1
            if (deleteStack.isEmpty()) {
                return -1;
            }

            // deleteStack不为空.
            return deleteStack.pop();
        }

    }
}
