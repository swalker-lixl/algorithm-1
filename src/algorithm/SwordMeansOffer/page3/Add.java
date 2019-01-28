package algorithm.SwordMeansOffer.page3;

/**
 * describe:
 * 时间限制：1秒 空间限制：32768K 热度指数：86241
 *
 *写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 *
 * @author lixilong
 * @date 2019/01/14
 */
public class Add {

  public static void main(String[] args) {
    Add add = new Add();
    System.out.println( add.add(1,22));
  }
  /*
    链接：https://www.nowcoder.com/questionTerminal/59ac416b4b944300b617d4f7f111b215
    来源：牛客网
    */
/*
public int add(int num1,int num2) {
    while (num2!=0) {
      int temp = num1^num2;
      num2 = (num1&num2)<<1;
      num1 = temp;
    }
    return num1;
  }*/

  /*
  链接：https://www.nowcoder.com/questionTerminal/59ac416b4b944300b617d4f7f111b215
  来源：牛客网
  运行时间：23ms 占用内存：9252k
   位运算
  两个数异或：相当于每一位相加，而不考虑进位；
  两个数相与，并左移一位：相当于求得进位；
  将上述两步的结果相加
  */
  public static int add(int num1,int num2) {
    while( num2!=0 ){
      int sum = num1 ^ num2;
      int carray = (num1 & num2) << 1;
      num1 = sum;
      num2 = carray;
    }
    return num1;
  }

}
