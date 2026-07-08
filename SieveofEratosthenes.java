import java.util.*;

public class SieveofEratosthenes{

    
    public static boolean[] sieve(int n){
        boolean[] isPrime = new boolean[n+1];
        Arrays.fill(isPrime,true);
        isPrime[0] = false;
        isPrime[1] = false;
        for(int i=2; i*i<=n; i++){
            if(isPrime[i]){
                for(int p = i*i; p<=n; p += i){
                    isPrime[p] = false;
                }
            }
        }
        return isPrime;
    }

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter a number : ");
        int n = scn.nextInt();
        boolean[] ans = sieve(n);
        for(int i=0; i<ans.length; i++){
            if(ans[i] == true) System.out.print(i+" ");
        }
    }
}