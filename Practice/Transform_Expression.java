import java.util.*;
import java.lang.*;
import java.io.*;

class Transform_Expression
{
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    static StringTokenizer st;
    
    static int nextInt() throws IOException {
        
        while(st == null || !st.hasMoreTokens()){
            st = new StringTokenizer(br.readLine());
        }
        
        return Integer.parseInt(st.nextToken());
        
    }
    
    static String next() throws IOException {
        
        while(st == null || !st.hasMoreTokens()){
            st = new StringTokenizer(br.readLine());
        }
        
        return st.nextToken();
        
    }
    
    public static String transformExpression(String s){
        
        Stack<String> stack = new Stack<>();
        
        for(int i=0; i<s.length(); i++){
            
            String c = String.valueOf(s.charAt(i));
            
            if(!c.equals(")")){
                
                stack.push(c);
                
            }
            else{
                
                String s1 = stack.pop();
                String operator = stack.pop();
                String s2 = stack.pop();
                
                stack.pop();
                
                stack.push(s2+s1+operator);
                
            }
            
        }
        
        return stack.pop();
        
    }
 
     
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		
		int t = nextInt();
		
		while(t-- > 0){
		    
		    String s = next();
		    
		    String res = transformExpression(s);
		    
		    System.out.println(res);
		    
		}

	}
}
