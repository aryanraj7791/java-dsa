import java.util.*;

public class HollowRhombus{
    public static void main(String args[]){
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter size of rhombus: ");
        int n = scn.nextInt();
        for(int i=1; i<=n; i++){
          if(i == 1){
            //spaces
            for(int j=1; j<=n-i; j++){
                System.out.print("  ");
            }
            //stars
            for(int j=1; j<=n; j++){
                System.out.print("* ");
            }
            System.out.println();
          }
          else if(i == n){
            //stars
            for(int j=1; j<=n; j++){
                System.out.print("* ");
            }
            System.out.println();
          }
          else{
            //spaces
            for(int j=1; j<=n-i; j++){
               System.out.print("  ");
            }
            //stars
            System.out.print("* ");
            //spaces
            for(int j=1; j<=n-2; j++){
                System.out.print("  ");
            }
            //stars
            System.out.print("* ");
            System.out.println();
          }
        }
    }
}