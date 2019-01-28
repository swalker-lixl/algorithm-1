package algorithm.LeetCode;

/**
 * describe:
 *
 * @author lixilong
 * @date 2019/01/27
 */
public class _70_ClimbStairs {


  public int climbStairs(int n) {
    climb_Stairs(0, n);
  }
  public int climb_Stairs(int i, int n) {
    if (i > n) {
      return 0;
    }
    if (i == n) {
      return 1;
    }
    return climb_Stairs(i + 1, n) + climb_Stairs(i + 2, n);
  }


// Runtime: 2 ms, faster than 100.00%
  public int climbStairs(int n) {
    if (n == 1) {
      return 1;
    }
    int[] dp = new int[n + 1];
    dp[1] = 1;
    dp[2] = 2;
    for (int i = 3; i <= n; i++) {
      dp[i] = dp[i - 1] + dp[i - 2];
    }
    return dp[n];
  }

// Runtime: 2 ms, faster than 100.00%
  public int climbStairs(int n) {
    int[][] q = {{1, 1}, {1, 0}};
    int[][] res = pow(q, n);
    return res[0][0];
  }

  public int[][] pow(int[][] a, int n) {
    int[][] ret = {{1, 0}, {0, 1}};
    while (n > 0) {
      if ((n & 1) == 1) {
        ret = multiply(ret, a);
      }
      n >>= 1;
      a = multiply(a, a);
    }
    return ret;
  }
  public int[][] multiply(int[][] a, int[][] b) {
    int[][] c = new int[2][2];
    for (int i = 0; i < 2; i++) {
      for (int j = 0; j < 2; j++) {
        c[i][j] = a[i][0] * b[0][j] + a[i][1] * b[1][j];
      }
    }
    return c;
  }

  //Runtime: 3 ms, faster than 36.57%

  public int climbStairs(int n) {
    if (n == 1) {
      return 1;
    }
    int first = 1;
    int second = 2;
    for (int i = 3; i <= n; i++) {
      int third = first + second;
      first = second;
      second = third;
    }
    return second;
  }

  // Runtime: 4 ms, faster than 20.15%
  public int climbStairs(int n) {
    double sqrt5=Math.sqrt(5);
    double fibn=Math.pow((1+sqrt5)/2,n+1)-Math.pow((1-sqrt5)/2,n+1);
    return (int)(fibn/sqrt5);
  }

}
