class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class IntersectionOfTwoSortedLinkedLists {

    public static void main(String[] args) {
        // Example 1:
        // List 1: 1 -> 2 -> 3 -> 4 -> 6
        // List 2: 2 -> 4 -> 6 -> 8
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);
        head1.next.next.next.next = new ListNode(6);

        ListNode head2 = new ListNode(2);
        head2.next = new ListNode(4);
        head2.next.next = new ListNode(6);
        head2.next.next.next = new ListNode(8);

        ListNode intersection = findIntersection(head1, head2);

        // Print the intersection list
        System.out.print("Intersection of the two lists: ");
        while (intersection != null) {
            System.out.print(intersection.val + " ");
            intersection = intersection.next;
        }
        System.out.println();
    }

    public static ListNode findIntersection(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while (head1 != null && head2 != null) {
            if (head1.val == head2.val) {
                // Add the common node to the intersection list
                tail.next = new ListNode(head1.val);
                tail = tail.next;
                head1 = head1.next;
                head2 = head2.next;
            } else if (head1.val < head2.val) {
                head1 = head1.next; // Move head1 forward
            } else {
                head2 = head2.next; // Move head2 forward
            }
        }

        return dummy.next; // Return the intersection list starting from dummy.next
    }
}
