package com.zjh.medium;

import java.util.LinkedList;
import java.util.Queue;

public class AddTwoNumbers2 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        //l2.next.next.next = new ListNode(9);

        ListNode head = addTwoNumbers(l1, l2);
        while (head != null) {
            System.out.print(head.val + "  ");
            head = head.next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Queue<Integer> queue1= new LinkedList<>();
        Queue<Integer> queue2 = new LinkedList<>();
        int num = 0;
        ListNode head = null;
        while (l1 != null) {
            queue1.offer(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            queue2.offer(l2.val);
            l2 = l2.next;
        }

        int add;
        ListNode temp = null;
        while(!queue1.isEmpty() && !queue2.isEmpty()) {
            add = queue1.poll() + queue2.poll() + num;

            if (temp == null) {
                temp = new ListNode(add % 10);
                head = temp;
            } else {
                temp.next = new ListNode(add % 10);
                temp = temp.next;
            }

            num = add / 10;
        }

        while (!queue1.isEmpty()) {
            add = queue1.poll() + num;

            temp.next = new ListNode(add % 10);
            temp = temp.next;

            num = add / 10;
        }

        while (!queue2.isEmpty()) {
            add = queue2.poll() + num;

            temp.next = new ListNode(add % 10);
            temp = temp.next;

            num = add / 10;
        }

        if (num != 0) {
            temp.next = new ListNode(num);
        }

        return head;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}