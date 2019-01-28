package algorithm.SwordMeansOffer.page1;

import AlgorithmsDS.util.ListNode;
import java.util.Scanner;

/**
 * describe:
 *时间限制：1秒 空间限制：32768K 热度指数：517931
 *
 *
 输入一个链表，输出该链表中倒数第k个结点。
 * @author lixilong
 * @date 2019/01/10
 */
public class FindKthToTail {

  public static void main(String[] args) {
    RectCover rectCover = new RectCover();
    rectCover.test();
  }

  public void test(){
    int n;
    Scanner in = new Scanner(System.in);
    n = in.nextInt();
    //System.out.println(findKthToTail(n));
  }

/*
    链接：https://www.nowcoder.com/questionTerminal/529d3ae5a407492994ad2a246518148a
    来源：牛客网
*/
//运行时间：32ms 占用内存：9568k
  public ListNode findKthToTail(ListNode head,int k) {

    if(head==null||k<=0){
      return null;
    }
    ListNode pre=head;
    ListNode last=head;
    for(int i=1;i<k;i++){
      if(pre.next!=null){
        pre=pre.next;   //把先行节点做超前K个位置操作
      }else{
        return null;
      }
    }
    while(pre.next!=null){
      pre = pre.next; //参考节点和目标节点一起往后移动，等先行节点到尾部，参考节点即为倒数第k个
      last=last.next;
    }
    return last;
  }


  /*
  public ListNode findKthToTail(ListNode head,int k) {
    if (head == null || k <= 0) {
      return null;
    }
    while (head.next != null){
      head = head.next;
      ++count;
      findKthToTail(head,k);
    }
  }
  */

}
