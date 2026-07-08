import java.util.*;

public class Palindrome{

    //Strings are IMMUTABLE

    public static boolean palindromeCheck(String str){
        int low = 0;
        int high = str.length()-1;
        while(low<=high){
            if(str.charAt(low) != str.charAt(high)){
                //Not a palindrome
                return false;
            }
            low++;
            high--;
        }
        return true;
    }

    public static void main(String args[]){
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter string: ");
        String str = scn.nextLine();
        if(palindromeCheck(str)){
            System.out.print("Yes, " + str + " is a palindrome.");
        }
        else{
            System.out.print("No, " + str + " is not a palindrome.");
        }
    }
}