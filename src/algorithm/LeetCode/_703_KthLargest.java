package algorithm.LeetCode;

import java.util.PriorityQueue;

/**
 * describe:
 * 设计一个找到数据流中第K大元素的类（class）。注意是排序后的第K大元素，不是第K个不同的元素。
 *
 * 你的 KthLargest 类需要一个同时接收整数 k 和整数数组nums 的构造器，它包含数据流中的初始元素。
 * 每次调用 KthLargest.add，返回当前数据流中第K大的元素。
 * @author lixilong
 * @date 2019/01/23
 */
public class _703_KthLargest {


  //方法1：保存前K个最大的值，并更新 （入新值排序后剔除K最大之外的 n * klog k）


  //方法2：保存前K个最大的值，并更新 （维护一个小顶堆，堆的大小始终是K  n * log k）
  //主要考察用堆的数据结构，可以避免每次排序所有数据
  PriorityQueue<Integer> q;
  int k;

  public _703_KthLargest(int k, int[] nums) { //构造函数维护一个最小堆
    this.k = k;
    q = new PriorityQueue<Integer>(k); //Java中 PriorityQueue 默认就是最小堆
    for (int num : nums) {
      add(num);  //不断地遍历数组中的元素，并加到队列中
    }
  }

  public int add(int val) {
    if (q.size() < k) {
      q.offer(val); //当 K——堆还没满时，直接加入即可
    } else if (q.peek() < val) {
      q.poll(); //当 K——堆已满时，判断满足条件后，更新K最大堆的最小值[移除+加入]
      q.offer(val);
    }
    return q.peek();
  }

}
