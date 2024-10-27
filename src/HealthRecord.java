import java.util.Stack;

public class HealthRecord {
    boolean isHealthRecordSymmetric(SinglyLinkedList<Integer> input) {
        int n = input.size();
        if (n <= 1) {
            System.out.print("Not enough record to analyze! ");
            return false;
        }
        Node<Integer> cur = input.head;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n / 2; i++) {
            stack.push(cur.data);
            cur = cur.next;
        }
        if (n % 2 != 0)
            cur = cur.next;
        while (!stack.empty()) {
            if (stack.pop() != cur.data)
                return false;
            cur = cur.next;
        }
        return true;
    }

    public static void main(String[] args) {
        HealthRecord hr = new HealthRecord();
        SinglyLinkedList<Integer> input = new SinglyLinkedList<>();

        //An empty list
        System.out.println(hr.isHealthRecordSymmetric(input));

        //A list with only one record
        input.head = new Node<>(1);
        System.out.println(hr.isHealthRecordSymmetric(input));

        // An odd symmetrical linked list: 1 -> 2 -> 3 -> 2 -> 1
        input.head.next = new Node<>(2);
        input.head.next.next = new Node<>(3);
        input.head.next.next.next = new Node<>(2);
        input.head.next.next.next.next = new Node<>(1);

        System.out.println(hr.isHealthRecordSymmetric(input));

        // An odd non-symmetrical linked list: 1 -> 2 -> 3 -> 4 -> 5
        input.head = new Node<>(1);
        input.head.next = new Node<>(2);
        input.head.next.next = new Node<>(3);
        input.head.next.next.next = new Node<>(4);
        input.head.next.next.next.next = new Node<>(5);

        System.out.println(hr.isHealthRecordSymmetric(input));

        // An even symmetrical linked list: 1 -> 2 -> 3 -> 3 -> 2 -> 1
        input.head = new Node<>(1);
        input.head.next = new Node<>(2);
        input.head.next.next = new Node<>(3);
        input.head.next.next.next = new Node<>(3);
        input.head.next.next.next.next = new Node<>(2);
        input.head.next.next.next.next.next = new Node<>(1);

        System.out.println(hr.isHealthRecordSymmetric(input));

        // An even symmetrical linked list: 1 -> 2 -> 3 -> 2 -> 3 -> 1
        input.head = new Node<>(1);
        input.head.next = new Node<>(2);
        input.head.next.next = new Node<>(3);
        input.head.next.next.next = new Node<>(2);
        input.head.next.next.next.next = new Node<>(3);
        input.head.next.next.next.next.next = new Node<>(1);

        System.out.println(hr.isHealthRecordSymmetric(input));
    }
}
