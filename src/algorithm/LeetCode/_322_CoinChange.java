package algorithm.LeetCode;

import java.util.Arrays;

/**
 * describe:
 *
 * @author lixilong
 * @date 2019/01/28
 */
public class _322_CoinChange {


//官方解释和代码: https://leetcode.com/problems/coin-change/solution/

  // Runtime: 19 ms, faster than 62.72%
    public int coinChange(int[] coins, int amount) {
      int max = amount + 1;
      int[] dp = new int[amount + 1];
      Arrays.fill(dp, max);
      dp[0] = 0;
      for (int i = 1; i <= amount; i++) {
        for (int j = 0; j < coins.length; j++) {
          if (coins[j] <= i) {
            dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
          }
        }
      }
      return dp[amount] > amount ? -1 : dp[amount];
    }

//  Runtime: 14 ms, faster than 97.10%
  private static int MAX = 100000000;

  public int coinChange(int[] coins, int amount) {
    int[] dp = new int[amount + 1];
    Arrays.fill(dp, MAX);
    dp[0] = 0;
    for(int c : coins) {
      for(int i = c; i <= amount; i++) {
        dp[i] = Math.min(dp[i], dp[i - c] + 1);
      }
    }
    return dp[amount] == MAX ? -1 : dp[amount];
  }

}
