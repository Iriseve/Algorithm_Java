package leetcode.medium;

import java.util.ArrayList;

/**
 * @ClassName T148
 * @Description 排序链表
 * @Author yiling
 * @date 2023/5/20 22:37
 */
public class T148 {
    public static void main(String[] args) {
        int[] a = {4, 2, 1, 3};
        ListNode listNode = new ListNode(a[0]);//头结点
        ListNode listNode0 = listNode;//头结点
        for (int i = 1; i < a.length; i++) {
            ListNode listNode1 = new ListNode(a[i]); //后一个结点
            listNode0.next = listNode1; //前一个结点和该结点连起来
            listNode0 = listNode1; //改变前一个结点
        }
//        System.out.println(listNode.toString());
        System.out.println(Solution.sortList(listNode).toString());
    }
}

class ListNode {
    int val; //结点值
    ListNode next; //下一个结点地址

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}

class Solution {
    public static ListNode sortList(ListNode head) {
        return mergeSort2(head);
    }

    /**
     * 归并排序（递归）
     *
     * @param head
     * @return
     */
    //找链表中点（快慢指针）
    public static ListNode findMid(ListNode head) {
        //没有结点或只有一个结点
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fast = head.next; //快指针 每次走2步
        ListNode slow = head;//慢指针 每次走1步
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    //切分+排序
    public static ListNode mergeSort(ListNode head) {
        // 没有元素或只有一个元素，直接返回
        if (head == null || head.next == null) {
            return head;
        }
        //找到中间结点，拿这个点进行切分
        ListNode mid = findMid(head);
        ListNode next = mid.next; //存储下一个结点
        mid.next = null; //从中间结点断开，对两边进行迭代切分

        ListNode left = mergeSort(head);
        ListNode right = mergeSort(next);

        ListNode merge = merge(left, right);
        return merge;

    }

    //归并，返回合并后的链表的头节点
    //左边待合并链表和右边待合并链表分别都已经有序
    //需要把两个链表进行合并
    public static ListNode merge(ListNode left, ListNode right) {
        ListNode nullNode = new ListNode(-1); // 空结点作为头节点
        ListNode curr = nullNode;
        while (left != null && right != null) {
            if (left.val < right.val) {
                curr.next = left; //加入排序链表
                left = left.next; //指针后移
            } else {
                curr.next = right;
                right = right.next;
            }
            curr = curr.next;//链表指针后移
        }

        //多余的一定都是有序的，利用链表特性，直接把排序链表的后续结点和待合并链表的头节点相连即可
        if (left != null) {
            curr.next = left;
        }
        if (right != null) {
            curr.next = right;
        }
        return nullNode.next;
    }

    /**
     * 归并排序（迭代）
     */
    //计算链表长度
    public static int calculate(ListNode head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }

    //切割前n个结点，并返回后半部分的头节点
    public static ListNode cut(ListNode head, int step) {
        ListNode p = head;
        //这里走到最后一步，p指向的是当前归到左边的最后一个结点
        for (int i = 1; i < step && p != null; i++) {
            p = p.next;
        }
        //说明没满足切割长度，那右边直接是空的，直接返回空结点
        if (p == null) {
            return null;
        }
        //不是空的，先记录下下个结点(右部的头节点)
        ListNode next = p.next;
        p.next = null;//切断左边
        return next; //返回右节点
    }

    //循环切割+合并
    public static ListNode mergeSort2(ListNode head) {
        ListNode p = head;
        int length = calculate(p);

        ListNode nullNode = new ListNode(-1);
        nullNode.next = head;
        for (int step = 1; step < length; step = step * 2) {
            ListNode cur = nullNode.next;
            ListNode tail = nullNode;
            while (cur != null) {
                ListNode left = cur;
                ListNode right = cut(cur, step);
                cur = cut(right, step);//剩下还没有切分的

                //合并,利用尾指针把断开的两节连起来
                tail.next = merge(left, right);
                //同时移动尾指针到链表末尾
                while (tail.next != null) {
                    tail = tail.next;
                }
            }
        }
        return nullNode.next;
    }


    /**
     * 把链表转为数组，进行排序后再加入链表中
     *
     * @param head
     * @return
     */
    public ListNode sortList2(ListNode head) {
        if (head == null) {
            return null;
        }
        ArrayList<Integer> list = new ArrayList<>(); //把链表转为数组集合
        while (head.next != null) {
            list.add(head.val);
            head = head.next;
        }
        //把最后一个结点的纸加进list
        list.add(head.val);

        //直接排序
        list.sort((o1, o2) -> o1 - o2);
        ListNode[] listNodes = new ListNode[list.size()]; //一个对象数组
        for (int i = 0; i < list.size(); i++) {
            listNodes[i] = new ListNode(list.get(i));
        }
        for (int i = 0; i < list.size() - 1; i++) {
            listNodes[i].next = listNodes[i + 1];
        }
        return listNodes[0];
    }
}