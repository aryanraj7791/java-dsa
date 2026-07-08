import java.util.*;

public class StringCompression{

    public static String stringCompress(String str){
        StringBuilder sb = new StringBuilder("");
        for(int i=0; i<str.length(); i++){
            Integer count=1;
            while(i<str.length()-1 && str.charAt(i) == str.charAt(i+1)){
                count++;
                i++;
            }
            if(count>1){
                sb.append(str.charAt(i));
                sb.append(count.toString());
            }
            else{
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }


    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = scn.next();
        String ans = stringCompress(str);
        System.out.print("Compressed string is: " + ans);
    }
}