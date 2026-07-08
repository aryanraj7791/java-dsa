import java.util.*;

public class InsertInHeap{

    public static class Heap{

        ArrayList<Integer> arr = new ArrayList<>();

        public void add(int val){ //O(logn)
            //Add value to last idx in arr
            arr.add(val);
            //Fix heap
            int x = arr.size()-1; //Child idx
            int idx = (x-1)/2; //parent idx
            while(x>0 && arr.get(idx)>arr.get(x)){ //O(logn)
                //swap
                int temp = arr.get(idx);
                arr.set(idx,arr.get(x));
                arr.set(x,temp);
                //Reset child and parent idx
                x = idx;
                idx = (x-1)/2;
            }
        }

        public int peek(){
            if(isEmpty()){
                System.out.println("Heap is empty!");
                return -1;
            }
            return arr.get(0);
        }

        public void heapify(int i){
            int left = 2*i+1;
            int right = 2*i+2;
            int minIdx = i;
            if(left<arr.size() && arr.get(left)<arr.get(minIdx)){
                minIdx = left;
            }
            if(right<arr.size() && arr.get(right)<arr.get(minIdx)){
                minIdx = right;
            }
            if(minIdx != i){
                //Swap root element with minIdx element
                int temp = arr.get(i);
                arr.set(i,arr.get(minIdx));
                arr.set(minIdx,temp);
                heapify(minIdx); // Recursively call heapify to correct affected subtree 
            }
        }

        public int remove(){
            if(isEmpty()){
                System.out.println("Heap is empty!");
                return -1;
            }
            int data = arr.get(0);
            //Step-1: Swap 1st and last idx element
            int temp = arr.get(arr.size()-1);
            arr.set(arr.size()-1,arr.get(0));
            arr.set(0,temp);
            //Step-2: Remove last idx element
            arr.remove(arr.size()-1);
            //Step-3: Call Heapify for root
            heapify(0);
            return data;
        }

        public boolean isEmpty(){
            return arr.size() == 0;
        }

    }

    public static void main(String[] args){
        Heap h = new Heap();
        h.add(6);
        h.add(4);
        h.add(10);
        h.add(5);
        h.add(8);
        h.add(2);
        // System.out.println(h.peek());
        // System.out.println(h.arr);
        while(!h.isEmpty()){ //Heap sort
            System.out.print(h.remove()+" ");
        }
    }
}