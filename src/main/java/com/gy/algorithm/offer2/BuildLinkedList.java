package com.gy.algorithm.offer2;

/**
 * Friendship is a sheltering tree.
 *
 * @author : leelipeng
 * @date : 2021-02-23 11:29
 */
public class BuildLinkedList {

    public static void linked1(String[] args) {
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
    }

    public static void linked2(String[] args) {
        ListNode dummyhead = new ListNode(-1);
        ListNode node1 = new ListNode(11);
        dummyhead.next = node1;
        ListNode node2 = new ListNode(22);
        node1.next = node2;
        ListNode node3 = new ListNode(33);
        node2.next = node3;
        ListNode node4 = new ListNode(44);
        node3.next = node4;
        ListNode node5 = new ListNode(55);
        node4.next = node5;
        ListNode node6 = new ListNode(66);
        node5.next = node6;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
