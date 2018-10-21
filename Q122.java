//Q122. Best Time to Buy and Sell Stock II
// Whenever current value is larger than previous value, count the profit
class Solution {
    public int maxProfit(int[] prices) {
        int prof = 0;
        if (prices.length == 0) return prof;
        int low = prices[0];
        for (int i = 1; i < prices.length; i++) {
        	int high = prices[i];
        	prof += (high > low ? high - low : 0);
        	low = high;
        }
        return prof;
    }
}