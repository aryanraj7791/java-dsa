import java.util.*;

public class LinkedList{

    public static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public static int sizeLL;
    public static Node head;
    public static Node tail;

    public void addLast(int data){ //O(1)
        Node newNode = new Node(data); //create new node
        sizeLL++;
        if(head == null){
            head = tail = newNode; //head and tail points to the new node since earlier linked list 'll' was vacant
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    public void printLinkedList(LinkedList ll){ //O(n)
        if(head == null){
            System.out.println("Linked List is empty!");
            return;
        }
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data+"-->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public void insertMiddle(int idx, LinkedList ll, int data){ //O(n)
        if(idx == 0){
            addFirst(data);
            return;
        }
        Node temp = head;
        int i=0;
        while(i < idx-1){
            temp = temp.next;
            i++;
        }
        Node newNode = new Node(data);
        sizeLL++;
        newNode.next = temp.next;
        temp.next = newNode;
    }

    public void removeFirst(){
        if(sizeLL == 0){
            System.out.println("Linked list is empty!");
            return;
        }
        else if(sizeLL == 1){
            head = tail = null;
            sizeLL = 0;
            return;
        }
        else{
        head = head.next;
        sizeLL--;
        return;
        }
    }

    public void removeLast(){
        if(sizeLL == 0){
            System.out.println("Linked List is empty!");
            return;
        }
        else if(sizeLL == 1){
            head = tail = null;
        }
        else{
        Node temp=head;
        while(temp.next != tail){
            temp=temp.next;
        }
        temp.next = null;
        tail = temp;
        }
        sizeLL--;
    }

    public void addFirst(int data){ //O(1)
        Node newNode = new Node(data); //create new node
        sizeLL++;
        if(head == null){
            head = tail = newNode; //head and tail points to the new node since earlier linked list 'll' was vacant
            return;
        }
        newNode.next = head; // new node points to the head(linking)
        head = newNode;
    }

    public static void main(String[] args){
       LinkedList ll = new LinkedList();
       ll.printLinkedList(ll);
       ll.addFirst(2);
       ll.printLinkedList(ll);
       ll.addFirst(1);
       ll.printLinkedList(ll);
       ll.addLast(3);
       ll.printLinkedList(ll);
       ll.addLast(4);
       ll.printLinkedList(ll);
       ll.addFirst(7);
       ll.printLinkedList(ll);
       ll.insertMiddle(2,ll,9);
       ll.printLinkedList(ll);
       ll.removeFirst();
       ll.printLinkedList(ll);
       ll.removeLast();
       ll.printLinkedList(ll);
       System.out.println("Size of linked list is : " + sizeLL);
    }
}