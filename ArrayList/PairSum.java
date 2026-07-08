import java.util.ArrayList;

public class PairSum{
    public static void pairSum(ArrayList<Integer> list, int target){
        int low=0;
        int high=list.size()-1;
        while(low<high){
            if((list.get(low)+list.get(high)) == target){
                System.out.println("Index no: " + low + " and " + high + " gives target sum " + target);
                return;
            }
            else if(list.get(low)+list.get(high)<target){
                low++;
            }
            else{
                high--;
            }
        }
        System.out.println("No two value gives target sum!");
    }
    public static void main(String[] args){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        int target = 13;
        pairSum(list,target);
    }
}