package algorithm.SwordMeansOffer.page1;

import AlgorithmsDS.util.ListNode;
import java.util.ArrayList;

/**
 * describe:
 * 时间限制：1秒 空间限制：32768K 热度指数：358588
 *
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 *
 *
 * https://www.nowcoder.com/practice/d8b6b4358f774294a89de2a6ac4d9337?tpId=13&tqId=11169&tPage=1&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 *
 * @author lixilong
 * @date 2019/01/10
 */
public class MergeList {


  public String print(ListNode head) {
    ArrayList arrayList = new ArrayList();
    while (head != null){
      head = head.next;
      arrayList.add(head.val);
    }
    return arrayList.toString();
  }

  public ListNode merge(ListNode list1,ListNode list2) {
    if (list1 == null) {
      return list2;
    }else if (list2 == null) {
      return list1;
    }
    if (list1.val <= list2.val){
      list1 = merge(list1.next,list2);
      return list1;
    }else {
      list2 = merge(list1,list2.next);
      return list2;
    }
  }


/*  public ListNode Merge(ListNode list1,ListNode list2) {
    ListNode head = null;
    ListNode pre = null;
    ListNode current = null;
    ListNode headList1 = list1;
    ListNode headList2 = list2;
    if (list1 == null) {
      return list2;
    }else if (list2 == null) {
      return list1;
    }else if (list1.val <= list2.val){
      mergeTwoList(list1,list2); //对两个链表都不为null的情形合并
    }
  }


  public ListNode mergeTwoList(ListNode list1,ListNode list2) {
    ListNode head = null;
    ListNode pre = null;
    ListNode current = null;
    current.next = pre;
    if (list1.val <= list2.val){
      current = list1;
      list1 = list1.next;
    } else {
      current = list2;
      list2 = list2.next;
    }
  }*/

}
