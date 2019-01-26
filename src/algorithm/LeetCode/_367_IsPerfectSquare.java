package algorithm.LeetCode;

/**
 * describe:
 *
 * @author lixilong
 * @date 2019/01/26
 */
public class _367_IsPerfectSquare {

//  time complexity  O(sqrt(n)),  time complexity is O(log(n)):
//  Runtime: 0 ms, faster than 100.00%
  public boolean isPerfectSquare(int num) {
    int i = 1;
    while (num > 0) {
      num -= i;
      i += 2;
    }
    return num == 0;
  }

  //  Runtime: 0 ms, faster than 100.00%
  public boolean isPerfectSquare(int num) {
    long x = num;
    while (x * x > num) {
      x = (x + num / x) >> 1;
    }
    return x * x == num;
  }



}
