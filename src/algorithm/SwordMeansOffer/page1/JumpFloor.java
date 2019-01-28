package algorithm.SwordMeansOffer.page1;

import java.util.Scanner;

/**
 * describe:
 *   时间限制：1秒 空间限制：32768K 热度指数：324353
 *
 *   一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 * @author lixilong
 * @date 2019/01/10
 */
public class JumpFloor {

  public static void main(String[] args) {
    JumpFloor jumpFloor = new JumpFloor();
    jumpFloor.test();
  }

  public void test(){
    int n;
    Scanner in = new Scanner(System.in);
    n = in.nextInt();
    System.out.println(jumpFloor(n));
  }
  /*//方法1： 递归算法： 运行时间：528ms 占用内存：9372k
  public int jumpFloor(int target) {
    if (target <= 0) {
      return 1;
    }
    if (target == 1) {
      return 1;
    }
    if (target == 2) {
      return 2;
    }else {
      return jumpFloor(target - 1) + jumpFloor(target - 2);
    }
  }*/

  //方法2： 迭代方式：运行时间：18ms 占用内存：9296k
  public int jumpFloor(int target) {
    int pre = 1;
    int prePre = 1;
    int result = 1;
    if (target <= 0) {
      return 1;
    }
    if (target == 1) {
      return 1;
    }
    if (target == 2) {
      return 2;
    }else {
      for (int i = 2; i <= target; i++) {
        result = pre + prePre ;
        prePre = pre;
        pre = result;
      }
      return result;
    }
  }

}
