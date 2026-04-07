import java.util.Stack;

/**
 * Demonstrates reversing a singly linked list using an auxiliary stack.
 */
public class ReverseLinkedListStack {

    /** Simple singly linked list node. */
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    /**
     * Reverse the list by pushing all values to a stack, then popping back into the list.
     * Time: O(n), Extra space: O(n) for the stack.
     */
    static Node reverse(Node head) {
        if (head == null) return null;

        Stack<Integer> stack = new Stack<>();
        for (Node cur = head; cur != null; cur = cur.next) {
            stack.push(cur.data);
        }

        for (Node cur = head; cur != null; cur = cur.next) {
            cur.data = stack.pop();
        }
        return head;
    }

    static void print(Node head) {
        for (Node cur = head; cur != null; cur = cur.next) {
            System.out.print(cur.data + (cur.next != null ? " -> " : ""));
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);

        System.out.print("Original: ");
        print(head);

        head = reverse(head);

        System.out.print("Reversed: ");
        print(head);
    }
}
