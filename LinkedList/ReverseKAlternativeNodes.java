package com.LinkedList;

import java.util.*;
import java.lang.*;
public class ReverseKAlternativeNodes {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Test cases :");
        int T = scan.nextInt();
        while(T>0) {
            LinkedList<Integer> integerList = new LinkedList<>();
            System.out.println("Enter the linked list values :");
            while (scan.hasNextInt()) {
                integerList.insert(scan.nextInt());
            }
            scan.next();
            System.out.println("Enter the k value :");
            int k = scan.nextInt();
            //LinkedList.printList(reverseList(integerList.head, 5, null)[0]);
            Node reversed_head = reverseKAlternativeNodes(integerList.head, k);
            LinkedList.printList(reversed_head);
            T--;
        }
    }
    static <T> Node<T>[] reverseList(Node head, int k, Node end){
//        Node tmp_head = head;
//        Node stack_tail = end;
//        Node<T> stack_top = new Node(head.data);
//        tmp_head = tmp_head.next;
//        int count=1;
//        while(tmp_head!=null && count<k){
//                Node<T> new_node = new Node(tmp_head.data);
//                new_node.next = stack_top;
//                stack_top = new_node;
//                tmp_head = tmp_head.next;
//                count++;
//        }
//        Node[] return_nodes = {stack_top,stack_tail.next};
//        return return_nodes;
        Node curr = head, next , prev = end;
        int count= 0;
        while(count<k && curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }
        Node[] return_array = {prev, end};
        return return_array;
    }
    static Node reverseKAlternativeNodes(Node head, int k){ //1 2 3 4 5 6 7 8 9 n
        if(null == head)
            return head;
        Node itr = head;
//        LinkedList.printList(itr);
        int count = 1;
        Node tmp_head = head;
        while(itr!=null) {
            //System.out.println("count = "+count+" iter ="+ itr.data);
            if (count % k == 0 && count / k % 2 != 0) {

                if (count / k == 1) {
                    //System.out.println("inside if");
                    Node[] returnedNodes = reverseList(head, k, itr.next);
                    head = returnedNodes[0];
                    itr = returnedNodes[1];
                    count++;
//                    System.out.println(returnedNodes[0].data);
//                    System.out.println(returnedNodes[1].data);
                }
                else {
                    //System.out.println("inside else");
                    Node[] returnedNodes = reverseList(tmp_head.next, k, itr.next);
//                    System.out.println(returnedNodes[0].data);
//                    System.out.println(returnedNodes[1]);
                    tmp_head.next = returnedNodes[0];
                    count++;
                    itr = returnedNodes[1];
                }
            }
            else {
                if (count % k == 0 && count / k % 2 == 0) {
                    tmp_head = itr;
                    //System.out.println("Inside temp change tmp_head = " + tmp_head.data);
                }
                itr = itr.next;
                count++;
            }
        }
        return head;
    }
}
