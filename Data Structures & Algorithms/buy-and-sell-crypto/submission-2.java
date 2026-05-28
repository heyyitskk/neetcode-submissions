class Solution {
    public int maxProfit(int[] prices) {
        int i = 0, j = 1;
        int maxP = 0;
        while(j < prices.length){
            int profit = prices[j] - prices[i];
            if(profit < 0){
                i++;
            }
            else if(profit > 0){
                maxP = Math.max(maxP, profit);
                j++;
            }
            else{
                j++;
            }
        }
        return maxP;
    }
}
