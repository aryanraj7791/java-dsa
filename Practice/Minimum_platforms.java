import java.util.*;

class Minimum_platforms {

    public static int minPlatform(int arr[], int dep[]) {
        //  code here
        
        Arrays.sort(arr);
        Arrays.sort(dep);
        
        int maxPlatforms = 0;
        int platforms = 0;
        
        int i = 0;
        int j = 0;
        
        while(i < arr.length && j < dep.length){
            
            if(arr[i] <= dep[j]){
                platforms++;
                i++;
                maxPlatforms = Math.max(maxPlatforms,platforms);
            }
            else{
                platforms--;
                j++;
            }
            
        }
        
        return maxPlatforms;
        
    }

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter number of trains : ");
        int n = scn.nextInt();

        int[] arr = new int[n];
        int[] dep = new int[n];

        System.out.println("Enter arrival and departure time of trains(HHMM) : ");
        
        for(int i=0; i<n; i++){

            System.out.print("Enter arrival time of train" + (i+1) + ": ");
            arr[i] = scn.nextInt();

            System.out.print("Enter departure time of train" + (i+1) + ": ");
            dep[i] = scn.nextInt();

        }

        System.out.println("Minimum platforms required: " + minPlatform(arr,dep));
    }
}
