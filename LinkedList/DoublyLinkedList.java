import java.util.*;

public class DoublyLinkedList{

    public static class Node{
        int data;
        Node next;
        Node prev;
        public Node(int data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    public void printDLL(){
        Node temp = head;
        if(head == null){
            System.out.print("Linked List is empty!");
            return;
        }
        System.out.print("null<--");
        while(temp != null){
            if(temp.next != null){
                System.out.print(temp.data+"<-->");
            }
            else{
                System.out.print(temp.data+"-->");
            }
            temp = temp.next;
        }
        System.out.println("null");
    }

    //add
    public void addFirst(int data){
        Node newNode = new Node(data);
        size++;
        if(head == null){
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    public void addLast(int data){
        Node newNode = new Node(data);
        size++;
        if(head == null){
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

    //remove
    public void removeFirst(){
        if(head == null){
            System.out.print("Linked list is empty!");
            return;
        }
        if(size == 1){
            head = tail = null;
            size--;
            return;
        }
        size--;
        head = head.next;
        head.prev = null;
    }

    public void removeLast(){
        if(head == null){
            System.out.print("Linked list is empty!");
            return;
        }
        if(size == 1){
            head = tail = null;
            size--;
            return;
        }
        size--;
        tail = tail.prev;
        tail.next = null;
    }

    //Reverse a doubly linked list
    public void reverseDLL(){
        Node prev = null;
        Node curr = head;
        Node next;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            curr.prev = next;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    public static void main(String[] args){
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.addFirst(5);
        dll.addFirst(4);
        dll.addFirst(3);
        dll.addFirst(2);
        dll.addFirst(1);
        // dll.removeLast();
        // dll.removeFirst();
        dll.printDLL();
        dll.reverseDLL();
        dll.printDLL();
        System.out.print(size);
    }
}