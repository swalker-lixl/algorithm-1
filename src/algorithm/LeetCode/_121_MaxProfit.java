package algorithm.LeetCode;

/**
 * describe:
 *
 * @author lixilong
 * @date 2019/01/28
 */
public class _121_MaxProfit {\

  //官方解法： https://leetcode.com/problems/best-time-to-buy-and-sell-stock/solution/

  // Runtime: 1 ms, faster than 99.88%
  public int maxProfit(int prices[]) {
    int minprice = Integer.MAX_VALUE;
    int maxprofit = 0;
    for (int i = 0; i < prices.length; i++) {
      if (prices[i] < minprice)
        minprice = prices[i];
      else if (prices[i] - minprice > maxprofit)
        maxprofit = prices[i] - minprice;
    }
    return maxprofit;
  }


}
