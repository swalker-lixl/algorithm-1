package algorithm.LeetCode;

/**
 * describe:
 *
 * @author lixilong
 * @date 2019/01/19
 */
public class _231_IsPowerOfTwo {


  //方法1： 不断%2
  //方法2： 取以2为底的对数
  //方法3： x&（x-1）==0


  public boolean isPowerOfTwo(int n) {
    return n <= 0 ? false : ( n & ( n-1 ) ) == 0 ;
  }



  public boolean isPowerOfTwo(int n) {
    if ( n <= 0){
      return false;
    }
    if (n ==1){
      return true;
    }
    while(n > 1){
      if((n & 1) == 1){
        return false;
      }
      n = n >> 1;
    }
    return true;
  }


}
