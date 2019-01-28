package algorithm.SwordMeansOffer.page2;

/**
 * describe:
 *时间限制：1秒 空间限制：32768K 热度指数：181271
 *例如:
 *  {6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。
 *  给一个数组，返回它的最大连续子序列的和，你会不会被他忽悠住？(子向量的长度至少是1)
 * @author lixilong
 * @date 2019/01/11
 */
public class FindGreatestSumOfSubArray {

  public static void main(String[] args) {
    FindGreatestSumOfSubArray findGreatestSumOfSubArray = new FindGreatestSumOfSubArray();
    findGreatestSumOfSubArray.test();
  }

  public void test() {
    int[] array = {4, 2, 4, 1, 4, 2};
    int[] array1 = {1, 2, 3, 2, 2, 2, 5, 4, 2};
    // System.out.println(MoreThanHalfNum_Solution(array));
    //System.out.println(GetLeastNumbers_Solution(array1).toString());
  }
  // 方法1，递归调用  运行时间：16ms 占用内存：9288k
  public int findGreatestSumOfSubArray(int[] array) {
    if (array.length == 1) {
      return array[0];
    }
    int res = array[0]; //记录当前所有子数组的和的最大值
    int max=array[0];   //包含array[i]的连续数组最大值
    for (int i = 1; i < array.length; i++) {
      max=Math.max(max+array[i], array[i]);
      res=Math.max(max, res);
    }
    return res;
  }

 /*// 方法2，迭代调用  运行时间：16ms 占用内存：9288k   待测
  public int findGreatestSumOfSubArray(int[] array) {
    if(array.length==0||array==null)  {    return 0;  }
    int curSum = 0;
    int greatestSum = 0x80000000;
    for(  int i = 0;  i<array.length;i++)  {
      if (curSum <= 0) {
        curSum = array[i]; //记录当前最大值
      } else {
        curSum += array[i]; //当array[i]为正数时，加上之前的最大值并更新最大值。
      }
      if (curSum > greatestSum) {
        greatestSum = curSum;
      }
    }
    return greatestSum;
  }*/

}
