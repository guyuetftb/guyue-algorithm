package com.gy.algorithm.leetcode.linked;

import com.gy.datastructure.linkedlist.LinkedList;

/**
 * Friendship is a sheltering tree.
 *
 * @author : guyuetftb
 * @date : 2020-09-14 17:14
 */
public class LC19LinkedRemoveNthNodeFromEndOfListOneCycle {

    /**
     * TODO 题目说明
     * <p>
     * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
     * 示例：
     * 给定一个链表: 1->2->3->4->5, 和 n = 2.
     * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
     *
     * <p>
     * 说明：
     * 给定的 n 保证是有效的。
     *
     * <p>
     * 进阶：
     * 你能尝试使用一趟扫描实现吗？
     *
     * @param args
     */
    public static void main(String[] args) {
        // TODO 自己实现的数据结构
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.addLast(1);
        linkedList.addLast(3);
        linkedList.addLast(4);
        linkedList.addLast(5);
        linkedList.addLast(8);
        linkedList.addLast(10);
        show(linkedList);
        removeNthFromEndOneCycle(linkedList.getDummyHead(), 3);
        show(linkedList);
    }

    public static void removeNthFromEndOneCycle(LinkedList.Node<Integer> dummyHead, int n) {
        // TODO 只循环1遍就找到删除的节点
        //  参考网上资料, 设定2个指针, 2个指针之间 『隔N个元素』, 同时向右移动指针.
        //  等最右侧的指针为null时, 第1个指针就是要删除的元素
        //  在向右移时, 需要记录第1个指针上一个元素的索引
        //  刚开始不太明白这种思想, 多想想就会明白, 其实2个指针中间的『数据值量n』, 与传入的参数N的『数值量』是相等的。
        //  通过指针的不断移动, 一点点找到 『真正要删除』的那个元素。

        // TODO 这里指向的节点比较重要, 我之前firstHead, secondHead指向 dummyHead, 结果不对.
        LinkedList.Node<Integer> firstHead = dummyHead.next;
        LinkedList.Node<Integer> secondHead = dummyHead.next;
        for (int i = 0; i < n + 1; i++) {
            // TODO 让两个指针之间相差n
            secondHead = secondHead.next;
        }

        // TODO 直到 secondHead 为空
        while (null != secondHead) {
            firstHead = firstHead.next;
            secondHead = secondHead.next;
        }
        LinkedList.Node<Integer> removedNode = firstHead.next;
        firstHead.next = firstHead.next.next;
    }

    public static void show(LinkedList<Integer> linkedList) {
        try {
            for (int i = 0; i < linkedList.getSize(); i++) {
                System.out.print(linkedList.get(i));
                System.out.print(",");
            }
            System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
