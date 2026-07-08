import java.util.LinkedList;

public class JavaCollectionsFramework{
    public static void main(String[] args){
        LinkedList<Integer> ll = new LinkedList<>();
        ll.addFirst(3);
        ll.addFirst(5);
        ll.addFirst(1);
        ll.addFirst(7);
        ll.removeLast();
        System.out.print(ll);
    }
}