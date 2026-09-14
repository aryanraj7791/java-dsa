import java.util.*;

class Generate_parenthesis {

    public static List<String> res = new ArrayList<>();

    public static void rec(int open, int close, StringBuilder sb){
        //Basecase
        if(open == 0 && close == 0){
            res.add(sb.toString());
            return;
        }

        //Recursion
        if(open > 0){
            sb.append('(');
            rec(open-1,close,sb);
            sb.deleteCharAt(sb.length()-1);
        }
        if(open < close){
            sb.append(')');
            rec(open,close-1,sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }

    public static List<String> generateParenthesis(int n) {
        rec(n,n,new StringBuilder(""));
        return res;
    }

    public static void main(String[] args){

        Scanner scn = new Scanner(System.in);

        System.out.print("Enter number of pairs: ");
        int n = scn.nextInt();

        List<String> ans = generateParenthesis(n);

        for(int i=0; i<ans.size(); i++){
            System.out.println(ans.get(i));
        }

    }
}