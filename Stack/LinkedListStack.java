import java.util.*;

public class LinkedListStack{
    public static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }
        static Node head = null;
        //Empty check
        public boolean isEmpty(){
        return head == null;
    }
       //push
       public void push(int data){
        Node newNode = new Node(data);
        if(isEmpty()){
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }
       //pop
       public int pop(){
        if(isEmpty()){
            System.out.println("Stack is empty!");
            return -1;
        }
        int top = head.data;
        head = head.next;
        return top;
    }
       //peek
       public int peek(){
        if(isEmpty()){
            System.out.println("Stack is empty!");
            return -1;
        }
        return head.data;
    }

    public void pushAtBottom(int data){
        Node newNode = new Node(data);
        Node ptr = head;
        while(ptr.next != null){
            ptr = ptr.next;
        }
        ptr.next = newNode;
    }

    public static void main(String[] args){
        LinkedListStack llS = new LinkedListStack();
        llS.push(1);
        llS.push(2);
        llS.push(3);
        llS.push(4);
        llS.push(5);
        llS.pushAtBottom(7);
        while(!llS.isEmpty()){
            System.out.println(llS.peek());
            llS.pop();
        }
        System.out.println(llS.pop());
    }
}