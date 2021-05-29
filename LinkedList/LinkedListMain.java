package com.LinkedList;
import java.lang.*;
import java.util.*;

class Node<T> {
    T data;
    Node next;
    Node(T data){
        this.data = data;
        this.next = null;
    }
}

class LinkedList <T>{
    Node head = null;
    LinkedList(){}
    LinkedList(T data){
        head = new Node<T>(data);
    }
    <T> void insert(T data) {
        if (null == this.head) {
            this.head = new Node(data);
        }
        else {
            Node<T> traverse_head = this.head;
            while (traverse_head.next != null) {
                traverse_head = traverse_head.next;
            }
            traverse_head.next = new Node(data);
        }
    }
    static <T> void printList(Node head){
        Node tmp_head= head;
        while(tmp_head!=null){
            System.out.print(tmp_head.data+" ");
            tmp_head = tmp_head.next;
        }
        System.out.println();
    }
    static <T> void removeNode(Node removingNode){
        Node currNode = removingNode;
        T nextData;
        while(currNode.next.next!=null){
            System.out.println(currNode);
            nextData = (T)currNode.next.data;
            currNode.data = nextData;
            currNode = currNode.next;
        }
        currNode.data = currNode.next.data;
        currNode.next = null;
    }
}

public class LinkedListMain{
    public static void main(String[] args){

        LinkedList<Integer> integerList = new LinkedList();
//        integerList.insert(2);
//        integerList.insert(3);
//        integerList.insert(4);
//        integerList.insert(5);

        Scanner scan = new Scanner(System.in);
        while(scan.hasNextInt()){
            Integer n = scan.nextInt();
            System.out.println(n);
            integerList.insert(n);
        }
        integerList.printList(integerList.head);
        Node trav_head  = integerList.head;
        while(trav_head!=null && (Integer)trav_head.data != 5){
            trav_head = trav_head.next;
        }
        integerList.removeNode(trav_head);
        integerList.printList(integerList.head);
    }
}