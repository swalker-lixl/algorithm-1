package algorithm.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * describe:
 *
 * @author lixilong
 * @date 2019/01/19
 */
public class _22_GenerateParenthesis {


/*
* 方法1 ：数学归纳法
* 方法2 ：构建一个2*N大小的数组，对所有可能组合筛选
* 方法3 ：剪枝：在2的基础上改进
*
*
* */

// 方法1： Simple Java DFS solution
  public List<String> generateParenthesis(int n) {
    List<String> result = new ArrayList();
    dfs(n, n, result, "");
    return result;
  }

  private void dfs(int left, int right, List<String> result, String s) {
    if (left == 0 && right == 0) result.add(s);
    else {
      if (left > 0) dfs(left - 1, right, result, s + "(");
      if (right > left) dfs(left, right - 1, result, s + ")");
    }
  }

// 方法2： Simple Java DFS solution
public List<String> generateParenthesis(int n) {
  List<String> result = new ArrayList();
  if (n == 0) return result;

  fill(result, "", n, n);

  return result;
}

  private void fill(List<String> result, String prefix, int openRemain, int closeRemain) {
    if (openRemain ==0 && closeRemain ==0) {
      result.add(prefix); // all parans are used, let's add it to the list.
      return;
    }

    if (openRemain > closeRemain) return; //we have more close then open, go back in backtracking

    if (openRemain>0) fill(result,  prefix + "(", openRemain-1, closeRemain);
    if (closeRemain>0) fill(result, prefix + ")", openRemain, closeRemain-1);
  }


}
