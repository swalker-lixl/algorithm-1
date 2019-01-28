package algorithm.LeetCode;

/**
 * describe:
 *
 * @author lixilong
 * @date 2019/01/28
 */
public class _123_MaxProfit {


 // Runtime: 3 ms, faster than 60.33%
  public int maxProfit(int[] prices) {
    if (prices == null || prices.length < 2) {
      return 0;
    }

    // scan the arr from left and record max profit for each cut
    int[] fromLeft = new int[prices.length];
    int min = prices[0];
    for(int i = 1; i < prices.length; i++) {
      fromLeft[i] = Math.max(prices[i] - min, fromLeft[i-1]);
      min = Math.min(min, prices[i]);
    }

    // scan the arr from right and record max profit for each cut
    int[] fromRight = new int[prices.length];
    int max = prices[prices.length - 1];
    for(int i = prices.length - 2; i >= 0; i--) {
      fromRight[i] = Math.max(max - prices[i], fromRight[i+1]);
      max = Math.max(max, prices[i]);
    }

    int res = 0;
    for(int i = 0; i < fromLeft.length; i++) {
      res = Math.max(res, fromLeft[i] + fromRight[i]);
    }

    return res;
  }

}
