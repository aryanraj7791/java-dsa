import java.util.*;

public class DiamondPattern{
    public static void main(String args[]){
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter number of rows: ");
        int n = scn.nextInt();
        if(n%2 == 0){
            int st=0;
            for(int i=1; i<=n; i++){
                if(i == n/2 || i == n/2 + 1){
                    for(int j=1; j<=n-1; j++){
                        System.out.print("* ");
                    }
                    System.out.println();
                }
                else if(i<n/2){
                    //spaces
                    for(int j=1; j<=n/2-i; j++){
                        System.out.print("  ");
                    }
                    //stars
                    for(int j=1; j<=2*i-1; j++){
                        System.out.print("* ");
                    }
                    System.out.println();
                }
                else{
                    //spaces
                    for(int j=1; j<=i-n/2-1; j++){
                        System.out.print("  ");
                    }
                    //stars
                    for(int j=1; j<=n-3-2*st; j++){
                        System.out.print("* ");
                    }
                    st++;
                    System.out.println();
                }
            }
        }
        else{
            int st=0;
            for(int i=1; i<=n; i++){
                if(i == n/2+1){
                    for(int j=1; j<=n; j++){
                        System.out.print("* ");
                    }
                    System.out.println();
                }
                else if(i<=n/2){
                    for(int j=1; j<=n/2+1-i; j++){
                        System.out.print("  ");
                    }
                    for(int j=1; j<=2*i-1; j++){
                        System.out.print("* ");
                    }
                    System.out.println();
                }
                else{
                    for(int j=1; j<=i-n/2-1; j++){
                        System.out.print("  ");
                    }
                    for(int j=1; j<=n-2-2*st; j++){
                        System.out.print("* ");
                    }
                    st++;
                    System.out.println();
                }
            }
        }
    }
}