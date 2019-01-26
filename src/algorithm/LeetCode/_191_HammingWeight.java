package algorithm.LeetCode;

/**
 * describe:
 *
 * @author lixilong
 * @date 2019/01/19
 */
public class _191_HammingWeight {


  // you need to treat n as an unsigned value
  /*//方法1：位运算 计数
  public int hammingWeight(int n) {

  }*/
  //方法2：%2 计数   负数的补码 与计算
/*  public int hammingWeight(int n) {
    while ( n != 0) {

    }
  }*/
  // Runtime: 1 ms, faster than 91.13%
  public int hammingWeight(int n) {
    int bits = 0;
    int mask = 1;
    for (int i = 0; i < 32; i++) {
      if ((n & mask) != 0) {
        bits++;
      }
      mask <<= 1;
    }
    return bits;
  }

  // Runtime: 0 ms, faster than 100.00%
  public int hammingWeight(int n) {
    int sum = 0;
    while (n != 0) {
      sum++;
      n &= (n - 1);
    }
    return sum;
  }

}
