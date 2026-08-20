import java.util.*;
import java.io.*;

class Valid_parenthesis_string {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static StringTokenizer st;

    static String next() throws IOException {

        while(st == null || !st.hasMoreTokens()){
            st = new StringTokenizer(br.readLine());
        }

        return st.nextToken();

    }

    public static boolean isValid(String s){

        int n = s.length();

        int minBalance = 0;
        int maxBalance = 0;

        for(int i=0; i<n; i++){

            if(s.charAt(i) == '('){
                minBalance++;
                maxBalance++;
            }
            else if(s.charAt(i) == ')'){
                minBalance--;
                maxBalance--;
                if(maxBalance < 0) return false;
            }
            else{
                minBalance--;
                maxBalance++;
            }

            minBalance = Math.max(minBalance, 0);
        }

        return minBalance == 0;

    }

    public static void main(String[] args) throws java.lang.Exception {

        System.out.print("Enter string containing('(', ')' or '*'): ");
        String s = next();

        if(isValid(s)) System.out.println(s + " is a valid parenthesis string.");
        else System.out.println(s + " is not a valid parenthesis string.");

    }

}