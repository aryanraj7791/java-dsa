import java.util.*;

public class ShortestPathToDestination{

    public static int getShortestPath(String str){
        int x=0,y=0;
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) == 'E') x++;
            else if(str.charAt(i) == 'W') x--;
            else if(str.charAt(i) == 'N') y++;
            else y--;
        }
        return x*x + y*y;
    }

    public static void main(String args[]){
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter string with letters 'E','W','N','S' as directions: ");
        String str = scn.nextLine();
        System.out.print("Shortest path is: " + Math.sqrt(getShortestPath(str)));
    }
}