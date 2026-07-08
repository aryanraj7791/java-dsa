import java.util.*;

public class InterleaveTwoHalves{
    public static void interleave(Queue<Integer> queue){
        Queue<Integer> second = new LinkedList<>();
        int size = queue.size();
        for(int i=1; i<=size/2; i++){
            second.add(queue.remove());
        }
        while(!second.isEmpty()){
            queue.add(second.remove());
            queue.add(queue.remove());
        }
    }
    public static void main(String[] args){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        queue.add(6);
        // queue.add(7);
        // queue.add(8);
        // queue.add(9);
        // queue.add(10);

        interleave(queue);

        while(!queue.isEmpty()){
            System.out.print(queue.peek()+" ");
            queue.remove();
        }
    }
}