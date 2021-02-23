package com.gy.algorithm.offer2;

/**
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 * <p>
 * 示例1：
 * <p>
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * 限制：
 * <p>
 * 0 <= 链表长度 <= 1000
 * <p>
 * 链接：https://leetcode-cn.com/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof
 *
 * @author : leelipeng
 * @date : 2021-02-23 11:26
 */
public class MergeTwoSortedLinkedList25 {

    public static void main(String[] args) {
        ListNode dummyhead1 = new ListNode(-1);
        ListNode node1 = new ListNode(1);
        dummyhead1.next = node1;
        ListNode node2 = new ListNode(3);
        node1.next = node2;
        ListNode node3 = new ListNode(5);
        node2.next = node3;
        ListNode node4 = new ListNode(7);
        node3.next = node4;
        ListNode node5 = new ListNode(9);
        node4.next = node5;

        ListNode dummyhead2 = new ListNode(-1);
        ListNode node6 = new ListNode(2);
        dummyhead2.next = node6;
        ListNode node7 = new ListNode(4);
        node6.next = node7;
        ListNode node8 = new ListNode(6);
        node7.next = node8;
        ListNode node9 = new ListNode(8);
        node8.next = node9;
        ListNode node10 = new ListNode(10);
        node9.next = node10;
        ListNode node11 = new ListNode(11);
        node10.next = node11;
        ListNode node13 = new ListNode(13);
        node11.next = node13;
        ListNode node15 = new ListNode(15);
        node11.next = node15;

        mergeTwoSortedLinkedList1(dummyhead1, dummyhead2);
    }

    /**
     * 个人思想
     * 1. list1 为null, 返回 list2
     * 2. list2 为null, 返回 list1
     * 3. 迭代2个list, 依次取出list1, list2中的元素.
     * 4. 比较2个元素, 把小元素追加到 结果LinkedList中, 被追加的 LinkedList 向后移.
     * 5. 比较2个元素, 如果元素相等, 把2个元素都追加到 结果LinkedList中, 被追加的 LinkedList 向后移.
     * 6. 跳出迭代后, 肯定有1个LinkedList 不为空, 这时需要把不空null的LinkedList追加到 结果LinkedList后即可.
     *
     * @param dummyHead1
     * @param dummyHead2
     * @return
     */
    public static ListNode mergeTwoSortedLinkedList1(ListNode dummyHead1, ListNode dummyHead2) {
        if (dummyHead1 == null) {
            return dummyHead2;
        }
        if (dummyHead2 == null) {
            return dummyHead1;
        }
        ListNode resultDummyHead = new ListNode(-1);
        ListNode resultCur = resultDummyHead;
        ListNode cur1 = dummyHead1.next;
        ListNode cur2 = dummyHead2.next;

        /**
         * 1. 处理2个LinkedList 都不为null的情况, 当循环结束后, 肯定会有1个 LinkedList 不为空,
         */
        while (cur1 != null && cur2 != null) {
            if (cur1.val <= cur2.val) {
                resultCur.next = cur1;
                cur1 = cur1.next;
            } else if (cur2.val < cur1.val) {
                resultCur.next = cur2;
                cur2 = cur2.next;
            }

            resultCur = resultCur.next;
        }

        /**
         * 2. 这时只需要把不空null的LinkedList追加到 结果LinkedList后即可.
         */
        resultCur.next = cur1 == null ? cur2 : cur1;
        return resultCur;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
