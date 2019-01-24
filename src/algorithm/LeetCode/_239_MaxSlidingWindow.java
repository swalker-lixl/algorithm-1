package algorithm.LeetCode;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * describe:
 *
 * @author lixilong
 * @date 2019/01/23
 */
public class _239_MaxSlidingWindow {


  PriorityQueue<Integer> q;
  int k;


  //方法1：直接建一个大顶堆，然后维护大顶堆，挨个遍历即可 【】 时间复杂度：N * log k
  //参照： 杨伟健 实现
  public int[] maxSlidingWindow(int[] nums, int k) {
    if (k == 0) {
      return nums;
    }
    PriorityQueue<Integer> queue = new PriorityQueue(k,  new Comparator<Integer>() {
      @Override
      public int compare(Integer o1, Integer o2) {
        return o2-o1;
      }
    });
    for (int i = 0; i < k; i++) {
      queue.add(nums[i]);
    }//先填满，后更新

    int[] res = new int[nums.length - k + 1];
    for (int i = 0; i < res.length; i++) {
      res[i] = queue.peek();
      queue.remove(nums[i]);
      if (i + k < nums.length) {
        queue.add(nums[i + k]);
      }
    }
    return res;
  }



  //方法2：利用双端队列，因为只要最大值，所以简单实现「Deque [用数组可以实现] 【】 时间复杂度：N 」
  //参考评论 「缱绻」：https://time.geekbang.org/course/detail/130-41561

 /* public int[] maxSlidingWindow(int[] a, int k) {
      if (a == null || k <= 0) {
        return new int[0];
      }
      int n = a.length;
      int[] r = new int[n-k+1];
      int ri = 0;
// store index
      Deque<Integer> q = new ArrayDeque();
      for (int i = 0; i < a.length; i++) {
// remove numbers out of range k
        while (!q.isEmpty() && q.peek() < i - k + 1) {
          q.poll();
        }
// remove smaller numbers in k range as they are useless
        while (!q.isEmpty() && a[q.peekLast()] < a[i]) {
          q.pollLast();
        }
// q contains index... r contains content
        q.offer(i);
        if (i >= k - 1) {
          r[ri++] = a[q.peek()];
        }
      }
      return r;
  }*/

}
