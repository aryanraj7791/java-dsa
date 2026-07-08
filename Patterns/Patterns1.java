import java.util.*;

public class Patterns1{
    public static void main(String args[]){
        Scanner scn = new Scanner(System.in);
        // System.out.print("Enter number of rows: ");
        // int n = scn.nextInt();
        // for(int i=1; i<=n; i++){
        //     for(int j=1; j<=i; j++){
        //         System.out.print(j + " ");
        //     }
        //     System.out.println();
        // }

        //Character pattern
        // int count=65;
        // for(int i=1; i<=n; i++){
        //     for(int j=1; j<=i; j++){
        //         System.out.print((char) (count) + " ");
        //         count++;
        //     }
        //     System.out.println();
        // }

        //Hollow Pattern
        System.out.print("Enter number of rows: ");
        int p = scn.nextInt();
        System.out.print("Enter number of columns: ");
        int q = scn.nextInt();

        for(int i=0; i<p; i++){
            for(int j=0; j<q; j++){
                if(i == 0 || i == p-1 || j == 0 || j == q-1){
                    System.out.print("* ");
                }
                else{
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
}