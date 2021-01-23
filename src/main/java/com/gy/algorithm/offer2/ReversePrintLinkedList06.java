package com.gy.algorithm.offer2;

import java.util.Stack;

/**
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * 示例 1：
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 *
 * 限制：
 * 0 <= 链表长度 <= 10000
 *
 * @author : leelipeng
 * @date : 2021-01-23 15:27
 */
public class ReversePrintLinkedList06 {


    /**
     * 看到题的想法:
     * 想法1: 让反转链表, 肯定不是双向链表.
     * 想法2: 让反转链表, 可能需要用到 栈，因为栈有先入后出，后入先出的性质。
     * 想法3: 可能需要迭代2次。
     *
     * @param args
     */
    public static void main(String[] args) {
        // 创建1个简单的链表
        ListNode head = new ListNode(0);
        ListNode cur = head;
        for (int i = 1; i < 10; i++) {
            // 创建新节点,并把新节点next 设置为 null
            ListNode node = new ListNode(i);
            node.next = null;

            // 让cur.next = 新节点
            cur.next = node;

            // 让新节点变成当前节点
            cur = node;
        }
        reverseLinkedList(head);
        int[] resArr2 = reverseLinkedList2(head);
        System.out.println(resArr2.length);
    }


    /**
     * @return
     */
    public static int[] reverseLinkedList(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        // 把所有元素都 压栈.
        ListNode cur = head;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }

        cur = null;
        int[] valArr = new int[stack.size()];
        int index = 0;
        // 把所有元素弹栈.
        // 必须加上 !stack.isEmpty()，因为stack为空会抛出异常.
        while (!stack.isEmpty() && (cur = stack.pop()) != null) {
            System.out.println(cur.val);
            valArr[index] = cur.val;
        }

        return valArr;

    }

    static public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static int arrSize = 0;
    public static int recursionIndex = 0;
    public static int[] resArr = null;
    /**
     * 通过递归的方式反转链表.
     * 问题1: 题目有限制链表小点于10000, 其实这也可能会造成栈溢出.
     * 问题2: 递归的方式也是不知道链表长度的.
     * 问题3: 递归返回时, 为结果数组赋值, 所以链表长度, 递归索引必须是全局可访问的
     * @param head
     * @return
     */
    public static int[] reverseLinkedList2(ListNode head){
        reverse(head);
        return resArr;
    }

    public static void reverse(ListNode head){
        if(head == null){
            // 已经到了链表尾, 知道了 链表长度
            resArr = new int[arrSize];
            return;
        }
        // 未到链表末尾, 个数加1.
        arrSize ++;
        // 使用当前链表下1个节点接着递归
        reverse(head.next);
        // 已经到链表尾, 或 上一轮递归返回.
        // 从后向前为 结果数组resArr赋值.
        resArr[recursionIndex] = head.val;
        // 第1次 recursionIndex = 0, 所以应该先从 赋值, 再对 recursionIndex 累加.
        recursionIndex++;
    }

}
