import java.util.*;

class Maximum_common_elements{

    public static int common(int[] A, int[] B){
        
        int res = 0;
        
        Set<Integer> set = new HashSet<>();
        
        for(int num: A){
            set.add(num);
        }
        
        for(int num: B){
            
            if(set.contains(num)){
                res++;
            }
            
        }
        
        return res;
        
    }

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter number of elements in array A & B : ");
        int n = scn.nextInt();

        int[] A = new int[n];
        int[] B = new int[n];

        System.out.println("Enter elements in array A : ");
        for(int i=0; i<n; i++){
            A[i] = scn.nextInt();
        }

        System.out.println("Enter elements in array B : ");
        for(int i=0; i<n; i++){
            B[i] = scn.nextInt();
        }

        System.out.println("Total common elements in array A and B is: " + common(A,B));
    }

}
