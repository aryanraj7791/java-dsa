import java.util.*;

public class TowerOfHanoi{

    public static void towerOfHanoi(int n, char source_rod, char helper_rod, char destination_rod){
        //Base Case
        if(n == 0){
            return;
        }

        //Move (n-1) disks from A to B
        towerOfHanoi(n-1,source_rod,destination_rod,helper_rod);

        //Move nth disk from A to C
        System.out.println("Move disk " + n + " from " + source_rod + " to " + destination_rod);

        //Move (n-1) disks from B to C
        towerOfHanoi(n-1,helper_rod,source_rod,destination_rod);
    }

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter number of disks: ");
        int n = scn.nextInt();
        towerOfHanoi(n,'A','B','C');
    }
}