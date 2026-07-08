import java.util.ArrayList;
import java.util.Scanner;

public class MaximumElement{
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        list.add(2); 
        list.add(5);
        list.add(9);
        list.add(3);
        list.add(6);

        System.out.print("Enter 1st index: ");
        int idx1 = scn.nextInt();
        System.out.print("Enter 2nd index: ");
        int idx2 = scn.nextInt();

        System.out.println("Before swapping:");
        System.out.println(list);

        int temp = list.get(idx1);
        list.set(idx1,list.get(idx2));
        list.set(idx2,temp);

        System.out.println("After swapping:");
        System.out.println(list);
    }
}