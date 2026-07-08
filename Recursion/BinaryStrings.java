import java.util.*;

public class BinaryStrings{

    public static void printBinary(int n, String str, int lastPlace){
        if(n == 0){
            System.out.println(str);
            return;
        }
        printBinary(n-1,str+"0",0);
        if(lastPlace == 0){
            printBinary(n-1,str+"1",1);
        }
    }

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter size of binary String: ");
        int n = scn.nextInt();
        printBinary(n,"",0);
    }
}