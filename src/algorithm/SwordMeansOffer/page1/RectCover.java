package algorithm.SwordMeansOffer.page1;

import java.util.Scanner;

/**
 * describe:
 *  时间限制：1秒 空间限制：32768K 热度指数：231377
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
 * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 * @author lixilong
 * @date 2019/01/10
 */
public class RectCover {


  public static void main(String[] args) {
    RectCover rectCover = new RectCover();
    rectCover.test();
  }

  public void test(){
    int n;
    Scanner in = new Scanner(System.in);
    n = in.nextInt();
    System.out.println(rectCover(n));
  }


 /* //通过分析一块的摆放方式，归纳出前后之间的联系，由此发现斐波那契数列的规律
  //方法1： 递归算法： 运行时间：611ms   占用内存：9192k
  public int rectCover(int target) {
    if (target <= 0) {
      return 0;
    } else if (target <= 1) {
      return 1;
    } else if (target * 2 == 2) {
      return 1;
    } else if (target * 2 == 4) {
      return 2;
    } else {
      return rectCover(target - 1) + rectCover(target - 2);
    }
  }
  */

  //通过分析一块的摆放方式，归纳出前后之间的联系，由此发现斐波那契数列的规律
  //方法2： 迭代算法： 运行时间：运行时间：15ms 占用内存：9288k
  public int rectCover(int target) {
   /* if (target <= 0) {
      return 0;
    } else if (target <= 1) {
      return 1;
    } else if (target * 2 == 2) {
      return 1;
    } else if (target * 2 == 4) {
      return 2;
    } else {
      return rectCover(target - 1) + rectCover(target - 2);
    }*/
    if ( target < 1 ) return 0;
    int pre = 1, prePre = 2;
    while ( (--target) > 0 ) {
      prePre = prePre + pre; //prePre 计算汇总结果
      pre = prePre - pre;    //prePre 的值赋给pre
    }
    return pre;
/*  两种方式区分总结
      for (int i = 2; i <= target; i++) {
        result = pre + prePre ;
        prePre = pre;
        pre = result;
      }
      return result;
*/
  }

}
