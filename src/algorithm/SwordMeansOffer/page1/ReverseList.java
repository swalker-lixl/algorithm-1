package algorithm.SwordMeansOffer.page1;

import AlgorithmsDS.util.ListNode;

/**
 * describe:
 * 时间限制：1秒 空间限制：32768K 热度指数：376619
 *
 *
 * 输入一个链表，反转链表后，输出新链表的表头。
 * @author lixilong
 * @date 2019/01/10
 *
 * ￥￥￥￥￥ 先考虑各种case和逻辑块，抽象出方法，然后想好实现策略和所需主要变量
 */
public class ReverseList {


  //运行时间：24ms   占用内存：9740k
  public ListNode ReverseList(ListNode head) {
    if (head == null) return null;


    /*
    链接：https://www.nowcoder.com/questionTerminal/75e878df47f24fdc9dc3e400ec6058ca
    来源：牛客网

      本题的关键就是在于对next域的赋值，同时对下一个节点进行保存，然后对把下一个节点赋给新的节点，这样依次循环完所有的节点。
      每次使新插入的节点变成头第一个有效节点。核心代码如下：next = current.next;
       current.next = reverhead;
       reverhead = current;
       current = next;
    */

    ListNode reversedHead = null;
    ListNode current = head;
    ListNode tmp = null;
    ListNode pre = null;
    while (current != null) {
      tmp = current.next;
      current.next = pre;  //保存新链表的当前节点的下一个node
      if (tmp == null) {
        reversedHead = current;
      }
      pre = current;
      current = tmp;
    }
    return reversedHead; //返回新链表的尾node
  }
}
