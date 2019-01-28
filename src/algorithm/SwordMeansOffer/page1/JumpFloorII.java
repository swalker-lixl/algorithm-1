package algorithm.SwordMeansOffer.page1;

import java.util.Scanner;

/**
 * describe:
 *
 * @author lixilong
 * @date 2019/01/10
 */
public class JumpFloorII {



  public static void main(String[] args) {
    JumpFloorII jumpFloorII = new JumpFloorII();
    jumpFloorII.test();
  }

  public void test(){
    int n;
    Scanner in = new Scanner(System.in);
    n = in.nextInt();
    System.out.println(jumpFloorII(n));
  }
  /*

  总结归纳法可以得出：
  链接：https://www.nowcoder.com/questionTerminal/22243d016f6b47f2a6928b4313c85387
2）n = 1时，只有1种跳法，f(1) = 1
3) n = 2时，会有两个跳得方式，一次1阶或者2阶，这回归到了问题（1） ，f(2) = f(2-1) + f(2-2)
4) n = 3时，会有三种跳得方式，1阶、2阶、3阶，
5) n = n时，会有n中跳的方式，1阶、2阶...n阶，得出结论：
    f(n) = f(n-1)+f(n-2)+...+f(n-(n-1)) + f(n-n) => f(0) + f(1) + f(2) + f(3) + ... + f(n-1)
6) 由以上已经是一种结论，但是为了简单，我们可以继续简化：
    f(n-1) = f(0) + f(1)+f(2)+f(3) + ... + f((n-1)-1) = f(0) + f(1) + f(2) + f(3) + ... + f(n-2)
    f(n) = f(0) + f(1) + f(2) + f(3) + ... + f(n-2) + f(n-1) = f(n-1) + f(n-1)
    可以得出：
    f(n) = 2*f(n-1)

  //方法1： 递归算法：运行时间：18ms  占用内存：9292k
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
      return 2*jumpFloor(target - 1);
    }
  }*/

  //方法2： 迭代方式：运行时间：18ms 占用内存：9296k
  public int jumpFloorII(int target) {
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
