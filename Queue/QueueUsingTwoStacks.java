import java.util.*;

public class QueueUsingTwoStacks{
    public static class Queue{
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        //Empty
        public boolean isEmpty(){
            return s1.isEmpty(); //O(1)
        }
        //Add
        public void add(int data){ //o(n)
            //Empty s1 stack
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }

            s1.push(data);

            while(!s2.isEmpty()){
                s1.push(s2.pop());
            }
        }
        //remove
        public int remove(){ //O(1)
            if(isEmpty()){
                System.out.println("Queue is empty!");
                return -1;
            }
            return s1.pop();
        }
        //peek
        public int peek(){ //O(1)
            if(isEmpty()){
                System.out.println("Queue is empty!");
                return -1;
            }
            return s1.peek();
        }
    }
    public static void main(String[] args){
        Queue q = new Queue();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.remove();
        while(!q.isEmpty()){
            System.out.println(q.peek());
            q.remove();
        }
    }
}