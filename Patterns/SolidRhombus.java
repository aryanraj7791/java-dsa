import java.util.*;

public class SolidRhombus{
    public static void main(String args[]){
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter size of rhombus: ");
        int n = scn.nextInt();
        for(int i=1; i<=n; i++){
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
    }
}