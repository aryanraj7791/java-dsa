import java.util.*;

public class StackUsingDeque{
    public static class Stack{
        Deque<Integer> dq = new LinkedList<>();
        //empty
        public boolean isEmpty(){
            return dq.isEmpty();
        }
        //push
        public void push(int data){
            dq.addLast(data);
        }
        //pop
        public int pop(){
            if(isEmpty()){
                System.out.println("Stack is empty");
                return -1;
            }
            return dq.removeLast();
        }
        //peek
        public int peek(){
            if(isEmpty()){
                System.out.println("Stack is empty");
                return -1;
            }
            return dq.getLast();
        }
    }
    public static void main(String[] args){
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        s.pop();
        while(!s.isEmpty()){
            System.out.println(s.pop());
        }
    }
}