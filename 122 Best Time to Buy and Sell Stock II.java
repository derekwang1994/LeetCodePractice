// Say you have an array for which the ith element is the price of a given stock on day i.
// Design an algorithm to find the maximum profit.
// You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times).
// However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

Solution1:
  Add every profit after sell.

public class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int i= 0;
        while(i<prices.length){
            int minPrice = Integer.MAX_VALUE;
            int maxPrice = 0;
            while( i<prices.length && prices[i] < minPrice){
                minPrice = prices[i];
                i++;
            }
            while( i<prices.length && prices[i] > maxPrice ){
                maxPrice = prices[i];
                i++;
            }
            if(maxPrice!=0){
                profit = profit + (maxPrice - minPrice);
            }
        }
        return profit;
    }
}

Solution2: (fastest)
  Add every increase value compare to the last one.

public class Solution {
  public int maxProfit(int[] prices) {

      int maxProfit = 0;

      for(int i=0; i<prices.length; i++){
          if(i!=0 && prices[i] > prices[i-1]){
              maxProfit += prices[i] - prices[i-1];
          }
      }

      return maxProfit;
  }
}
