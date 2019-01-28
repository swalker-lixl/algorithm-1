package algorithm.SwordMeansOffer.page3;

import java.util.ArrayList;

/**
 * describe:
 *
 * @author lixilong
 * @date 2019/01/14
 */
public class FindNumbersWithSum {


  public static void main(String[] args) {
    FindContinuousSequence findContinuousSequence = new FindContinuousSequence();
    findContinuousSequence.test();
  }

  public void test(){
    int[] array = {58, 59, 60, 61, 62};
    /*int n;
    Scanner in = new Scanner(System.in);
    n = in.nextInt();*/
    System.out.println(findNumbersWithSum(array,120));
  }

  /*
  链接：https://www.nowcoder.com/questionTerminal/390da4f7a00f44bea7c2f3d19491311b
  来源：牛客网
  运行时间：18ms 占用内存：9396k

  链接：https://www.nowcoder.com/questionTerminal/390da4f7a00f44bea7c2f3d19491311b
  来源：牛客网

  开始还在纠结乘积最小，后来转念一想，a+b=sum,a和b越远乘积越小，
  而一头一尾两个指针往内靠近的方法找到的就是乘积最小的情况。
  如果是乘积最大的情况就是一直找到两个指针重合，每次找到一个就将之前返回的结果向量清空然后更新为新找到的。

 * 分析：
 * 通常的想法是先找到满足条件的数组对，然后比较他们的乘积取乘积最小的一组，
 * 所以数组必须要遍历完，可是我们通过数学公式推导，发现按第一数从小到大的
 * 排序，第一组的乘积一定最小，所以我们只需要从数组两端来查找满足条件的两
 * 个数，即为题目要找的数对。
 * 结论证明：
 * 假设：找到两组满足条件的数组对（x，y）、（x+a,y-a），其中（x+y=S, 0<a<y-x）
 * x*y-[(x+a)(y-a)]
 *  =x*y-x*y-(y-x)a+a2
 *  =a[a-(y-x)]
 *  因为0<a<y-x,所以a-(y-x)<0,所以a[a-(y-x)]<0
 *  因此(x,y)乘积一定比(x+a,y-a)小
 */


  public ArrayList<Integer> findNumbersWithSum(int[] array, int sum) {
    ArrayList<Integer> list = new ArrayList<Integer>();
    if (array == null || array.length < 2) {
      return list;
    }
    int i = 0, j = array.length - 1;
    while (i < j) {
      if (array[i] + array[j] == sum) {
        list.add(array[i]);
        list.add(array[j]);
        return list;
      } else if (array[i] + array[j] > sum) {
        j--;
      } else {
        i++;
      }

    }
    return list;
  }
/*
  public ArrayList<Integer> findNumbersWithSum(int[] array, int sum) {

    for (int i = 0; i < (array.length + 1) / 2; i++) {
      ArrayList supplyArrray = new ArrayList();
      int supply = sum - i;
      for (int j = i; j < array.length; j++) {
        if (j == supply) {
          supplyArrray.add(j);
        }
      }
      if (supplyArrray.size() > 1) {
        int mutlplay = i;
        for () {
          if (supplyArrray.get(i) * mutlplay) {
            ;
          }
        }

      }
    }

  }*/

}
