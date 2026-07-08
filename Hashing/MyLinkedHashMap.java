import java.util.*;

public class MyLinkedHashMap{
    public static void main(String[] args){
        LinkedHashMap<String,Integer> lhm = new LinkedHashMap<>();
        lhm.put("India",4362);
        lhm.put("Nepal",2322);
        lhm.put("US",7352);
        lhm.put("China",8221);
        // System.out.println(lhm);
        Set<String> keys = lhm.keySet();
        for(String key : keys){
            System.out.println("Key is : "+key+", Value is : "+lhm.get(key));
        }
    }
}