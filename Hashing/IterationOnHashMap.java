import java.util.*;

public class IterationOnHashMap{
    public static void main(String[] args){
        HashMap<String,Integer> hm = new HashMap<>();
        hm.put("India",85323);
        hm.put("China",92563);
        hm.put("US",86381);
        hm.put("France",53542);
        hm.put("Indonesia",46286);
        //Iteration on HashMap
        Set<String> keys = hm.keySet();
        System.out.println(keys);
        for(String k : keys){
            System.out.println(hm.get(k));
        }
    }
}