import java.util.*;

class Lemonade_change {
    public static boolean lemonadeChange(int[] bills) {

        int fiveNotes = 0;
        int tenNotes = 0;
        int twentyNotes = 0;

        for(int i=0; i<bills.length; i++){
            if(bills[i] == 5) fiveNotes++;
            else if(bills[i] == 10) {
                if(fiveNotes > 0){
                    fiveNotes--;
                    tenNotes++;
                }
                else{
                    return false;
                }
            }
            else{
                if(fiveNotes >= 1 && tenNotes >= 1){
                    fiveNotes--;
                    tenNotes--;
                    twentyNotes++;
                }
                else if(fiveNotes >= 3){
                    fiveNotes -= 3;
                    twentyNotes++;
                }
                else{
                    return false;
                }
            }
        }

        return true;
        
    }

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter size of bills array : ");
        int n = scn.nextInt();

        int[] bills = new int[n];

        System.out.println("Enter bills($5, $10 or $20 only) in the array : ");

        for(int i=0; i<n; i++){
            bills[i] = scn.nextInt();
        }
        
        System.out.println(lemonadeChange(bills));
    }
}