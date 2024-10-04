package DataStructure.array;

public class MaxProfit {

    public static int maxProfit(int[] prices) {
        // Initialize the minimum price to the maximum possible value
        int minPrice = Integer.MAX_VALUE;
        // Initialize the maximum profit to zero
        int maxProfit = 0;

        // Iterate through the price array
        for (int price : prices) {
            // Update the minimum price if the current price is lower
            if (price < minPrice) {
                minPrice = price;
            }
            // Calculate profit by subtracting the minimum price from the current price
            else {
                maxProfit = Math.max(maxProfit, price - minPrice);
            }
        }
        return maxProfit;
    }


    public static void main(String[] args) {
        int[] stockPrices = {7, 1, 5, 3, 6, 4};
        int profit = maxProfit(stockPrices);
        System.out.println("Maximum profit: " + profit);
    }
}

