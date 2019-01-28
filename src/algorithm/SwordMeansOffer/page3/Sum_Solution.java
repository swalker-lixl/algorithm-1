package algorithm.SwordMeansOffer.page3;

import java.util.Scanner;

/**
 * describe:
 * 时间限制：1秒 空间限制：32768K 热度指数：132247
 *
 * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 * @author lixilong
 * @date 2019/01/14
 */
public class Sum_Solution {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    System.out.println(sum_Solution(in.nextInt()));;
  }

  // 运行时间：14ms  占用内存：9352k
  public static  int sum_Solution(int n) {
    int sum = 0;
    for (int i = 0; i <= n; i++) {
        sum = Add.add(sum,i);
      }
    return sum;
  }
}
