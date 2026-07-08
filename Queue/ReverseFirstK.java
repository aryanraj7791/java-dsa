import java.util.*;

public class ReverseFirstK{
    public static void reverseK(Queue<Integer> q, int k){
        Stack<Integer> s = new Stack<>();
        for(int i=1; i<=k; i++){
            s.push(q.remove());
        }
        for(int i=1; i<=k; i++){
            q.add(s.pop());
        }
        for(int i=1; i<=q.size()-k; i++){
            q.add(q.remove());
        }
    }
    public static void main(String[] args){
        Queue<Integer> q = new LinkedList<>();
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter number of elements in queue : ");
        int n = scn.nextInt();
        System.out.println("Enter elements in queue : ");
        for(int i=1; i<=n; i++){
            q.add(scn.nextInt());
        }
        System.out.print("Enter first k to be reversed : ");
        int k = scn.nextInt();
        reverseK(q,k);
        while(!q.isEmpty()){
            System.out.print(q.remove()+" ");
        }
        // System.out.print(q);
    }
}