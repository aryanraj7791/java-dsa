import java.util.ArrayList;

public class RotatedPairSum{
    public static void pairSum2(ArrayList<Integer> list, int target){
        int i=0,n=list.size();
        int high=-1,low=-1;
        while(i<n){
            if(list.get(i)>list.get(i+1)){
                high = i;
                low = i+1;
                break;
            }
            i++;
        }
        while(low != high){
            if((list.get(low)+list.get(high)) == target){
                System.out.println("Index no: " + low + " and " + high + " gives target sum " + target);
                return;
            }
            else if((list.get(low)+list.get(high))>target){
                high = (n+high-1)%n;
            }
            else{
                low = (low+1)%n;
            }
        }
        System.out.println("No two value gives target sum!");
    }
    public static void main(String[] args){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(11);
        list.add(15);
        list.add(6);
        list.add(8);
        list.add(9);
        list.add(10);
        int target = 25;
        pairSum2(list,target);
    }
}