import java.util.*;

public class ButterflyPattern{
    public static void main(String args[]){
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter number of rows: ");
        int n = scn.nextInt();
        if(n%2 == 0){
        int count=0,space=0;
        for(int i=1; i<=n; i++){
            if(i<=n/2){
                for(int j=1; j<=i; j++){
                    System.out.print("* ");
                }
                for(int j=1; j<=n-2*i; j++){
                    System.out.print("  ");
                }
                for(int j=1; j<=i; j++){
                    System.out.print("* ");
                }
                System.out.println();
            }
            else{
                for(int j=1; j<=n/2-count; j++){
                    System.out.print("* ");
                }
                for(int j=1; j<=2*space; j++){
                    System.out.print("  ");
                }
                for(int j=1; j<=n/2-count; j++){
                    System.out.print("* ");
                }
                System.out.println();
                count++;
                space++;
            }
        }
        }
        else{
            int count=0,space=1;
            for(int i=1; i<=n; i++){
            if(i<=n/2){
                for(int j=1; j<=i; j++){
                    System.out.print("* ");
                }
                for(int j=1; j<=n-2*i; j++){
                    System.out.print("  ");
                }
                for(int j=1; j<=i; j++){
                    System.out.print("* ");
                }
                System.out.println();
            }
            else if(i == n/2+1){
                 for(int j=1; j<=n; j++){
                    System.out.print("* ");
                }
                System.out.println();
            }
            else{
                for(int j=1; j<=n/2-count; j++){
                    System.out.print("* ");
                }
                for(int j=1; j<=space; j++){
                    System.out.print("  ");
                }
                for(int j=1; j<=n/2-count; j++){
                    System.out.print("* ");
                }
                System.out.println();
                count++;
                space += 2;
            }
        }
        }
    }
    }
