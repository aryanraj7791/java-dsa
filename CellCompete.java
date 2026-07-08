import java.util.*;

public class CellCompete{

    public static int[] func(int[] arr, int days){
        for(int i=0; i<days; i++){
            int[] state = new int[arr.length];
            if(arr[1] == 0) state[0] = 0;
            else state[0] = 1;
            if(arr[arr.length-2] == 0) state[arr.length-1] = 0;
            else state[arr.length-1] = 1;
            for(int j=1; j<arr.length-1; j++){
                if(arr[j-1] == 0 && arr[j+1] == 0){
                    state[j] = 0;
                }else if(arr[j-1] == 1 && arr[j+1] == 1){
                    state[j] = 0;
                }else{
                    state[j] = 1;
                }
            }
            arr = state;
        }
        return arr;
    }

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<arr.length; i++){
            arr[i] = scn.nextInt();
        }
        int days = scn.nextInt();
        int[] res = func(arr,days);
        for(int i=0; i<res.length; i++){
            System.out.print(res[i]+" ");
        }
    }
}