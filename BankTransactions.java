import java.util.*;

public class BankTransactions{

    public static int maxTransaction(int[] transaction){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int balance=0,count=0;
        for(int x: transaction){
            balance += x;
            count++;
            if(x<0){
                pq.add(x);
            }
            while(balance<0 && !pq.isEmpty()){
                int worst = pq.remove();
                balance -= worst;
                count--;
            }
        }
        return count;
    }

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter n : ");
        int n = scn.nextInt();
        int[] transaction = new int[n];
        System.out.println("Enter transactions in the array : ");
        for(int i=0; i<transaction.length; i++){
            transaction[i] = scn.nextInt();
        }
        System.out.println("Maximum transaction possible is : "+maxTransaction(transaction));
    }
}