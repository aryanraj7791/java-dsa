import java.util.*;

class Assign_cookies {

    public static int findContentChildren(int[] g, int[] s){

        Arrays.sort(g);
        Arrays.sort(s);

        int idx = 0; // Iterator over greedy array
        int ans = 0; // Stores maximum children that can be content

        for(int i=0; i<s.length && idx < g.length; i++){
            if(s[i]/g[idx] >= 1){
                ans++;
                idx++;
            }
        }

        return ans;

    }

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter number of children : ");
        int n = scn.nextInt();
        int[] g = new int[n];
        System.out.println("Enter greedy of children : ");
        for(int i=0; i<n; i++){
            g[i] = scn.nextInt();
        }

        System.out.print("Enter number of cookies : ");
        int m = scn.nextInt();
        int[] s = new int[m];
        System.out.println("Enter size of cookies : ");
        for(int i=0; i<m; i++){
            s[i] = scn.nextInt();
        }

        System.out.println("Maximum children that can be content is : " + findContentChildren(g,s));
    }
}