package org.example;

// Linked list operations in Java
/*
* Task 1. Write Implementation of LinkedList (without using Java LinkedList ready library),
* it stores int type of data and you have to write 3 methods:
* add, add at some index, delete at some index, get at some index.
1.1) Think about complexity of methods for: add, delete, get by index ( O(?) )
*/

class LinkedList {
    Node head;

    class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    public void add(int newData) {
        Node newNode = new Node(newData);

        if (head == null) {
            head = new Node(newData);
            return;
        }

        newNode.next = null;

        Node last = head;
        while (last.next != null)
            last = last.next;

        last.next = newNode;
    }

    void addNodeAtPosition(int newData, int position) {
        if (head == null) {
            return;
        }

        Node temp = head;

        if (position == 0) {
            Node newNode = new Node(newData);
            newNode.next = head;
            head = newNode;
            return;
        }

        int i = 0;
        while (temp != null){
            if (position == i + 1){
                Node newNode = new Node(newData);
                newNode.next = temp.next;
                temp.next = newNode;
                System.out.println("\nYou added value!");
            }
            temp = temp.next;
            i++;
        }
    }

    void deleteNodeAtPosition(int position) {
        if (head == null)
            return;

        Node temp = head;

        if (position == 0) {
            head = temp.next;
            return;
        }
        for (int i = 0; temp != null && i < position - 1; i++)
            temp = temp.next;

        if (temp == null || temp.next == null)
            return;

        Node next = temp.next.next;
        temp.next = next;
    }

    public void searchNodeAtPosition(Node head, int position) {
        if (head == null)
            return;
        Node temp = head;

        int i = 0;
        while (temp != null && i <= position){
            if (position == i){
                System.out.println("\nYour searched value is: " + temp.data);
            }
            temp = temp.next;
            i++;
        }
    }

    public void printList() {
        Node node = head;
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.add(1);
        list.add(4);
        list.add(15);
        list.add(29);
        list.add(34);

        System.out.println("List before: ");
        list.printList();
        System.out.println("\nList after deleting an element: ");
        list.deleteNodeAtPosition(0);
        list.printList();
        list.searchNodeAtPosition(list.head, 0);
        list.addNodeAtPosition(10, 0);
        list.printList();
    }
}