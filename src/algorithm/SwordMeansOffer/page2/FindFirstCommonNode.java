package algorithm.SwordMeansOffer.page2;

import AlgorithmsDS.util.ListNode;

/**
 * describe:
 *
 * @author lixilong
 * @date 2019/01/11
 */
public class FindFirstCommonNode {

  public static void main(String[] args) {
    FindFirstCommonNode findFirstCommonNode = new FindFirstCommonNode();
    findFirstCommonNode.test();
  }

  public void test(){
    ListNode node1 = new ListNode(1);
    ListNode node2 = new ListNode(2);
    ListNode node3 = new ListNode(3);
    ListNode node4 = new ListNode(4);
    ListNode node5 = new ListNode(5);
    ListNode node6 = new ListNode(6);
    ListNode node7 = new ListNode(7);
    node1.next = node2;
    node2.next = node3;
    node3.next = null;

    node4.next = node5;
    node5.next = null;


 /*   node6.next = node7;
    node7.next = null;*/

    System.out.println(FindFirstCommonNode(node1, node4).val);
  }

  /*
  找出2个链表的长度，然后让长的先走两个链表的长度差，然后再一起走
  （因为2个链表用公共的尾部）
   运行时间：24ms  占用内存：9584k
  */
  public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
    int lenthList1 = findListLength(pHead1);
    int lenthList2 = findListLength(pHead2);
    int less = lenthList1 -lenthList2;
    if (lenthList1 < lenthList2) { //维护认为list1是较长的链表
      ListNode tmpNode = pHead1;
      pHead1 = pHead2;
      pHead2 = tmpNode;
      less = - less;
    }
    if (pHead1 == null || pHead2 == null) {
      return null;
    }
    for (int i = 0; i < less; i++) {
      pHead1 = pHead1.next;
    }
    while (pHead1.val != pHead2.val) {
      if (pHead1.next == null && pHead2.next == null) {
        return null;
      }
      pHead1 = pHead1.next;
      pHead2 = pHead2.next;
    }
    return pHead1;
  }

  public int findListLength (ListNode pHead) {
    int count = 0;
    while (pHead != null) {
      ++count;
      pHead = pHead.next;
    }
    return count;
  }

}
