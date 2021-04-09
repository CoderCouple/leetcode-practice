package com.dsa.facebook;

public class BestTimeToBuyAndSellStocks {


    //TC: O(n)
    //SC: O(1)
    // Buy and sell once
    public int maxProfit(int prices[]) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            minprice = Math.min(minprice, prices[i]);
            int currProfit = prices[i] - minprice;
            maxprofit = Math.max(maxprofit, currProfit);
        }
        return maxprofit;
    }


    //TC: O(n)
    //SC: O(1)
    //unlimited Buy and sell once for maximum profit
    public int maxProfit2(int[] prices) {
        int minprice = prices[0];
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            int currProfit = prices[i] - minprice;
            maxprofit += Math.max(0, currProfit);
            minprice = prices[i];
        }
        return maxprofit;
    }

    //TC: O(n)
    //SC: O(1)
    //unlimited Buy and sell once for maximum profit with transaction fees
    class Solution {
        public int maxProfit(int[] prices, int fee) {
            int cash = 0, hold = -prices[0];
            for (int i = 1; i < prices.length; i++) {
                cash = Math.max(cash, hold + prices[i] - fee);
                hold = Math.max(hold, cash - prices[i]);
            }
            return cash;
        }
    }

    public static void main(String[] args) {

    }
}
