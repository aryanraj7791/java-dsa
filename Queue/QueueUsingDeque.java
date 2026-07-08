import java.util.*;

public class QueueUsingDeque{
    public static class Queue{
        Deque<Integer> dq = new LinkedList<>();
        //empty
        public boolean isEmpty(){
            return dq.isEmpty();
        }
        //add
        public void add(int data){
            dq.addLast(data);
        }
        //remove
        public int remove(){
            if(isEmpty()){
                System.out.println("Queue is empty!");
                return -1;
            }
            return dq.removeFirst();
        }
        //peek
        public int peek(){
            if(isEmpty()){
                System.out.println("Queue is empty!");
                return -1;
            }
            return dq.getFirst();
        }
    }
    public static void main(String[] args){
        Queue q = new Queue();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        System.out.println(q.peek());
        while(!q.isEmpty()){
            System.out.println(q.remove());
        }
        System.out.println(q.remove());
    }
}