import java.util.*;

public class MaxAreaHistogram{
    public static int maxArea(int []heights){
    int n = heights.length;
    Stack<Integer> s = new Stack<>();
    int maxArea = -1;
    int []nxtSmallerRight = new int[n];
    int []nxtSmallerLeft = new int[n];
        //Next smaller left
        for(int i=0; i<n; i++){
        int curr = heights[i];
        while(!s.isEmpty() && curr <= heights[s.peek()]){
            s.pop();
        }
        if(s.isEmpty()){
            nxtSmallerLeft[i] = -1;
        }
        else{
            nxtSmallerLeft[i] = s.peek();
        }
        s.push(i);
    }
        while(!s.isEmpty()){
            s.pop();
        }
        //Next smaller right
        for(int i=n-1; i>=0; i--){
        int curr = heights[i];
        while(!s.isEmpty() && curr <= heights[s.peek()]){
            s.pop();
        }
        if(s.isEmpty()){
            nxtSmallerRight[i] = n;
        }
        else{
            nxtSmallerRight[i] = s.peek();
        }
        s.push(i);
    }
    int currArea = 0;
    for(int i=0; i<n; i++){
        int width = nxtSmallerRight[i] - nxtSmallerLeft[i] - 1;
        currArea = heights[i] * width;
        maxArea = Math.max(currArea,maxArea);
    }
    return maxArea;
}
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter number of bars in histogram : ");
        int n = scn.nextInt();
        int []heights = new int[n];
        System.out.println("Enter height of bars : ");
        for(int i=0; i<heights.length; i++){
            heights[i] = scn.nextInt();
        }
        System.out.print("Max area in given histogram is : " + maxArea(heights));
    }
}