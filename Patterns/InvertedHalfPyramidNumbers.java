import java.util.*;

public class InvertedHalfPyramidNumbers{
    public static void main(String args[]){
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = scn.nextInt();
        for(int i=1; i<=n; i++){
            //printing numbers
            for(int j=1; j<=n-i+1; j++){
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}