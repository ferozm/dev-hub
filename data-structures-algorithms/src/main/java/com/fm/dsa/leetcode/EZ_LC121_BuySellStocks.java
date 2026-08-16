package com.fm.dsa.leetcode;

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/

import static com.fm.dsa.DSALogger.LOG;


public class EZ_LC121_BuySellStocks {

    public static void main(String[] args) {
        int[] prices1 = {10, 1, 5, 6, 7, 1};
        LOG("getMaxProfit = " + getMaxProfit(prices1));
        LOG("getMaxProfitV2 = " + maxProfitV2(prices1));

        int[] prices2 = {10, 8, 7, 5, 2};
        LOG("getMaxProfit = " + getMaxProfit(prices2));
        LOG("getMaxProfitV2 = " + maxProfitV2(prices2));

    }

    private static int getMaxProfit(int[] prices) {
        int buy = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            int sell = prices[i];
            maxProfit = Math.max(maxProfit, sell - buy);

            if (sell < buy) buy = sell;
        }

        return maxProfit;
    }

    // Using 2 pointers
    private static int maxProfitV2(int[] prices) {

        int result = 0;
        int l = 0;
        int r = 1;

        while (r < prices.length) {
            int profit = prices[r] - prices[l];

            result = Math.max(result, profit);
            if (prices[r] < prices[l]) l = r;
            r++;
        }

        return result;
    }
}


/*
You are given an array prices where prices[i] is the price of a given stock on the ith day.

You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.



Example 1:

Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
Example 2:

Input: prices = [7,6,4,3,1]
Output: 0
Explanation: In this case, no transactions are done and the max profit = 0.


Constraints:

1 <= prices.length <= 105
0 <= prices[i] <= 104
 */
