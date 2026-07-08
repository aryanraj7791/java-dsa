import java.util.*;

public class Calculator{
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter real part of 1st complex no: ");
        int x = scn.nextInt();
        System.out.print("Enter imaginary part of 1st complex no: ");
        int y = scn.nextInt();
        System.out.print("Enter real part of 2nd complex no: ");
        int a = scn.nextInt();
        System.out.print("Enter imaginary part of 2nd complex no: ");
        int b = scn.nextInt();

        Complex op = new Complex();
        
        op.add(x,y,a,b);
        op.sub(x,y,a,b);
        op.mul(x,y,a,b);
    }
}

public class Complex{

    void add(int x, int y, int a, int b){
        System.out.println("Addition is: " + (x+a) + " + i" + (y+b));
    }

    void sub(int x, int y, int a, int b){
        System.out.println("Subtraction is: " + (x-a) + " + i" + (y-b));
    }

    void mul(int x, int y, int a, int b){
        System.out.println("Multiplication is: " + (a*x - y*b) + " + i" + (x*b + a*y));
    }

}