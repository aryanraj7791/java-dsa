import java.util.*;

public class Password{

    public static int countDistinct(String[] passwords){
        Set<String> set = new HashSet<>();
        for(int i=0; i<passwords.length; i++){
            ArrayList<Character> even = new ArrayList<>();
            ArrayList<Character> odd = new ArrayList<>();
            String pass = passwords[i];
            for(int j=0; j<pass.length(); j++){
                if(j % 2 == 0) even.add(pass.charAt(j));
                else odd.add(pass.charAt(j));
            }
            Collections.sort(even);
            Collections.sort(odd);
            String newPass = even.toString() + '|' + odd.toString();
            set.add(newPass);
        }
        return set.size();
    }

    public static void main(String[] args){
        String[] passwords = {"abcd","cdab"};
        System.out.println("Distinct passwords are : "+countDistinct(passwords));
    }
}
