import java.util.*;

public class Catalan_Num_Recursion{

    public static int catalan(int n){

        if(n == 0 || n == 1) return 1;

        int ans = 0;
        for(int i=0; i<n; i++){
            ans += catalan(i)*catalan(n-i-1);
        }

        return ans;
    }

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter n : ");
        int n = scn.nextInt();
        System.out.println("Catalan of " + n + " is : " + catalan(n));
    }
}