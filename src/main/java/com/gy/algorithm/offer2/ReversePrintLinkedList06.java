package com.gy.algorithm.offer2;

import java.util.Stack;

/**
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * 示例 1：
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
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

}
