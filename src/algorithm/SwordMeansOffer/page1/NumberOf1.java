package algorithm.SwordMeansOffer.page1;

import java.util.Scanner;

/**
 * describe:
 *时间限制：1秒 空间限制：32768K 热度指数：308489
 *
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 * @author lixilong
 * @date 2019/01/10
 */
public class NumberOf1 {

  public static void main(String[] args) {
    NumberOf1 numberOf1 = new NumberOf1();
    numberOf1.test();
  }

  public void test(){
    int n;
    Scanner in = new Scanner(System.in);
    n = in.nextInt();
    System.out.println(NumberOf1(n));
  }
//运行时间：14ms   占用内存：9192k

/*
把一个整数减去1，再和原整数做与运算，会把该整数最右边一个1变成0.
  那么一个整数的二进制有多少个1，就可以进行多少次这样的操作。
  链接：https://www.nowcoder.com/questionTerminal/8ee967e43c2c4ec193b040ea7fbb10b8
  来源：牛客网

  举个例子：一个二进制数1100，从右边数起第三位是处于最右边的一个1。
  减去1后，第三位变成0，它后面的两位0变成了1，而前面的1保持不变，因此得到的结果是1011.
      我们发现减1的结果是把最右边的一个1开始的所有位都取反了。
  这个时候如果我们再把原来的整数和减去1之后的结果做与运算，
  从原来整数最右边一个1那一位开始所有位都会变成0。如1100&1011=1000.*/
  public int NumberOf1(int n) {
    int countNum = 0 ;
    while (n != 0){
       n = n&(n-1);
       ++ countNum;
    }
    return countNum;
  }
}
