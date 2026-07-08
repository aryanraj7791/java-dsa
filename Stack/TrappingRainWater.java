import java.util.*;

public class TrappingRainWater{
    public static int waterTrapped(int []arr){
        Stack<Integer> s = new Stack<>();
        int totalTrappedWater = 0;
        for (int i = 0; i < arr.length; i++) {
            // While current height is greater than top of stack
            while (!s.isEmpty() && arr[i] > arr[s.peek()]) {
                int bottom = s.pop();  // index of valley

                if (s.isEmpty()) break;  // no left boundary

                int left = s.peek();
                int width = i - left - 1;
                int height = Math.min(arr[left], arr[i]) - arr[bottom];

                if (height > 0) {
                    totalTrappedWater += width * height;
                }
            }
            s.push(i);
        }
        return totalTrappedWater;
    }
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter size of array of bars : ");
        int n = scn.nextInt();
        int []arr = new int[n];
        System.out.print("Enter height of bars : ");
        for(int i=0; i<arr.length; i++){
            arr[i] = scn.nextInt();
        }
        System.out.print("Total water trapped between bars is : "+waterTrapped(arr));
    }
}