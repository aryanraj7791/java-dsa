import java.util.*;

public class Test{

    public static boolean isPrime(int num){
        if(num<2) return false;
        for(int i=2; i*i <= num; i++){
            if(num % i == 0) return false;
        }
        return true;
    }

    public static void helper(int pos, int n, int m, int k, int[] prime, int[] composite, StringBuilder ans){
        if(pos>n){
            long val = Long.parseLong(ans.toString());
            if(val % m == k){
                System.out.println(val%100000007);
            }
            return;
        }

        int[] candidates = isPrime(pos) ? prime : composite;

        for(int d : candidates){
            if(pos == 1 && d == 0) continue;
            ans.append(d);
            helper(pos+1,n,m,k,prime,composite,ans);
            ans.deleteCharAt(ans.length()-1);
        }
    }

    public static void main(String[] args){

        int[] prime = {2,3,5,7};
        int[] composite = {0,1,4,6,8,9};

        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();

        while(t-- > 0){
            int n = scn.nextInt();
            int m = scn.nextInt();
            int k = scn.nextInt();
            helper(1,n,m,k,prime,composite,new StringBuilder(""));
        }
    }
}