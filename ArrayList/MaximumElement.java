import java.util.ArrayList;

public class MaximumElement{
    public static void main(String[] args){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(61); 
        list.add(22);
        list.add(30);
        list.add(76);
        list.add(80);

       int max = Integer.MIN_VALUE;
       for(int i=0; i<list.size(); i++){
        if(list.get(i)>max) max = list.get(i);
       }
       System.out.println(max);
    }
}