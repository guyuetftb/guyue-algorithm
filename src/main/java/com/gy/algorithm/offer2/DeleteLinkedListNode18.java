package com.gy.algorithm.offer2;

/**
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 * <p>
 * 返回删除后的链表的头节点。
 * <p>
 * 注意：此题对比原题有改动
 * <p>
 * 示例 1:
 * <p>
 * 输入: head = [4,5,1,9], val = 5
 * 输出: [4,1,9]
 * 解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
 * 示例 2:
 * <p>
 * 输入: head = [4,5,1,9], val = 1
 * 输出: [4,5,9]
 * 解释: 给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
 * <p>
 * 链接：https://leetcode-cn.com/problems/shan-chu-lian-biao-de-jie-dian-lcof
 *
 * @author : leelipeng
 * @date : 2021-02-03 09:47
 */
public class DeleteLinkedListNode18 {

    public static void main(String[] args) {
        ListNode dummyhead = new ListNode(-1);

        ListNode node4 = new ListNode(4);
        dummyhead.next = node4;
        ListNode node1 = new ListNode(1);
        node4.next = node1;
        ListNode node5 = new ListNode(5);
        node1.next = node5;
        ListNode node9 = new ListNode(9);
        node5.next = node9;
        ListNode rstNode = deleteNode(dummyhead, 4);
        System.out.println(rstNode.val);
    }

    /**
     * 个人理解: 通过双指针的方式解决问题，与LeetCode上的思路一样.
     * https://leetcode-cn.com/problems/shan-chu-lian-biao-de-jie-dian-lcof/solution/shuang-zhi-zhen-he-di-gui-liang-chong-fang-shi-jie/
     *
     * @param head
     * @param value
     * @return
     */
    public static ListNode deleteNode(ListNode head, int value) {
        ListNode dummyHead = head;
        ListNode pre = head.next;
        while (pre != null) {
            if (pre.val == value) {
                dummyHead.next = pre.next;
                break;
            }
            dummyHead = pre;
            pre = pre.next;
        }
        return head;
    }

    /**
     * 参考: 通过递归的方式删除节点.
     * https://leetcode-cn.com/problems/shan-chu-lian-biao-de-jie-dian-lcof/solution/shuang-zhi-zhen-he-di-gui-liang-chong-fang-shi-jie/
     *
     * @param head
     * @param val
     * @return
     */
    public static ListNode deleteNodeByCycle(ListNode head, int val) {
        // TODO
        //  递归过程中,如果节点为null,说明到达了链表尾部.
        if (head == null) {
            return head;
        }

        // TODO 当前值 等于 val, 返回下一个节点.
        if (head.val == val) {
            return head.next;
        }

        // TODO 当前节点值 不等于 给定val, 接着递归求解.
        head.next = deleteNodeByCycle(head.next, val);
        return head;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}


