import java.util.*;

public class ZigZagLinkedList{

    public static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    public void printLL(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data+"-->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public void addFirst(int data){
        Node newNode = new Node(data);
        size++;
        if(head == null){
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    public Node findMid(Node head){
        Node slow = head;
        Node fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next; //+1 step
            fast = fast.next.next; //+2 step
        }
        return slow;
    }

    public Node zigzagLL(Node head){
        //find mid
        Node mid = findMid(head);
        //reverse 2nd part of linked list
        Node prev = null;
        Node curr = mid.next;
        mid.next = null;
        Node next;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node leftHead = head;
        Node rightHead = prev;
        //Zig Zag LL code
        Node zigzagLL = new Node(-1);
        Node temp = zigzagLL;
        while(leftHead != null && rightHead != null){
            temp.next = leftHead;
            leftHead = leftHead.next;
            temp = temp.next;
            temp.next = rightHead;
            rightHead = rightHead.next;
            temp = temp.next;
        }
        while(leftHead != null){
            temp.next = leftHead;
            temp = temp.next;
            leftHead = leftHead.next;
        }
        return zigzagLL.next;
    }

    public static void main(String[] args){
        ZigZagLinkedList ll = new ZigZagLinkedList();
        ll.addFirst(7);
        ll.addFirst(6);
        ll.addFirst(5);
        ll.addFirst(4);
        ll.addFirst(3);
        ll.addFirst(2);
        ll.addFirst(1);
        ll.printLL();
        ll.head = ll.zigzagLL(ll.head);
        ll.printLL();
    }
}