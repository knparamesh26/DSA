package com.LinkedList;

import java.util.*;

public class ReverseALinkedList {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList();
        Scanner scan = new Scanner(System.in);
        while (scan.hasNextInt()) {
            linkedList.insert(scan.nextInt());
        }

        linkedList.printList(linkedList.head);
        Node rev_head = reverseList(linkedList.head);
        linkedList.printList(rev_head);

    }
    static Node reverseList(Node head){
        Node prev = null, next= null;
        Node curr = head;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
