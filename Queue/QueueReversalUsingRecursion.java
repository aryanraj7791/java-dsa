import java.util.*;

public class QueueReversalUsingRecursion{
    public static void queueReversal(Queue<Integer> q){
        ///Basecase
        if(q.isEmpty()){
            return;
        }
        //Recursion
        int val = q.remove();
        queueReversal(q);
        q.add(val); //Backtrack
    }
    public static void main(String[] args){
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        queueReversal(q);
        while(!q.isEmpty()){
            System.out.print(q.remove()+" ");
        }
    }
}