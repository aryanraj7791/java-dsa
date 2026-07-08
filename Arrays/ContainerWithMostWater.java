import java.util.*;

public class ContainerWithMostwater{

    public static int mostWater(int []container, int low, int high){
        int maxWater = Integer.MIN_VALUE;
        while(low<high){
            int minLH = Math.min(container[low],container[high]);
            int water = (high-low)*minLH;
            maxWater = Math.max(water,maxWater);
            if(container[low]<container[high]){
                low++;
            }
            else{
                high--;
            }
        }
        return maxWater;
    }

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter size of array : ");
        int n = scn.nextInt();
        int []container = new int[n];
        System.out.print("Enter elements in the array : ");
        for(int i=0; i<n; i++){
            container[i] = scn.nextInt();
        }
        int ans = mostWater(container,0,n-1);
        System.out.println("Most water that can be stored in container is : " + ans);
    }
}