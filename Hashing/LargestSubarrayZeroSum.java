import java.util.*;

public class LargestSubarrayZeroSum{

    public static int largestSubArray(int []arr){
        HashMap<Integer,Integer> map = new HashMap<>();
        int maxLength = 0;
        int sum=0;
        for(int i=0; i<arr.length; i++){
            sum += arr[i];
            if(sum == 0) maxLength = i+1;
            if(map.containsKey(sum)){
                maxLength = Math.max(maxLength,i-map.get(sum));
            }else{
                map.put(sum,i);
            }
        }
        return maxLength;
    }

    public static void main(String[] args){
        int arr[] = {15,-2,2,-8,1,7,10};
        System.out.println("Length of largest subarray with sum 0 is : "+largestSubArray(arr));
    }
}