package algorithm.SwordMeansOffer.page3;

import AlgorithmsDS.util.ListNode;

/**
 * describe:
 * 时间限制：1秒 空间限制：32768K 热度指数：136830
 *
 *
 * 给一个链表，若其中包含环。
 * 请找出该链表的环的入口结点，否则，输出null。
 *
 * @author lixilong
 * @date 2019/01/18
 */
public class EntryNodeOfLoop {

  public static void main(String[] args) {
    EntryNodeOfLoop entryNodeOfLoop = new EntryNodeOfLoop();
    entryNodeOfLoop.test();
  }

  // 运行时间：14ms  占用内存：9352k
  public  void test() {

  }


  /*//方法1： set存值对比 运行时间：22ms 占用内存：9560k    时间复杂度O（n*1）
  public ListNode EntryNodeOfLoop(ListNode pHead) {
    HashSet listNodeSet = new HashSet();
    ListNode currentNode = pHead;
    while (currentNode != null) {
      listNodeSet.add(currentNode);
      currentNode = currentNode.next;
      if (listNodeSet.contains(currentNode)) {
        return currentNode;
      }
    }
    return currentNode;
  }*/
  //方法2： 龟兔赛跑式
  public ListNode EntryNodeOfLoop(ListNode pHead) {
    ListNode fast = pHead;
    ListNode slow = pHead;
    while (slow != null && fast != null &&  fast.next != null ) {
      fast = fast.next.next;
      slow = slow.next;
      if (fast == slow) {
        return slow;
      }
    }
    return null;
  }


}
