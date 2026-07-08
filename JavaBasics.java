import java.util.*;

public class JavaBasics{
    public static void main(String args[]){
      Scanner scn = new Scanner(System.in);
      // System.out.print("Enter cost of pen: ");
      // float pen = scn.nextFloat();
      // System.out.print("Enter cost of pencil: ");
      // float pencil = scn.nextFloat();
      // System.out.print("Enter cost of eraser: ");
      // float eraser = scn.nextFloat();

      // float totalCost = pen + pencil + eraser;
      // System.out.println("\nTotal cost before GST: " + totalCost);

      // float gst = 0.18f*totalCost;
      // System.out.println("GST: " + gst);

      // float totalBill = totalCost + gst;

      // System.out.print("Total Bill: " + totalBill);

      // System.out.print("Enter your age: ");
      // int age = scn.nextInt();     

      // if(x%2 == 0){
      //   System.out.print("EVEN");
      // } else{
      //   System.out.print("ODD");
      // }

      // if(age>=18){
      //   System.out.print("Adult");
      // }
      // else if(age>=13){
      //   System.out.print("Teenager");
      // }
      // else{
      //   System.out.print("Not a teenager");
      // }

      System.out.print("Enter first number: ");
      float a = scn.nextFloat();

      System.out.print("Enter second number: ");
      float b = scn.nextFloat();

      System.out.print("Enter arithmetic operation(+,-,*,/,%): ");
      char ch = scn.next().charAt(0);

      switch(ch){
        case '+': System.out.print("Result: " + (a+b));
               break;

        case '-': System.out.print("Result: " + (a-b));
               break;

        case '*': System.out.print("Result: " + (a*b));
               break;

        case '/': System.out.print("Result: " + (a/b));
               break;

        case '%': System.out.print("Result: " + (a%b));
               break;

        default: System.out.print("Sorry! Entered operation is not supported!");
      }
    }
}

//Boilerplate Code