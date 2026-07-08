import java.util.*;

public class LowerCaseVowels{

    public static int countVowels(String str){
        int count=0;
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) == 'a' || str.charAt(i) == 'e' || str.charAt(i) == 'i' || str.charAt(i) == 'o' || str.charAt(i) == 'u') count++;
        }
        return count;
    }

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = scn.nextLine();
        int ans = countVowels(str);
        System.out.print("Number of lowercase vowels in " + str + " is: " + ans);
    }
}