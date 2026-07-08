import java.util.*;

public class NextGreaterElement{
    public static void nextGreater(int []arr, int []nGreater){
        Stack<Integer> s = new Stack<>();
        for(int i=arr.length-1; i>=0; i--){
            int curr = arr[i];
            while(!s.isEmpty() && curr >= arr[s.peek()]){
                s.pop();
            }
            if(s.isEmpty()){
                nGreater[i] = -1;
            }else{
                nGreater[i] = arr[s.peek()];
            }
            s.push(i); 
        }
    }
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter size of array : ");
        int n = scn.nextInt();
        int []arr = new int[n];
        System.out.println("Enter elements in the array : ");
        for(int i=0; i<arr.length; i++){
            arr[i] = scn.nextInt();
        }
        int []nGreater = new int[arr.length];
        nextGreater(arr,nGreater);
        System.out.println("Next greater element array is : ");
        for(int i=0; i<nGreater.length; i++){
            System.out.print(nGreater[i]+" ");
        }
        System.out.println();
    }
}