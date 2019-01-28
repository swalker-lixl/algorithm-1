package algorithm.SwordMeansOffer.page3;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * describe:
 * 时间限制：1秒 空间限制：32768K 热度指数：171437
 *
 * 题目描述
 * 你能不能也很快的找出所有和为S的连续正数序列?
 *
 * 输出描述:
 * 输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 *
 * @author lixilong
 * @date 2019/01/14
 */
public class FindContinuousSequence {
  public static void main(String[] args) {
    FindContinuousSequence findContinuousSequence = new FindContinuousSequence();
    findContinuousSequence.test();
  }

  public void test(){
    int n;
    Scanner in = new Scanner(System.in);
    n = in.nextInt();
    System.out.println(findContinuousSequence(n));
  }

  /*运行时间：22ms 占用内存：9408k*/
 /* public ArrayList<ArrayList<Integer>> findContinuousSequence(int sum) {
    ArrayList arrayList = new ArrayList();

    for (int n = (int) Math.sqrt(2 * sum); n >= 2; n--) {  //：S = (1 + n) * n / 2
      if ((n & 1) == 1 && sum % n == 0 || (sum % n) * 2 == n) { //满足条件的n 奇偶对应的条件
        ArrayList<Integer> list = new ArrayList();
        for (int j = 0, k = (sum / n) - (n - 1) / 2; j < n; j++, k++) {
          list.add(k);
        }
        arrayList.add(list);
      }
    }
    return arrayList;
  }*/

  /*运行时间：运行时间：28ms  占用内存：9592k */
    public ArrayList<ArrayList<Integer>> findContinuousSequence(int sum) {
  //存放结果
      ArrayList<ArrayList<Integer>> result = new ArrayList();
      //两个起点，相当于动态窗口的两边，根据其窗口内的值的和来确定窗口的位置和大小
      int plow = 1, phigh = 2;
      while (phigh > plow) {
        //由于是连续的，差为1的一个序列，那么求和公式是(a0+an)*n/2
        int cur = (phigh + plow) * (phigh - plow + 1) / 2;
        //相等，那么就将窗口范围的所有数添加进结果集
        if (cur == sum) {
          ArrayList<Integer> list = new ArrayList();
          for (int i = plow; i <= phigh; i++) {
            list.add(i);
          }
          result.add(list);
          plow++;
          //如果当前窗口内的值之和小于sum，那么右边窗口右移一下
        } else if (cur < sum) {
          phigh++;
        } else {
          //如果当前窗口内的值之和大于sum，那么左边窗口右移一下
          plow++;
        }
      }
      return result;
    }
}
