import java.util.*;

public class FractionalKnapsack{
    public static double maximiseValue(int []weights, int []value, int w){
        int n = weights.length;
        double []ratio = new double[n];
        for(int i=0; i<n; i++){
            ratio[i] = (double)value[i]/weights[i];
        }
        double ratio2D[][] = new double[n][2];
        for(int i=0; i<n; i++){
            ratio2D[i][0] = i;
            ratio2D[i][1] = ratio[i];
        }
        Arrays.sort(ratio2D, Comparator.comparingDouble(o -> o[1]));
        int capacity = w;
        double ans = 0; //to store max value
        for(int i = n-1; i>=0; i--){
            int idx = (int)ratio2D[i][0];
            if(capacity >= weights[idx]){
                ans += ratio2D[i][1]*weights[idx]; //complete weight can be accomodated in the bag
                capacity = capacity - weights[idx];
            }else{
                ans += ratio2D[i][1]*capacity; //Taking fraction of an item to finally fill the bag
                capacity = 0;
                break; //come out of loop as bag is filled completely
            }
        }
        return ans;
    }
        public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter number of items : ");
        int n = scn.nextInt();
        int []value = new int[n];
        int []weights = new int[n];
        System.out.println("Enter weights of items : ");
        for(int i=0; i<n; i++){
            weights[i] = scn.nextInt();
        }
        System.out.println("Enter value of items : ");
        for(int i=0; i<n; i++){
            value[i] = scn.nextInt();
        }
        System.out.print("Enter capacity of bag : ");
        int w = scn.nextInt();
        System.out.println("Maximised value is : " + maximiseValue(weights,value,w));
    }
}