package main.java.algos.array;

import java.util.Random;

/**
 * Reservoir Sampling
 * O(1) space, O(n) time
 *
 * What is reservoir sampling
 * https://www.youtube.com/watch?v=DWZqBN9efGg
 */
public class LinkedListRandomNode {
    private Random rand;
    private ListNode head;

    public static void main(String[] args) {
        ListNode head=new ListNode(1);
        head.next=new ListNode(2);
        head.next.next=new ListNode(3);
        LinkedListRandomNode randomNode=new LinkedListRandomNode(head);
        System.out.println(randomNode.getRandom());
        System.out.println(randomNode.getRandom());
        System.out.println(randomNode.getRandom());
    }

    /**
     * @param head The linked list's head.
     *             Note that the head is guaranteed to be not null, so it contains at least one node.
     */
    public LinkedListRandomNode(ListNode head) {
        this.head = head;
        rand = new Random();
    }

    /**
     * Returns a random node's value.
     */
    public int getRandom() {
        int result = -1;
        ListNode p = head;
        int count = 0;

        while (p != null) {
            count++;
            if (rand.nextInt(count) < 1) {
                result = p.val;
            }
            p = p.next;
        }
        return result;
    }


    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
