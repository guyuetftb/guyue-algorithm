package com.gy.algorithm.leetcode.linked;

import com.gy.datastructure.linkedlist.LinkedList;

/**
 * Friendship is a sheltering tree.
 *
 * @author : guyuetftb
 * @date : 2020-09-14 17:14
 */
public class LC19LinkedRemoveNthNodeFromEndOfListTwoCycle {

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

        // TODO 解题思路:
        //  题目要求我们从『后』删除第N个元素;
        //  错误的理解[WRONG]:
        //  a. 如果是双向链表, 维护有『头，尾』两个指针, 那直接从尾部删除即可.
        //  b. 如果是单向链表, 只维护『头』指针, 删除尾部元素就不太容易, 那就可以换个思维把『删除尾部元素』变成『删除头部元』,
        //      把尾部坐标 转换成 头部坐标
        //  上面的假设在『算法』题中是不存在的, 就跟解数学题一样, 题目没有告诉你的条件不能擅自往里加.

        // TODO
        //  type1
        System.out.println();
        removeNthFromEndTwoCycle(linkedList.getDummyHead(), 3);
        show(linkedList);
    }

    public static void removeNthFromEndTwoCycle(LinkedList.Node<Integer> dummyHead, int n) {
        // TODO
        //  链表一般都有1个虚的头节点, 该节点不存储任何数据,只是用于方便操作 dummyHead
        //  链表没有给出直接的长度, 我们需要循环2次:
        //  step-1: 1次循环获得链表长度
        LinkedList.Node<Integer> preHead = dummyHead;
        int size = 0;
        while (null != preHead.next) {
            size++;
            preHead = preHead.next;
        }
        System.out.println("size = " + size);

        // TODO [1,3,4,5,8,10]
        //  step-2: 2次循环删除指定元素
        //  要删除『倒数第N』个，其实就是删除『正数第 Size - N + 1』个.
        //  又由于是单向链表, 正向找到了 N, 就丢失了前面的连接, 所以 reverseN = Size - N
        //  设: n = 3, reverseN = 3 = 6 - 3
        int reverseN = size - n;
        int numIndex = 0;
        preHead = dummyHead;
        while (null != preHead.next && numIndex < reverseN) {
            numIndex++;
            preHead = preHead.next;
        }
        LinkedList.Node<Integer> removedNode = preHead;
        preHead.next = preHead.next.next;
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
