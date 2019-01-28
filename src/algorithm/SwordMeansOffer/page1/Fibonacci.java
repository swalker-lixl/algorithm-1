package algorithm.SwordMeansOffer.page1;

import java.util.Scanner;

/**
 * describe:
 *时间限制：1秒 空间限制：32768K 热度指数：420569
 *
 * 大家都知道斐波那契数列。 aN= a(N-1)+ a(N-2)  F[n]=F[n-1]+F[n-2] (n>=3,F[1]=1,F[2]=1)
 * 现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。 n<=39
 *
 * @author lixilong
 * @date 2019/01/10
 */
public class Fibonacci {


  public static void main(String[] args) {
    Fibonacci fibonacci = new Fibonacci();
    fibonacci.test();
  }

  public void test(){
    int n;
    Scanner in = new Scanner(System.in);
    n = in.nextInt();
    System.out.println(fibonacci(n));
  }
  /*  //方法1： 递归方式  运行时间：1425ms   占用内存：9080k
  public int fibonacci(int n) {
    if (n > 39) {  //注意边界，39不认为是非法输入
      throw new RuntimeException("n should be lower 39 ! ");
    }
    if (n == 0) { //注意边界，0 返回应该是0
      return 0;
    } else if (n == 1) {
      return 1;
    } else {
      return fibonacci(n - 1) + fibonacci(n - 2);
    }*/

    //方法2： 循环方式   运行时间：20ms 占用内存：9264k
    public int fibonacci(int n) {
      int pre = 1;
      int result = 0;
      int prePre = 0; //初始化的值竟然能赋值错，好好检查边界，边界case要走一遍确定无误【初期】
      if (n > 39) {  //注意边界，39不认为是非法输入
        throw new RuntimeException("n should be lower 39 ! ");
      }
      if (n <= 0) { //注意边界，0 返回应该是0
        return 0;
      } else if (n == 1) {
        return 1;
      }
      for (int i = 2; i <= n; i++) {
        result = pre + prePre;
        prePre = pre;
        pre = result;
      }
      return result;
    }

}
