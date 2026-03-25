class Solution {
    public int maxProfit(int[] prices) {

        int minPriceSoFar = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int currentPrice : prices) {

            if (currentPrice < minPriceSoFar) {
                minPriceSoFar = currentPrice;
            } else {
                int currentProfit = currentPrice - minPriceSoFar;
                maxProfit = Math.max(maxProfit, currentProfit);
            }
        }

        return maxProfit;
    }
}