import java.util.*;

public class IterationOnHashSet{
    public static void main(String[] args){
        int arr[] = {1,5,3,7,9,3,2,1};
        HashSet<Integer> hs = new HashSet<>();
        for(int i=0; i<arr.length; i++){
            hs.add(arr[i]);
        }
        Iterator it = hs.iterator();
        while(it.hasNext()){
            System.out.print(it.next()+" ");
        }
    }
}