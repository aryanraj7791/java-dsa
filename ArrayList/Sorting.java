import java.util.ArrayList;
import java.util.Collections;


public class Sorting{
    public static void main(String[] args){
        ArrayList<Integer> list = new ArrayList<>(10);
        list.add(2); 
        list.add(5);
        list.add(9);
        list.add(3);
        list.add(6);

        Collections.sort(list);
        System.out.println(list);

        //Descending
        Collections.sort(list, Collections.reverseOrder());
        //Comparator-fnx Logic--> Collections.reverseOrder()
        System.out.println(list);
    }
}