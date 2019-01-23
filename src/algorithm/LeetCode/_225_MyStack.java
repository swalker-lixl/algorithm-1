package algorithm.LeetCode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * describe:
 *
 * @author lixilong
 * @date 2019/01/23
 */
public class _225_MyStack {

//1.数组实现
//2.链表实现



  /*//3.队列实现 一个队列
  private Queue<Integer> q = new LinkedList<Integer>();
  *//** Initialize your data structure here. *//*

  *//** Push element x onto stack. *//*
  public void push(int x) {
    q.add(x);
    for(int i = 1; i < q.size(); i ++) { //  刚好循环了 size-1次，所以 每次都是取出队首元素加之队尾，最后效果是，把刚加入的元素移到了队首。
      // rotate the queue to make the tail be the head
      q.add(q.poll());
    }
  }
  *//** Removes the element on top of the stack and returns that element. *//*
  public int pop() {
   return q.poll();
  }

  *//** Get the top element. *//*
  public int top() {
   return q.peek();
  }

  *//** Returns whether the stack is empty. *//*
  public boolean empty() {
    return q.isEmpty();

  }*/

  //4.队列实现 两个队列

  private Queue<Integer> q1 = new LinkedList<Integer>();
  private Queue<Integer> q2 = new LinkedList<Integer>();
  public void push(int x) {
    if(q1.isEmpty()) {  //两个queue轮换着添加加入元素，每次加入后，另一个队列的值全部挪动到当前队列（新加元素后面）
      //任何时刻，均是一个空queue和一个满queue【新加元素在队首】
      q1.add(x);
      for(int i = 0; i < q2.size(); i ++)
        q1.add(q2.poll());
    }else {
      q2.add(x);
      for(int i = 0; i < q1.size(); i++)
        q2.add(q1.poll());
    }
  }

  public void pop() {
    if(!q1.isEmpty())
      q1.poll();
    else
      q2.poll();
  }
  public int top() {
    return q1.isEmpty() ? q2.peek() : q1.peek();
  }
  public boolean empty() {
    return q1.isEmpty() && q2.isEmpty();
  }

}
