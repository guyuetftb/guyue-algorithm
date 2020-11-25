package com.gy.algorithm.leetcode.linked;

import com.gy.datastructure.linkedlist.LinkedList;
import com.gy.datastructure.linkedlist.LinkedList.Node;
import com.sun.xml.internal.bind.v2.runtime.output.SAXOutput;

/**
 * Friendship is a sheltering tree.
 *
 * @author : leelipeng
 * @date : 2020-11-17 16:08
 */
public class LC2LinkedAddTwoNumbers {


    /**
     * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
     * <p>
     * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
     * <p>
     * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     * <p>
     * 示例：
     * <p>
     * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
     * 输出：7 -> 0 -> 8
     * 原因：342 + 465 = 807
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/add-two-numbers
     *
     * @param args
     */
    public static void main(String[] args) {

        LinkedList<Integer> linked1 = new LinkedList<>();
        linked1.add(0, 2);
        linked1.add(1, 4);
        linked1.add(2, 3);
        linked1.add(3, 1);

        LinkedList<Integer> linked2 = new LinkedList<>();
        linked2.add(0, 5);
        linked2.add(1, 6);
        linked2.add(2, 4);
        linked2.add(3, 2);
        linked2.add(4, 1);

        Node<Integer> node = solution(linked1.getFirstNode(), linked2.getFirstNode());
        System.out.println(" -- new linked -- " + node);
    }

    public static Node<Integer> solution(Node<Integer> node1, Node<Integer> node2) {
        Node<Integer> dummyHead = new Node<>(0);
        // 第1节点, cur == dummyHead
        Node<Integer> cur = dummyHead;

        boolean overflow = false;
        while (node1 != null || node2 != null) {
            // 判断节点值情况
            int val1 = node1 == null ? 0 : node1.e;
            int val2 = node2 == null ? 0 : node2.e;

            // 判断余数
            int remainder = (val1 + val2) % 10;

            // 创建新节点
            Node node = new Node(overflow ? remainder + 1 : remainder);

            // 修改指针, 首次 dummyHead = cur, dummyHead.next = node
            cur.next = node;
            cur = node;

            // 判断是否有进位.
            overflow = val1 + val2 >= 10 ? true : false;

            // 指针后移
            if (node1 != null) {
                node1 = node1.next;
            }
            if (node2 != null) {
                node2 = node2.next;
            }
        }

        return dummyHead;
    }


    public void me() {
        LinkedList<Integer> linked1 = new LinkedList<>();
        linked1.add(0, 2);
        linked1.add(1, 4);
        linked1.add(2, 3);

        LinkedList<Integer> linked2 = new LinkedList<>();
        linked2.add(0, 5);
        linked2.add(1, 6);
        linked2.add(2, 4);

        LinkedList<Integer> result = new LinkedList<>();

        boolean overflow = false;
        int index = 0;
        while (index < linked1.getSize() && index < linked2.getSize()) {
            // 判断2数相加是否大于10
            int remainder = (linked1.get(index) + linked2.get(index)) % 10;

            // 对 余数, 和上一次的 进位做处理
            result.add(index, overflow ? remainder + 1 : remainder);

            // 判断本次是否有进位
            if (linked1.get(index) + linked2.get(index) >= 10) {
                overflow = true;
            }
            index++;
        }
        System.out.println("aaaa");
    }
}
