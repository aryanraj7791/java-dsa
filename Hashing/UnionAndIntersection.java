import java.util.*;

public class UnionAndIntersection{

    public static HashSet<Integer> union(int []arr1, int []arr2){
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i=0; i<arr1.length; i++){
            set.add(arr1[i]);
        }
        for(int i=0; i<arr2.length; i++){
            set.add(arr2[i]);
        }
        return set;
    }

    public static ArrayList<Integer> intersection(int []arr1, int []arr2){ //O(m+n)
        HashSet<Integer> set = new HashSet<>();
        ArrayList<Integer> list = new ArrayList<>();
        int count=0;
        if(arr1.length < arr2.length){
            for(int i=0; i<arr2.length; i++){
                set.add(arr2[i]);
            }
            for(int i=0; i<arr1.length; i++){
                if(set.contains(arr1[i])){
                    list.add(arr1[i]);
                    set.remove(arr1[i]);
                }
            }
        }else{
            for(int i=0; i<arr1.length; i++){
                set.add(arr1[i]);
            }
            for(int i=0; i<arr2.length; i++){
                if(set.contains(arr2[i])){
                    list.add(arr2[i]);
                    set.remove(arr2[i]);
                }
            }
        }
        return list;
    }

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter size of array1 : ");
        int n1 = scn.nextInt();
        int arr1[] = new int[n1];
        System.out.println("Enter elements in the array1 : ");
        for(int i=0; i<n1; i++){
            arr1[i] = scn.nextInt();
        }
        System.out.print("Enter size of array2 : ");
        int n2 = scn.nextInt();
        int arr2[] = new int[n2];
        System.out.println("Enter elements in the array2 : ");
        for(int i=0; i<n2; i++){
            arr2[i] = scn.nextInt();
        }
        System.out.println("Union is : "+union(arr1,arr2));
        System.out.println("Intersection is : "+intersection(arr1,arr2));
    }
}