import java.util.*;

class Minimum_total_price_after_applying_discounts {

    public static double minPrice(int[] prices, int[] discounts) {
        int n = prices.length;
        int m = discounts.length;

        Integer[] sortedPrices = new Integer[n];
        for(int i=0; i<n; i++){
            sortedPrices[i] = prices[i];
        }
        Arrays.sort(sortedPrices, (a,b) -> b-a);

        Integer[] sortedDiscounts = new Integer[m];
        for(int i=0; i<m; i++){
            sortedDiscounts[i] = discounts[i];
        }
        Arrays.sort(sortedDiscounts, (a,b) -> b-a);

        double total = 0.0;
        int k = Math.min(n,m);

        for(int i=0; i<k; i++){
            double p = sortedPrices[i];
            double d = sortedDiscounts[i];
            total += (p * (100-d)) / 100.0;
        }

        for(int i=k; i<n; i++){
            total += sortedPrices[i];
        }

        return total;
    }

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter size of prices array : ");
        int n = scn.nextInt();
        int[] prices = new int[n];
        System.out.println("Enter size of discount array : ");
        for(int i=0; i<n; i++){
            prices[i] = scn.nextInt();
        }

        System.out.print("Enter prices in the array : ");
        int m = scn.nextInt();
        int[] discounts = new int[m];
        System.out.println("Enter discounts in the array : ");
        for(int i=0; i<m; i++){
            discounts[i] = scn.nextInt();
        }

        System.out.println("Minimum total price after applying discounts : " + minPrice(prices,discounts));
    }
}