//Q121. Best time to buy and sell stocks
// If (n+1)th price < current lowest price, then low price = (n+1) price. 
// Otherwise, check whether profit > diff. 
class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int diff = 0, high = 0, low = Integer.MAX_VALUE;
        for (int i = 1; i < prices.length; i++) {
        	high = prices[i];
        	if (high < low) {
        		low = high;
        	} else {
        		if (high - low > diff) {
        			diff = high - low;
        		}
        	}
        }
        return diff;
    }
}