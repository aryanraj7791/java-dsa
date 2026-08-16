import java.util.*;
import java.io.*;

class CoronaVirus_spread
{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static StringTokenizer st;

    static int nextInt() throws IOException {

        while(st == null || !st.hasMoreTokens()){
            st = new StringTokenizer(br.readLine());
        }

        return Integer.parseInt(st.nextToken());

    }
    
    public static void func(int[] people){
        
        int minSeg = Integer.MAX_VALUE;
        int maxSeg = Integer.MIN_VALUE;
        
        int currSeg = 1;
        
        for(int i=1; i<people.length; i++){
            
            if(people[i] - people[i-1] <= 2){
                
                currSeg++;
                
            }
            else{
                
                minSeg = Math.min(minSeg, currSeg);
                maxSeg = Math.max(maxSeg, currSeg);
                currSeg = 1;
                
            }
            
        }
        
        minSeg = Math.min(minSeg, currSeg);
        maxSeg = Math.max(maxSeg, currSeg);
        
        System.out.println("Minimum people that can be affected: " + minSeg);
        System.out.println("Maximum people that can be affected: " + maxSeg);
    }
    
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
        
        System.out.print("Enter number of people(N): ");
        int N = nextInt();

        int[] people = new int[N];

        System.out.println("Give number to people between(1 to N): ");

        for(int i=0; i<N; i++){
            people[i] = nextInt();
        }

        func(people);
	}
}
