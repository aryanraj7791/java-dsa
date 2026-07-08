import java.util.*;

public class AddOneToInteger{

    public static int addOne(int n){
        int mask = 1;
        while((n & mask) != 0){
            n = (~mask) & n ;
           mask = mask<<1;
        }
        return n = n ^ mask;
    }

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = scn.nextInt();
        System.out.print("After adding 1 : " + addOne(n));
    }
}