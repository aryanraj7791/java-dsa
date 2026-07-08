import java.util.*;

public class BasicsHashMap{
    public static void main(String[] args){
        HashMap<String,Integer> hm = new HashMap<>();
        //Enter pairs into hashmap->O(1)
        hm.put("India",324);
        hm.put("China",524);
        hm.put("US", 473);
        hm.put("Canada",324);
        System.out.println(hm);
        //Get->O(1)
        System.out.println(hm.get("Canada"));
        //containsKey->O(1)
        System.out.println(hm.containsKey("SouthAfrica"));
        //Remove->O(1)
        System.out.println(hm.remove("US"));
        //Size->o(1)
        System.out.println(hm.size());
        //IsEmpty
        System.out.println(hm.isEmpty());
    }
}