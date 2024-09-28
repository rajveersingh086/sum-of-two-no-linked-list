package geeks.linkedlist;

import java.util.Scanner;

//Flipkart Morgan Stanley Accolite Amazon Microsoft snapdeal MakeMyTrip Qualcomm.

class Node {
    int data;
    Node next;
    Node(int d) {
        data = d;
        next = null;
    }
}

class addnumberSll {
    static Node addTwoLists(Node num1, Node num2) {
        num1 = reverse(num1);
        num2 = reverse(num2);

        Node head = null;
        Node temp = null;
        int carry = 0;

        while (num1 != null || num2 != null) {
            int sum = carry;
            if (num1 != null) {
                sum += num1.data;
                num1 = num1.next;
            }
            if (num2 != null) {
                sum += num2.data;
                num2 = num2.next;
            }
            carry = sum / 10;
            sum = sum % 10;

            Node newNode = new Node(sum);
            if (head == null) {
                head = newNode;
            } else {
                temp.next = newNode;
            }
            temp = newNode;
        }

        if (carry > 0) {
            temp.next = new Node(carry);
        }

        return reverse(head);
    }

    static Node reverse(Node head) {
        Node prev = null;
        Node curr = head;
        Node next = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
    static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

    static Node insertEnd(Node head, int data) {
        Node newNode = new Node(data);
        if (head == null) {
            return newNode;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        return head;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        Node num1 = null;
        Node num2 = null;

        // Input for the first number
        System.out.println("Enter the number of digits in the first number:");
        int n1 = sc.nextInt();
        System.out.println("Enter the digits for the first number:");
        for (int i = 0; i < n1; i++) {
            num1 = insertEnd(num1, sc.nextInt());
        }

        // Input for the second number
        System.out.println("Enter the number of digits in the second number:");
        int n2 = sc.nextInt();
        System.out.println("Enter the digits for the second number:");
        for (int i = 0; i < n2; i++) {
            num2 = insertEnd(num2, sc.nextInt());
        }
        // Add the two numbers
        Node result = addTwoLists(num1, num2);

        System.out.println("The sum is:");
        printList(result);

        sc.close();
    }
}

