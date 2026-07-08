import java.util.*;

public class LeapYear{
    public static void main(String args[]){
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter year to check for Leap year: ");
        int year = scn.nextInt();

        if(year % 4 != 0){
            System.out.print(year + " is not a Leap year.");
        } 
        else if(year % 100 != 0){
             System.out.print(year + " is a Leap year.");
        } 
        else if(year % 400 != 0){
            System.out.print(year + " is not a Leap year.");
        }
        else {
            System.out.print(year + " is a Leap year.");
        }
    }
}