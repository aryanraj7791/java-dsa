import java.util.*;

public class Deque1{
    public static void main(String[] args){
        Deque<Integer> dq = new LinkedList<>();
        dq.addFirst(1);
        dq.addFirst(2);
        dq.addFirst(3);
        dq.addFirst(4);
        dq.addFirst(5);
        System.out.println(dq);
    }
}