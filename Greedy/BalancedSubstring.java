import java.util.*;

public class BalancedSubstring{
    public static int maxSubsets(String str){
        int maxCount=0;
        int n = str.length();
        int x = 2;
        while(n > 0){
            maxCount++;
            n -= x;
            x += 2;
        }
        return maxCount;
    }
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter a balanced string of L and R's : ");
        String str = scn.next();
        System.out.println("Maximum subsets : " + maxSubsets(str));
    }
}