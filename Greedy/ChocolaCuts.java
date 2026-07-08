import java.util.*;

public class ChocolaCuts{
    public static int minCost(Integer []hCuts, Integer []vCuts){
        Arrays.sort(hCuts,Comparator.reverseOrder());
        Arrays.sort(vCuts,Comparator.reverseOrder());
        int m = 0;
        int n = 0;
        int minCost = 0;
        int hp=1;
        int vp = 1;
        while(m < hCuts.length && n < vCuts.length){
            if(hCuts[m] < vCuts[n]){
                minCost += hp*vCuts[n];
                vp++;
                n++;
            }else{
                minCost += vp*hCuts[m];
                hp++;
                m++;
            }
        }
        while(m < hCuts.length){
            minCost += hCuts[m]*vp;
            m++;
            hp++;
        }
        while(n < vCuts.length){
            minCost += vCuts[n]*hp;
            n++;
            vp++;
        }
        return minCost;
    }
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter number of rows in chocolate bar : ");
        int m = scn.nextInt();
        System.out.print("Enter number of columns in chocolate bar : ");
        int n = scn.nextInt();
        Integer []hCuts = new Integer[m-1];
        Integer []vCuts = new Integer[n-1];
        System.out.println("Enter cost of horizontal cuts : ");
        for(int i=0; i<hCuts.length; i++){
            hCuts[i] = scn.nextInt();
        }
        System.out.println("Enter cost of vertical cuts : ");
        for(int i=0; i<vCuts.length; i++){
            vCuts[i] = scn.nextInt();
        }
        System.out.println("Minimum cost to cut "+ m + " x "+ n +" chocolate is : "+ minCost(hCuts,vCuts));
    }
}