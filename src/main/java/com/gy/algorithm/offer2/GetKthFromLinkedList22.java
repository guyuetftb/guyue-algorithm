package com.gy.algorithm.offer2;

/**
 * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
 * 例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 3 个节点是值为 4 的节点。
 * <p>
 * <p>
 * 示例：
 * <p>
 * 给定一个链表: 1->2->3->4->5->6, 和 k = 2.
 * <p>
 * 返回链表 4->5.
 * <p>
 * 链接：https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof
 *
 * @author : leelipeng
 * @date : 2021-02-03 12:32
 */
public class GetKthFromLinkedList22 {

    public static void main(String[] args) {
        ListNode dummyhead = new ListNode(-1);
        ListNode node1 = new ListNode(1);
        dummyhead.next = node1;
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

        ListNode rstNode = getKthFromEnd(dummyhead, 4);
        System.out.println(rstNode.val);
    }


    /**
     * 个人想法:
     *
     * <p> 1. 首先需要确定链表的长度.
     * <p> 2. 迭代链表删除链表中对应的节点. </p>
     *
     * @param head
     * @param k
     * @return
     */
    public static ListNode getKthFromEnd(ListNode head, int k) {
        ListNode dummyHead = head;
        ListNode pre = dummyHead.next;
        int size = 0;
        while (pre != null) {
            size++;
            pre = pre.next;
        }
        System.out.println("size = " + size);

        /**
         * TODO []
         *  step-2: 2次循环删除指定元素.
         *  要删除 "倒数第k个", 其实就是删除 "正数第 m-k+1"
         *  由于是单身链表, 正向找到了 N ,
         */
        int reverseN = size - k;
        int index = 0;
        pre = dummyHead;
        ListNode cur = pre.next;
        while (null != cur && index < reverseN) {
            index++;
            // 记录前1个节点.
            pre = cur;
            // 指针下移.
            cur = cur.next;
        }
        ListNode deleteNode = cur;
        System.out.println("deleteNode value = " + deleteNode.val);
        pre.next = cur.next;
        return dummyHead;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
