import java.util.*;

public class Ques{

    public static int largDist(String x, String y){
        String str = x.replaceAll(" ","");
        HashMap<Character,Integer> map = new HashMap<>();
        int maxLength = -1;
        for(int i=0; i<str.length(); i++){ //TC--> O(L) where L is the length of string
            if(!map.containsKey(y.charAt(0)) && str.charAt(i) == y.charAt(0)){
                map.put(str.charAt(i),i);
            }
            if(str.charAt(i) == y.charAt(0) && map.containsKey(str.charAt(i))){
                maxLength = Math.max(maxLength,i-map.get(str.charAt(i))-1);
            }
        }
        return maxLength;
    }

    public static void main(String[] args){
        String x = "my name is ranary";
        String y = "a";
        System.out.println("Largest distance : "+largDist(x,y));
    }
}