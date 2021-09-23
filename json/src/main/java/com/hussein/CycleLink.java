package com.hussein;

/**
 * <p>Title: CycleLink</p>
 * <p>Description: </p>
 * <p>Company: www.hussein.com</p>
 *
 * @author hwangsy
 * @date 2021/9/23 8:43 PM
 */
public class CycleLink {

    public static void main(String[] args) {
        //1,2,3,4,5,6,1
        Node head = new Node(1, null);
        head.next = new Node(2, null);
        head.next.next = new Node(3, null);
        head.next.next.next = new Node(4, null);
        head.next.next.next.next = new Node(5, null);
        head.next.next.next.next.next = new Node(6, null);
        head.next.next.next.next.next.next = head.next.next.next;
        Node cycleNode = getCycleNode(head);
        System.out.println(cycleNode);
    }

    private static Node getCycleNode(Node head) {
        if (head == null || head.next == null) {
            return null;
        }
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                Node n = head;
                while (n != slow) {
                    n = n.next;
                    slow = slow.next;
                }
                return n;
            }
        }
        return null;
    }

    public static class Node {

        public int value;

        public Node next;

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    '}';
        }
    }

}
