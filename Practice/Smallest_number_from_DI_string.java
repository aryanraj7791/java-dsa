import java.util.*;
import java.io.*;

class Smallest_number_from_DI_string {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static StringTokenizer st;

    static String next() throws IOException {

        while(st == null || !st.hasMoreTokens()){
            st = new StringTokenizer(br.readLine());
        }

        return st.nextToken();

    }

    public static String smallestNumber(String pattern) {

        StringBuilder sb = new StringBuilder();

        Stack<Integer> st = new Stack<>();

        st.push(1);

        int iter = 2;

        for(int i=0; i<pattern.length(); i++){

            if(pattern.charAt(i) == 'D'){

                st.push(iter);

            }
            else{

                while(!st.isEmpty()){

                    sb.append(st.pop());

                }

                st.push(iter);

            }

            iter++;

        }


        while(!st.isEmpty()){

            sb.append(st.pop());

        }


        return sb.toString();
        
    }

    public static void main(String[] args) throws java.lang.Exception {

        System.out.print("Enter string containing only 'I' for increasing and 'D' for decreasing : ");
        String pattern = next();

        System.out.println("Smallest number formed using digits 1 to 9 atmost once following pattern string is: " + smallestNumber(pattern));

    }

}