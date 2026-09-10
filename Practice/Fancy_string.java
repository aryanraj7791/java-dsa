import java.util.*;
import java.io.*;

class Fancy_string {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static StringTokenizer st;

    static String next() throws IOException {

        while(st == null || !st.hasMoreTokens()){
            st = new StringTokenizer(br.readLine());
        }

        return st.nextToken();

    }

    public static String fancyString(String s){

        int n = s.length();

        StringBuilder sb = new StringBuilder();

        int i = 0;
        int j = 1;

        while(j < n){

            if(s.charAt(i) == s.charAt(j)){

                j++;

            }
            else{

                sb.append(s.charAt(i));

                if(j - i > 1){

                    sb.append(s.charAt(i+1));

                    i = j;

                }
                else{

                    i++;
                    j++;

                }

            }

        }

        sb.append(s.charAt(i));

        if(j - i > 1){

            sb.append(s.charAt(i));

        }

        return sb.toString();

    }

    public static void main(String[] args) throws java.lang.Exception{

        System.out.print("Enter string: ");
        String s = next();

        String str = fancyString(s);

        System.out.println("Fancy string is: " + str);

    }

}