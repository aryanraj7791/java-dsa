import java.util.*;

public class Patterns2{
    public static void main(String args[]){
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = scn.nextInt();
        for(int i=1; i<=2*n-1; i++){
            if(i<=n){
                for(int j=1; j<=i; j++){
                    System.out.print("* ");
                }
                System.out.println();
            }
            else{
                for(int k=1; k<=2*n-i; k++){
                    System.out.print("* ");
                }
                System.out.println();
            }
        }
    }
}