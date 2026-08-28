import java.util.*;
import java.io.*;

class Combinations {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static StringTokenizer st;

    static int nextInt() throws IOException {

        while(st == null || !st.hasMoreTokens()){
            st = new StringTokenizer(br.readLine());
        }

        return Integer.parseInt(st.nextToken());

    }

    public static void allComb(int n, int k, int i, List<Integer> list, List<List<Integer>> res){

        if(list.size() == k){
            res.add(new ArrayList<>(list));
            return;
        }

        if(i > n) return;

        list.add(i);
        allComb(n,k,i+1,list,res);
        list.remove(list.size()-1);
        allComb(n,k,i+1,list,res);

    }

    public static List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> res = new ArrayList<>();
        
        allComb(n,k,1,new ArrayList<>(),res);

        return res;

    }

    public static void main(String[] args) throws java.lang.Exception{

        System.out.print("Enter n: ");
        int n = nextInt();

        System.out.print("Enter k: ");
        int k = nextInt();

        List<List<Integer>> res = combine(n,k);

        System.out.print(res);

    }
}