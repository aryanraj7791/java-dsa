import java.util.*;

public class PushBottom{
    public static void pushAtBottom(Stack<Integer> s, int data){
        //Basecase
        if(s.isEmpty()){
            s.push(data);
            return;
        }
        //Recursion
        int top = s.pop();
        pushAtBottom(s,data);
        s.push(top);//Backtracking
    }
    public static void main(String[] args){
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        pushAtBottom(s,7);
        while(!s.isEmpty()){
            System.out.println(s.peek());
            s.pop();
        }
    }
}