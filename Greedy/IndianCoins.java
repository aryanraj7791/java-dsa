import java.util.*;

public class IndianCoins{
    static StringBuilder sb = new StringBuilder("");
    public static int minCoins(long n){
        int minCoinsNotes = 0;
        while(n > 0){
            if(n >= 2000){
                minCoinsNotes += n/2000;
                if(sb.length() == 0){
                    sb.append("(");
                    for(int i=1; i<=n/2000; i++){
                    sb.append("2000+");
                    }
                }else{
                    if(sb.charAt(sb.length()-1) == '+') sb.deleteCharAt(sb.length()-1);
                    for(int i=1; i<=n/2000; i++){
                    sb.append("+2000");
                    }
                }
                n = n % 2000;
                if(n == 0) sb.append(")");
            }else if(n >= 1000){
                minCoinsNotes++;
                if(sb.length() == 0){
                    sb.append("(1000+");
                }else{
                    if(sb.charAt(sb.length()-1) == '+') sb.deleteCharAt(sb.length()-1);
                    sb.append("+1000");
                }
                n = n % 1000;
                if(n == 0) sb.append(")");
            }else if(n >= 500){
                minCoinsNotes++;
                if(sb.length() == 0){
                    sb.append("(500+");
                }else{
                    if(sb.charAt(sb.length()-1) == '+') sb.deleteCharAt(sb.length()-1);
                    sb.append("+500");
                }
                n = n % 500;
                if(n == 0) sb.append(")");
            }else if(n >= 100){
                minCoinsNotes += n/100;
                if(sb.length() == 0){
                    sb.append("(");
                    for(int i=1; i<=n/100; i++){
                    sb.append("100+");
                    }
                }else{
                    if(sb.charAt(sb.length()-1) == '+') sb.deleteCharAt(sb.length()-1);
                    for(int i=1; i<=n/100; i++){
                    sb.append("+100");
                    }
                }
                n = n % 100;
                if(n == 0) sb.append(")");
            }else if(n >= 50){
                minCoinsNotes++;
                if(sb.length() == 0){
                    sb.append("(50+");
                }else{
                    if(sb.charAt(sb.length()-1) == '+') sb.deleteCharAt(sb.length()-1);
                    sb.append("+50");
                }
                n = n % 50;
                if(n == 0) sb.append(")");
            }else if(n >= 20){
                minCoinsNotes += n/20;
                if(sb.length() == 0){
                    sb.append("(");
                    for(int i=1; i<=n/20; i++){
                    sb.append("20+");
                    }
                }else{
                    if(sb.charAt(sb.length()-1) == '+') sb.deleteCharAt(sb.length()-1);
                    for(int i=1; i<=n/20; i++){
                    sb.append("+20");
                    }
                }
                n = n % 20;
                if(n == 0) sb.append(")");
            }else if(n >= 10){
                minCoinsNotes++;
                if(sb.length() == 0){
                    sb.append("(10+");
                }else{
                    if(sb.charAt(sb.length()-1) == '+') sb.deleteCharAt(sb.length()-1);
                    sb.append("+10");
                }
                n = n % 10;
                if(n == 0) sb.append(")");
            }else if(n >= 5){
                minCoinsNotes++;
                if(sb.length() == 0){
                    sb.append("(5+");
                }else{
                    if(sb.charAt(sb.length()-1) == '+') sb.deleteCharAt(sb.length()-1);
                    sb.append("+5");
                }
                n = n % 5;
                if(n == 0) sb.append(")");
            }else if(n >= 2){
                minCoinsNotes += n/2;
                if(sb.length() == 0){
                    sb.append("(");
                    for(int i=1; i<=n/2; i++){
                    sb.append("2+");
                    }
                }else{
                    if(sb.charAt(sb.length()-1) == '+') sb.deleteCharAt(sb.length()-1);
                    for(int i=1; i<=n/2; i++){
                    sb.append("+2");
                    }
                }
                n = n % 2;
                if(n == 0) sb.append(")");
            }else{
                if(n == 0){
                    return minCoinsNotes;
                }
                else{
                    minCoinsNotes++;
                    if(sb.length() == 0){
                    sb.append("(1)");
                    }else{
                    sb.append("+1)");
                    }
                    n = n % 1;
                }
            }
        }
        return minCoinsNotes;
    }
    public static void main(String[] args){
        //Denominations -> 1,2,5,10,20,50,100,500,2000
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter value : ");
        long n = scn.nextInt();
        System.out.println("Minimum number of coins/notes for value "+n+" is : "+minCoins(n)+" "+sb);
    }
}