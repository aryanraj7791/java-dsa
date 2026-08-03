import java.util.*;

// A number 'n' is called bleak if it cannot be represented in the form of (x + setBitsInX(x)) == n where 0 <= x <=n

class Bleak_numbers {
    
    public static int countSetBits(int x){
        int temp = 1;
        int count = 0;
        while(temp <= x){
            if((temp & x) != 0) count++;
            temp <<= 1;
        }
        return count;
    }
    
    public static boolean isBleak(int n) {
        // Code here
        for(int i=n-30; i<=n; i++){
            if(i + countSetBits(i) == n) return false;
        }
        
        return true;
    }

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter n : ");
        int n = scn.nextInt();
        
        if(isBleak(n)){
            System.out.println(n + " is a bleak number.");
        }
        else{
            System.out.println(n + " is not a bleak number.");
        }
    }
}