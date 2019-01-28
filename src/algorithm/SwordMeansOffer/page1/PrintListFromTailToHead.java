package algorithm.SwordMeansOffer.page1;

import AlgorithmsDS.util.ListNode;
import java.util.ArrayList;

/**
 * describe:
 ** describe:
 *  *
 *  *时间限制：1秒 空间限制：32768K 热度指数：690626
 *  *
 *  *输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
 *  *
 *  * @author lixilong
 *  * @date 2019/01/09
 *  *
 *  * https://www.nowcoder.com/practice/4060ac7e3e404ad1a894ef3e17650423?tpId=13&tqId=11155&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 *
 *
 * 注：链表的反转 递归+非递归实现
 * @author lixilong
 * @date 2019/01/09
 */
public class PrintListFromTailToHead {

  public static void main(String[] args) {
   /* ArrayList tempArrayList = new ArrayList();
    tempArrayList.add(1);
    tempArrayList.add(2);
    tempArrayList.add(3);
    Collections.reverse(tempArrayList);
    System.out.println(tempArrayList.toString());*/
    PrintListFromTailToHead printListFromTailToHead = new PrintListFromTailToHead();
    System.out.println(printListFromTailToHead.test());
  }

  public String test(){
    ListNode listNode1 =new  ListNode(1);
    ListNode listNode2 =new  ListNode(2);
    ListNode listNode3 =new  ListNode(3);
    ListNode listNode4 =new  ListNode(4);

    listNode1.next = listNode2;
    listNode2.next = listNode3;
    listNode3.next = listNode4;
    listNode4.next = null;
    return printListFromTailToHead(listNode1).toString();
  }


 /* //逆序打印输出超时
  public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
    ArrayList retArrayList = new ArrayList();
    ArrayList tempArrayList = new ArrayList();
    if (listNode == null) return retArrayList;
    while (listNode.next != null){
      tempArrayList.add(listNode.val);
    }
    for (int i=tempArrayList.size()-1; i > 0 ;i++) {
      retArrayList.add(tempArrayList.get(i));
    }
    return retArrayList;
  } */

  /*//集合反转 超时
  public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
    ArrayList retArrayList = new ArrayList();
    if (listNode == null) return retArrayList;
    while (listNode.next != null){
      retArrayList.add(listNode.val);
    }
    Collections.reverse(retArrayList);
    return retArrayList;
  }*/

  /*
  //方法1：递归，用retArrayList记载调用值
  ArrayList<Integer> arrayList=new ArrayList<Integer>();
  public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
    if(listNode!=null){
      this.printListFromTailToHead(listNode.next);
      arrayList.add(listNode.val);
    }
    return arrayList;
  }*/


  //方法2：非递归，遍历，依次插入头结点
  ArrayList<Integer> arrayList=new ArrayList<Integer>();
  public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
    if(listNode!=null){
      //this.printListFromTailToHead(listNode.next);
      ListNode afterNode = reverseList(listNode);
      while (null != afterNode){
        arrayList.add(afterNode.val);
        afterNode = afterNode.next;
      }
    }
    return arrayList;
  }


  public ListNode reverseList(ListNode head) {
    ListNode prev = null;
    while(head!=null){
      ListNode tmp = head.next;
      head.next = prev;
      prev = head;
      head = tmp;
    }
    return prev;
  }

  /*//方法2：链表翻转，遍历添加到arrayList后输出
  ArrayList<Integer> arrayList=new ArrayList<Integer>();
  public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {

    ListNode newHeadNode =  new ListNode(0);
    ListNode newTailNode =  new ListNode(0);
    newTailNode.next = null;
    newHeadNode.next = newTailNode;
    ListNode nextNode = new ListNode(0) ;

    while (listNode != null) {
      if (listNode.next != null) {
        nextNode = listNode.next;
      }
      listNode.next = newHeadNode.next;
      newHeadNode.next = listNode;
      listNode.val = nextNode.val;
      listNode.next = nextNode.next;
    }

    while (newHeadNode != null) {
      if (newHeadNode.next != null) {
        arrayList.add(newHeadNode.next.val);
        newHeadNode = newHeadNode.next;
      }
    }
    return arrayList;
  }*/

}
