import java.util.*;

public class SegmentTreeRangeSum {

    static int[] tree;

    public static void init(int n){
        tree = new int[4*n];
    }

    public static int buildST(int[] arr, int sti, int start, int end){
        //Basecase
        if(start == end){
            return tree[sti] = arr[start];
        }

        int mid = start + (end-start)/2;

        int leftChild = buildST(arr,2*sti+1,start,mid); //Left child --> 2*sti+1
        int rightChild = buildST(arr,2*sti+2,mid+1,end); //Right child --> 2*sti+2

        return tree[sti] = leftChild + rightChild;
    }

    public static int getSum(int i, int si, int sj, int qi, int qj){
        if(si > qj || sj < qi){ // Non-overlapping case
            return 0;
        }

        else if(si >= qi && sj <= qj){ // Completely overlapping
            return tree[i];
        }

        else{ // Partial overlapping
            int mid = (si + sj)/2;
            return getSum(2*i+1,si,mid,qi,qj) + getSum(2*i+2,mid+1,sj,qi,qj);
        }
    }

    public static void updateUtil(int idx, int diff, int i, int si, int sj){
        if(idx < si || idx > sj){
            return;
        }

        tree[i] = tree[i] + diff;

        if(si != sj){
            int mid = (si + sj)/2;
            updateUtil(idx,diff,2*i+1,si,mid);
            updateUtil(idx,diff,2*i+2,mid+1,sj);
        }
    }

    public static void update(int[] arr, int idx, int newVal){
        int n = arr.length;
        int diff = newVal - arr[idx];
        arr[idx] = newVal;
        updateUtil(idx,diff,0,0,n-1);
    }

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter size of array : ");
        int n = scn.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter elements in the array : ");
        for(int i=0; i<n; i++){
            arr[i] = scn.nextInt();
        }

        init(n);
        buildST(arr,0,0,n-1);

        System.out.print("Do you want to update value at any index ? If yes type 'Y' else 'N' : ");
        char ch = scn.next().charAt(0);
        if(ch == 'Y'){
            System.out.print("Enter index where to update : ");
            int idx = scn.nextInt();
            System.out.print("Enter new value at that index : ");
            int newVal = scn.nextInt();
            update(arr,idx,newVal);
        }

        System.out.print("Enter query index qi : ");
        int qi = scn.nextInt();
        System.out.print("Enter query index qj : ");
        int qj = scn.nextInt();
        System.out.println("Subarray sum from query index " + qi + " to query index " + qj + " is : " + getSum(0,0,n-1,qi,qj));
    }
}