import java.util.*;

public class SearchInLL{

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

    public void printLL(){
        if(sizeLL == 0){
            System.out.print("Linked List is empty!");
            return;
        }
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
            newNode.next = null;
            head = tail = newNode;
        }
        else{
            newNode.next = head;
            head = newNode;
        }
    }

    public int searchInLL(SearchInLL ll, int key){
        Node temp = head;
        int idx=0;
        while(temp != null){
            if(temp.data == key){
                return idx;
            }
            temp=temp.next;
            idx++;
        }
        return -1;
    }

    public void recursiveSearch(int key, int idx, Node head){
        //Basecase
        if(head == null){
            System.out.print("Key not found!");
            return;
        }
        if(head.data == key){
            System.out.print("Key found at index : " + idx);
            return;
        }

        //Recursion
        head=head.next;
        idx++;
        recursiveSearch(key,idx,head);
    }

    public void reverseLL(){
        Node prev = null;
        Node curr = tail = head;
        Node next;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    public void deleteNthFromEnd(int n){
        int size = 0;
        Node temp = head;
        while(temp != null){
            size++;
            temp = temp.next;
        }
        if(n == size){
            head = head.next;
            sizeLL--;
            return;
        }
        int x = 1;
        Node prevNode = head;
        while(x != (size-n)){
            prevNode = prevNode.next;
            x++;
        }
        prevNode.next = prevNode.next.next;
        sizeLL--;
    }

    //slow-fast approach for finding mid in linked list
    public Node findMid(){
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next; //+1 jump
            fast = fast.next.next; //+2 jump
        }
        return slow;
    }

    //Function to check for palindrome
    public void isPalindrome(){
        if(head == null || head.next == null){
            System.out.print("It is a palindrome!");
            return;
        }
        //Finding mid
        Node mid = findMid();
        //Reversing last half of linked list from mid to tail
        Node prev = null;
        Node curr = mid;
        Node next;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node right = prev;
        Node left = head;
        //check for palindrome by comparing each element of first half with last half
        while(right != null){
            if(left.data != right.data){
                System.out.print("It is not a palindrome!");
                return;
            }
            left = left.next;
            right = right.next;
        }
        System.out.print("It is a palindrome!");
    }

    public boolean detectCycle(){
        //slow-fast approach/ Floyd's cycle finding algorithm
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next; //+1 pointer
            fast = fast.next.next; //+2 pointer
            if(slow == fast){ //cycle exists
                return true;
            }
        }
        return false; //cycle doesnot exists
    }

    public void removeCycle(){
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                slow = head;
                if(slow == fast){
                    while(fast.next != slow){
                        fast = fast.next;
                    }
                    fast.next = null;
                    return;
                }
                while(slow.next != fast.next){
                    slow = slow.next;
                    fast = fast.next;
                }
                fast.next = null;
                return;
            }
        }
    }

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        // System.out.print("Enter key to search in linked list : ");
        // int key = scn.nextInt();
        SearchInLL ll = new SearchInLL();
        // ll.addFirst(1);
        // ll.addFirst(2);
        // ll.addFirst(3);
        // ll.addFirst(3);
        // ll.addFirst(2);
        // ll.addFirst(1);
        // ll.printLL();
        // int ans = ll.searchInLL(ll,key);
        // if(ans >=0){
        //     System.out.print("Key found at index : " + ans);
        // }
        // else{
        //     System.out.print("Key not found!");
        // }
        // ll.recursiveSearch(key,0,head);
        // ll.reverseLL();
        // ll.deleteNthFromEnd(3);
        // ll.printLL();
        // ll.isPalindrome();
        head = new Node(1);
        sizeLL++;
        head.next = new Node(2);
        sizeLL++;
        head.next.next = new Node(3);
        sizeLL++;
        head.next.next.next = new Node(4);
        sizeLL++;
        head.next.next.next.next = head;
        System.out.println(ll.detectCycle());
        // ll.removeCycle();
        // ll.printLL();
        if(ll.detectCycle()){
            ll.removeCycle();
            ll.printLL();
            return;
        }
        System.out.println("Cycle doesnot exists!");
    }
}