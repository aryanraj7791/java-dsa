import java.util.*;

public class LexSmallestString{ //a-1,b-2,c-3,d-4,e-5...........,z-26
    public static String smallestString(int n, int sum){
        StringBuilder sb = new StringBuilder("");
        while(n > 0){
            if(sum-n+1 > 26){
                sb.append((char)(97+25));
                sum -= 26;
                n--;
            }else{
                sb.append((char)(97+sum-n));
                n--;
                sum = n;
            }
        }
        sb.reverse();
        return sb.toString();
    }
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter size of string : ");
        int n = scn.nextInt();
        System.out.print("Enter sum : ");
        int sum = scn.nextInt();
        System.out.println("Lexicographically smallest string of size "+ n + " is : "+ smallestString(n,sum));
    }
}