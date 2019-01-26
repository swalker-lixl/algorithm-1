package algorithm.LeetCode;

/**
 * describe:
 *
 * @author lixilong
 * @date 2019/01/19
 */
public class _338_CountBits {


  public int[] countBits(int num) {
    int arr[]= new int[num+1];
    for(int i = 0; i <=num; i++){
      int n=i;
      int count=0;
      while(n>0){
        n=n&(n-1);
        count++;
      }
      arr[i]=count;
    }
    return arr;
  }



}
