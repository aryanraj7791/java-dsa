import java.util.*;

public class ArrayListStack{
    ArrayList<Integer> list = new ArrayList<>();
    //isEmpty
    public boolean isEmpty(){
        return list.size() == 0;
    }
    //push
    public void push(int data){
        list.add(data);
    }
    //pop
    public int pop(){
        if(list.size() == 0){
            System.out.println("Stack is empty!");
            return -1;
        }
        int top = list.get(list.size()-1);
        list.remove(list.size()-1);
        return top;
    }
    //peek
    public int peek(){
        if(list.size() == 0){
            System.out.println("Stack is empty!");
            return -1;
        }
        return list.get(list.size()-1);
    }
    public static void main(String[] args){
        ArrayListStack s = new ArrayListStack();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        while(!s.isEmpty()){
            System.out.println(s.peek());
            System.out.println("Popped out : "+s.pop());
        }
        System.out.println(s.pop());
        System.out.println(s.peek());
    }
}