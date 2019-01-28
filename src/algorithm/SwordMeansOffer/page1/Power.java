package algorithm.SwordMeansOffer.page1;

import java.util.Scanner;

/**
 * describe:
 *时间限制：1秒 空间限制：32768K 热度指数：317653
 *
 * 给定一个double类型的浮点数base和int类型的整数exponent。
 * 求base的exponent次方。（base、exponent均可正可负）
 * @author lixilong
 * @date 2019/01/10
 */
public class Power {

  public static void main(String[] args) {
    Power power = new Power();
    power.test();
  }

  public void test(){
    double base;
    int power;
    Scanner in = new Scanner(System.in);
    base = in.nextDouble();
    power = in.nextInt();
    System.out.println(Power(base, power));
  }

     //运行时间：48ms  占用内存：10368k
  public double Power(double base, int exponent) {
    /*链接：https://www.nowcoder.com/questionTerminal/1a834e5e3e1a4b7ba251417554e07c00
    来源：牛客网
    幂运算
    */

    long  power = Math.abs((long)exponent);
    double r = 1.0;
    while(power >0 ){
      if((power & 1) > 0) r *= base;  //关键两句话 1：
      base *= base;
      power >>= 1; //关键两句话 2：
    }
    return exponent < 0 ? 1/ r : r;
  }
}
