import java.util.*;

class Elevator {

    public static int elevatorRequests(int n, int[] requests) {

        int totalTime = requests[0];

        for(int i=1; i<requests.length; i++){

            totalTime += Math.abs(requests[i] - requests[i-1]);
            
        }

        return totalTime;
    }

    public static void main(String[] args){

        Scanner scn = new Scanner(System.in);

        System.out.print("Enter number of floors: ");
        int n = scn.nextInt();

        //Floor number is from 0 to n-1;

        System.out.print("Enter number of requests: ");
        int m = scn.nextInt();

        int[] requests = new int[m];

        System.out.println("Enter requested floor number in sequence: ");

        for(int i=0; i<m; i++){
            requests[i] = scn.nextInt();
        }

        System.out.println("Total time taken to serve all requested floors is: " + elevatorRequests(n,requests));

    }
}