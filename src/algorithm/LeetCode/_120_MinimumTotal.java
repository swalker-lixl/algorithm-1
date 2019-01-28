package algorithm.LeetCode;

import java.util.List;

/**
 * describe:
 *
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 *
 * 例如，给定三角形：
 *
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 *
 * 说明：
 *
 * 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
 *
 * @author lixilong
 * @date 2019/01/28
 */
public class _120_MinimumTotal {

  // Runtime: 3 ms, faster than 100.00%
  public int minimumTotal(List<List<Integer>> trgl) {
    int sz = trgl.size();
    int[] results = new int[sz+1];

    for(int i=sz-1; i>=0; i--) {
      List<Integer> tmp = trgl.get(i);

      for(int j=0; j<tmp.size(); j++) {
        results[j] = Math.min(results[j], results[j+1]) + tmp.get(j);
      }
    }
    return results[0];
  }

  // Runtime: 3 ms, faster than 100.00%
  public int minimumTotal(List<List<Integer>> triangle) {
    int h = triangle.size();
    int[][] memo = new int[h][h];
    if(h == 1){
      return triangle.get(0).get(0);
    }
    return helper(1,0,memo,triangle);
  }
  private int helper(int n, int i, int[][] memo, List<List<Integer>> tr){
    if(n == tr.size()){
      memo[n-1][i] = tr.get(n-1).get(i);
      return memo[n-1][i];
    }
    if(memo[n][i] != 0 && memo[n][i+1] != 0){
      memo[n-1][i] = Math.min(memo[n][i],memo[n][i+1])+tr.get(n-1).get(i);
    }
    if(memo[n][i] != 0 && memo[n][i+1] == 0){
      memo[n-1][i] = Math.min(memo[n][i],helper(n+1,i+1,memo,tr))+tr.get(n-1).get(i);
    }
    if(memo[n][i] == 0 && memo[n][i+1] != 0){
      memo[n-1][i] = Math.min(helper(n+1,i,memo,tr),memo[n][i+1])+tr.get(n-1).get(i);
    }
    if(memo[n][i] == 0 && memo[n][i+1] == 0){
      memo[n-1][i] = Math.min(helper(n+1,i,memo,tr),helper(n+1,i+1,memo,tr))+tr.get(n-1).get(i);
    }
    return memo[n-1][i];
  }

}
