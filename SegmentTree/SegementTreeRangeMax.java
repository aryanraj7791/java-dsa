import java.util.*;

public class SegmentTreeRangeMax {

    static int[] tree;

    public static void init(int n){
        tree = new int[4*n];
    }

    public static void buildST(int[] arr, int i, int si, int sj){
        if(si == sj){
            tree[i] = arr[si];
            return;
        }

        int mid = si + (sj - si)/2;

        buildST(arr,2*i+1,si,mid);
        buildST(arr,2*i+2,mid+1,sj);

        tree[i] = Math.max(tree[2*i+1],tree[2*i+2]);
    }

    public static int getMax(int i, int qi, int qj, int si, int sj){
        if(si > qj || sj < qi){
            return Integer.MIN_VALUE;
        }

        if(si >= qi && sj <= qj){
            return tree[i];
        }

        int mid = si + (sj - si)/2;

        int leftMax = getMax(2*i+1,qi,qj,si,mid);
        int rightMax = getMax(2*i+2,qi,qj,mid+1,sj);

        return Math.max(leftMax,rightMax);
    }

    public static void updateUtil(int i, int idx, int newVal, int si, int sj){
        if(idx < si || idx > sj){
            return;
        }

        if(si == sj){
            tree[i] = newVal;
        }

        if(si != sj){ // Non-leaf node
            tree[i] = Math.max(tree[i],newVal);
            int mid = si + (sj - si)/2;
            if(idx <= mid) updateUtil(2*i+1,idx,newVal,si,mid);
            else updateUtil(2*i+2,idx,newVal,mid+1,sj);
        }
    }

    public static void update(int[] arr, int idx, int newVal){
        int n = arr.length;
        arr[idx] = newVal;
        updateUtil(0,idx,newVal,0,n-1);
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

        System.out.print("Do you want to update value at an index ? If yes type 'Y' else type 'N' : ");
        char response = scn.next().charAt(0);

        if(response == 'Y'){
            System.out.print("Enter index where you want to update : ");
            int idx = scn.nextInt();
            System.out.print("Enter new value : ");
            int newVal = scn.nextInt();
            update(arr,idx,newVal);
        }

        System.out.print("Enter query index i : ");
        int qi = scn.nextInt();
        System.out.print("Enter query index j : ");
        int qj = scn.nextInt();

        System.out.println("Maximum value between index " + qi + " and index " + qj + " is : " + getMax(0,qi,qj,0,n-1));
    }
}