package algorithm.SwordMeansOffer.page2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * describe:
 * 时间限制：1秒 空间限制：32768K 热度指数：328703
 *
 * 输入n个整数，找出其中最小的K个数。
 * 例如输入4,5,1,6,2,7,3,8这8个数字，
 * 则最小的4个数字是1,2,3,4。
 *
 * @author lixilong
 * @date 2019/01/11
 */
public class GetLeastNumbers_Solution {

  public static void main(String[] args) {
    GetLeastNumbers_Solution getLeastNumbers_solution = new GetLeastNumbers_Solution();
    getLeastNumbers_solution.test();
  }

  public void test(){
    int[] array= {4,2,4,1,4,2};
    int[] array1= {1,2,3,2,2,2,5,4,2};
    // System.out.println(MoreThanHalfNum_Solution(array));
   // System.out.println(GetLeastNumbers_Solution(array1).toString());
  }


  /*public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
    ArrayList<Integer> arrayList = new ArrayList();
    if (input.length == 0 || k == 0) {
      return arrayList;
    }

    return (ArrayList)arrayList.subList(0,k);
  }*/

  /*
  来源：牛客网
  链接：https://www.nowcoder.com/questionTerminal/6a296eb82cf844ca8539b57c23e6e9bf
      用最大堆保存这k个数，每次只和堆顶比，如果比堆顶小，删除堆顶，新数入堆。
      运行时间：36ms   占用内存：9552k
  */
  public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {


    ArrayList<Integer> result = new ArrayList<Integer>();
    int length = input.length;
    if(k > length || k == 0){
      return result;
    }
    PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(k, new Comparator<Integer>() {

      @Override
      public int compare(Integer o1, Integer o2) {
        return o2.compareTo(o1);
      }
    });
    for (int i = 0; i < length; i++) {
      if (maxHeap.size() != k) {
        maxHeap.offer(input[i]);
      } else if (maxHeap.peek() > input[i]) {
        Integer temp = maxHeap.poll();
        temp = null;
        maxHeap.offer(input[i]);
      }
    }
    for (Integer integer : maxHeap) {
      result.add(integer);
    }
    return result;
  }





}
