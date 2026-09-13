import java.util.*;
import java.lang.*;
import java.io.*;

class Sheokand_number
{
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    static StringTokenizer st;
    
    static int nextInt() throws IOException {
        
        while(st == null || !st.hasMoreTokens()){
            st = new StringTokenizer(br.readLine());
        }
        
        return Integer.parseInt(st.nextToken());
        
    }
    
    public static long minOps(int N){
        
        long best = Long.MAX_VALUE;

        for (int x = 0; x <= 31; x++) {
            long px = 1L << x;          // long shift avoids int overflow
            for (int y = 0; y < x; y++) {
                long py = 1L << y;
                long M = px + py;
                long diff = Math.abs(N - (long) M); // or just Math.abs(N - M) since M is already long
                if (diff < best) {
                    best = diff;
                }
            }
        }
    
        return best;
        
    }
    
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		
		System.out.print("Enter a number: ");
		
		int N = nextInt();
		
		System.out.println("Minimum number of operations: " + minOps(N));
		    

	}
}
