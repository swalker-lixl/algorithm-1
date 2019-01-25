package algorithm.LeetCode;

/**
 * describe:
 *
 * @author lixilong
 * @date 2019/01/25
 */
public class _860_lemonadeChange {

  //方法1： 直接分析，逻辑上覆盖更严谨： 优先花费最大面值的钱
  public boolean lemonadeChange(int[] bills) {
    int five = 0, ten = 0;
    for (int i = 0; i < bills.length; i++)
    {
      if (bills[i] == 5) five++;
      else if (bills[i] == 10) {
        if (five < 1) return false; //先判断return条件
        five--;
        ten++;
      } else {
        if (ten > 0 && five > 0) {
          ten--;
          five--;
        } else if (five > 2) {  //保护判断
          five -= 3;
        } else return false;
      }
    }
    return true;
  }

}
