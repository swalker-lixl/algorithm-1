package algorithm.LeetCode;

/**
 * describe:
 *
 * @author lixilong
 * @date 2019/01/28
 */
public class _309_MaxProfit {


  //经典解释： https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/discuss/147897/Java-O(n)-time-O(1)-space-solution-with-detailed-thinking-and-improving-process


  /* Keep two DP arrays, one for sell, one for cooldown
   * sell[i] means the maximum profit gains at day i by selling at day i
   * cooldown[i] means the maximum profit gains at day i by doing nothing at day i
   * Since we can never get maximum profit at day i by buying stock at day i, so do not need to consider the buy array
   */

  /* Method 1, time O(n ^ 2), space O(n)
   * 1. update cooldown[i] is easy, cooldown[i] = Math.max(cooldown[i - 1], sell[i - 1]);
   * 2. for update sell[i], need to scan j from 0 -> i - 1, sell[i] will be the maximum of cooldown[j - 1] + (prices[i] - prices[j])
   * means cooldown at day j - 1, and buy at day j, and sell at day i;
   * 3. Pay attention to the boundy conditon, when j == 0, cooldown[j - 1] is not defined, use 0 instead
   * 4. The maximum profit is either sell[n - 1] or cooldown[n - 1];
   */
    public int maxProfit(int[] prices) {
      if (prices == null || prices.length == 0) return 0;
      int n = prices.length;
      int[] sell = new int[n];
      int[] cooldown = new int[n];
      for (int i = 1; i < n; i++) {
        cooldown[i] = Math.max(cooldown[i - 1], sell[i - 1]);
        for (int j = 0; j < i; j++) {
          if (j == 0) sell[i] = Math.max(sell[i], prices[i] - prices[j]);
          else sell[i] = Math.max(sell[i], cooldown[j - 1] + prices[i] - prices[j]);
        }
      }
      return Math.max(sell[n - 1], cooldown[n - 1]);
    }


  /* Method 2, time O(n), space O(n)
   * In the previous method, for updating sell[i], we need to scan from 0 -> i - 1, but if you pay attention to the transition expression,
   * all we need is the maximum of cooldown[j - 1] - prices[j] from j = 0 -> j= i - 1,
   * so we can use a variable diff to store this value, to avoid the loop;
   * then the time expense will be just O(n)...
   */
    public int maxProfit(int[] prices) {
      if (prices == null || prices.length == 0) return 0;
      int n = prices.length;
      int[] sell = new int[n];
      int[] cooldown = new int[n];
      int diff = -prices[0];
      for (int i = 1; i < n; i++) {
        cooldown[i] = Math.max(cooldown[i - 1], sell[i - 1]);
        sell[i] = Math.max(sell[i], prices[i] + diff);
        diff = Math.max(diff, cooldown[i - 1] - prices[i]);
      }
      return Math.max(sell[n - 1], cooldown[n - 1]);
    }



  /* Method 3, time O(n), space O(1)
   * If you take a look at method 2, when we update cooldown[i] or sell[i], we only need variable from i - 1;
   * thus there is no need to store the whole array, we can just use two variables to store the data
   * so the space cost wil be O(1)
   */

  // Runtime: 10 ms, faster than 25.69%
    public int maxProfit(int[] prices) {
      if (prices == null || prices.length == 0) return 0;
      int n = prices.length;
      int sell = 0;
      int cooldown = 0;
      int diff = -prices[0];
      for (int i = 1; i < n; i++) {
        int temp = cooldown;
        cooldown = Math.max(cooldown, sell);
        sell = Math.max(sell, prices[i] + diff);
        diff = Math.max(diff, temp - prices[i]);
      }
      return Math.max(sell, cooldown);
    }

  // Runtime: 7 ms, faster than 69.44%
    public int maxProfit(int[] prices) {
      int sell = 0, prev_sell = 0, buy = Integer.MIN_VALUE, prev_buy;
      for(int price : prices){
        prev_buy = buy;
        buy = Math.max(prev_sell-price, prev_buy);
        prev_sell = sell;
        sell = Math.max(prev_buy + price, prev_sell);
      }
      return sell;
    }

}
