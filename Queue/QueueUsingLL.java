import java.util.*;

public class QueueUsingLL{
    public static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public static class Queue{
        public static Node head=null;
        public static Node tail=null;
        public static int size=0;
        //isEmpty
        public boolean isEmpty(){
            return head == null && tail == null;
        }
        //Add
        public void add(int data){
            Node newNode = new Node(data);
            size++;
            if(isEmpty()){
                head = tail = newNode;
                return;
            }
            tail.next = newNode;
            tail = newNode;
        }
        //remove
        public int remove(){
            if(isEmpty()){
                System.out.println("Queue is empty!");
                return -1;
            }
            int remove = head.data;
            if(head == tail){
                head = tail = null;
            }else{
                head = head.next;
            }
            size--;
            return remove;
        }
        //peek
        public int peek(){
            if(isEmpty()){
                System.out.print("Queue is empty!");
                return -1;
            }
            return head.data;
        }
        //print
        public void print(){
            Node ptr = head;
            while(ptr != null){
                System.out.println(ptr.data);
                ptr = ptr.next;
            }
        }
    }
    public static void main(String[] args){
        Queue q = new Queue();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        q.add(7);
        q.print();
        System.out.println("Size is : "+q.size);
        q.remove(); 
        q.remove();
        q.remove();
        q.print();
        System.out.println("Size is : "+q.size);
    }
}