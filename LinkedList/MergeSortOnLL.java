import java.util.*;

public class MergeSortOnLL{

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
    public static int sizeLL;

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
        sizeLL++;
        if(sizeLL == 0){
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    public Node mergeSort(Node head){
        if(head == null || head.next == null){
            return head;
        }
        //Find mid
        Node slow = head;
        Node fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        Node rightHead = slow.next;
        slow.next = null;
        Node leftHead = head;
        //mergeSort on left and right part of linked list
        Node leftSort = mergeSort(leftHead); //sort left part
        Node rigthSort = mergeSort(rightHead); //sort right part
        return mergeLL(leftSort,rigthSort); //Merge both left and right part
    }

    public Node mergeLL(Node leftHead, Node rightHead){
        Node mergedLL = new Node(-1);
        Node temp = mergedLL;
        Node tempLeft = leftHead;
        Node tempRight = rightHead;
        while(tempLeft != null && tempRight != null){
            if(tempLeft.data <= tempRight.data){
                temp.next = tempLeft;
                tempLeft = tempLeft.next;
            }
            else{
                temp.next = tempRight;
                tempRight = tempRight.next;
            }
            temp = temp.next;
        }
        while(tempLeft != null){
            temp.next = tempLeft;
            tempLeft = tempLeft.next;
            temp = temp.next;
        }
        while(tempRight != null){
            temp.next = tempRight;
            tempRight = tempRight.next;
            temp = temp.next;
        }
        return mergedLL.next;
    }

    public static void main(String[] args){
        MergeSortOnLL ll = new MergeSortOnLL();
        ll.addFirst(5);
        ll.addFirst(1);
        ll.addFirst(8);
        ll.addFirst(3);
        ll.addFirst(2);
        ll.addFirst(9);
        ll.addFirst(7);
        ll.printLL();
        ll.head = ll.mergeSort(ll.head);
        ll.printLL();
    }
}