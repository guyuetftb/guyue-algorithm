package com.gy.algorithm.offer2;

/**
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 * <p>
 *  
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 *  
 * <p>
 * 链接：https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof
 *
 * @author : leelipeng
 * @date : 2021-02-23 11:24
 */
public class ReverseLinkedList24 {

    public static void main(String[] args) {
        ListNode dummyhead1 = new ListNode(-1);
        ListNode node1 = new ListNode(1);
        dummyhead1.next = node1;
        ListNode node2 = new ListNode(2);
        node1.next = node2;
        ListNode node3 = new ListNode(3);
        node2.next = node3;
        ListNode node4 = new ListNode(4);
        node3.next = node4;
        ListNode node5 = new ListNode(5);
        node4.next = node5;
        ListNode node6 = new ListNode(6);
        node5.next = node6;
        ListNode node7 = new ListNode(7);
        node6.next = node7;
        ListNode node8 = new ListNode(8);
        node7.next = node8;
        ListNode node9 = new ListNode(9);
        node8.next = node9;
        ListNode node10 = new ListNode(10);
        node9.next = node10;
        ListNode node11 = new ListNode(11);
        node10.next = node11;
        ListNode node13 = new ListNode(13);
        node11.next = node13;
        ListNode node15 = new ListNode(15);
        node11.next = node15;

        reverseLinkedList(dummyhead1);
    }

    /**
     * 个人想法:
     * 1. 双指针
     * 2. 定义两个指针 cur, pre; pre在前, cur在后.
     * 3. 迭代LinkedList, 让 pre.next = cur;
     * 4-1. 先保存 pre.next 值.
     * 4-2. pre.next = cur
     * 4-3. cur 指针后移
     * 4-4. pre 指针后移, pre = tmpNext;
     *
     * @param dummyHead
     */
    public static void reverseLinkedList(ListNode dummyHead) {
        ListNode tmpDummyHead = dummyHead;

        // pre等于第1个节点.
        ListNode pre = tmpDummyHead.next;
        ListNode cur = null;
        while (pre != null) {
            // 保存pre节点的下个节点.
            ListNode tmpNext = pre.next;
            // 反向操作 把 1 -> 2 变成 2 -> 1
            pre.next = cur;
            // cur 指针后移.
            cur = pre;
            // pre 指针后移.
            pre = tmpNext;
        }

        tmpDummyHead.next = cur;
        System.out.println("aaaaaa");
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
