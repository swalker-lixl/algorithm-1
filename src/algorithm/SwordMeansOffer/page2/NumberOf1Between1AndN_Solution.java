package algorithm.SwordMeansOffer.page2;

import java.util.Scanner;

/**
 * describe:
 *
 * @author lixilong
 * @date 2019/01/11
 */
public class NumberOf1Between1AndN_Solution {
  public static void main(String[] args) {
    NumberOf1Between1AndN_Solution numberOf1Between1AndN_solution = new NumberOf1Between1AndN_Solution();
    numberOf1Between1AndN_solution.test();
  }

  public void test(){
     Scanner in = new Scanner(System.in);
     int intN = in.nextInt();
    // System.out.println(MoreThanHalfNum_Solution(array));
    System.out.println(NumberOf1Between1AndN_Solution(intN));
  }

  /*
  链接：https://www.nowcoder.com/questionTerminal/bd7f978302044eee894445e244c7eee6
  来源：牛客网  运行时间：18ms 占用内存：9412k

  求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？

  可以很快的求出任意非负整数区间中1出现的次数（从1 到 n 中1出现的次数）。
  */
  public int NumberOf1Between1AndN_Solution(int n) {
    if (n <= 0) {
      return 0;
    }
    int count = 0;
    for (long i = 1; i <= n; i *= 10) {
      long diviver = i * 10;
      count += (n / diviver) * i + Math.min(Math.max(n % diviver - i + 1, 0), i);
    }
    return count;
  }


}
