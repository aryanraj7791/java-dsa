import java.util.*;

public class MyTreeMap{
    public static void main(String[] args){
        TreeMap<String,Integer> tm = new TreeMap<>();
        tm.put("India",4362);
        tm.put("Nepal",2322);
        tm.put("US",7352);
        tm.put("China",8221);
        // System.out.println(lhm);
        Set<String> keys = tm.keySet();
        for(String key : keys){
            System.out.println("Key is : "+key+", Value is : "+tm.get(key));
        }
    }
}