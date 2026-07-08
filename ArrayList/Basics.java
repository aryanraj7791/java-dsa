import java.util.ArrayList;

public class Basics{
    public static void main(String[] args){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1); //Time complexity = O(1)
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        list.remove(3); //Time complexity = O(n)
        list.set(0,7); //Time complexity = O(n)
        int get = list.get(0); //Time complexity = O(1)

        System.out.println(list);
    }
}