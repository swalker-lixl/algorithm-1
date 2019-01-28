package algorithm.LeetCode;

/**
 * describe:
 *
 * @author lixilong
 * @date 2019/01/28
 */
public class _714_MaxProfit {

  //官方答案： https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/solution/


  // Runtime: 10 ms, faster than 46.24%
  public int maxProfit(int[] prices, int fee) {
    int cash = 0, hold = -prices[0];
    for (int i = 1; i < prices.length; i++) {
      cash = Math.max(cash, hold + prices[i] - fee);
      hold = Math.max(hold, cash - prices[i]);
    }
    return cash;
  }

}
