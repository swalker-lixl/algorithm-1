package algorithm.LeetCode;

import java.util.Stack;

/**
 * describe:
 *
 *
 * 
 * 参考分析英文原文：
 *  https://leetcode.com/problems/implement-queue-using-stacks/discuss/219033/Java-Solution%3A-Using-Two-Stacks-O(1)-amortized-time
 * @author lixilong
 * @date 2019/01/23
 */
public class _232_MyQueue {
/* //方法1： 在push中直接操作
  private Stack<Integer> s1 = new Stack<Integer>();
  private Stack<Integer> s2 = new Stack<Integer>();
  //* Initialize your data structure here.
  public _232_MyQueue() {}

  //* Push element x to the back of queue.
  public void push(int x) {
    if (s1.isEmpty()) {
      s1.push(x);
      for (int i = 1; i < s1.size(); i++) {
        s2.push(s1.pop());
      }
    } else {
      s2.push(x);
      for (int i = 1; i < s2.size(); i++) {
        s1.push(s2.pop());
      }
    }

  }

  //* Removes the element from in front of queue and returns that element.
  public int pop() {
    return s1.isEmpty() ? s2.pop() : s1.pop();
  }

  //* Get the front element.
  public int peek() {
    return s1.isEmpty() ? s2.peek() : s1.peek();
  }

  //* Returns whether the queue is empty.
  public boolean empty() {
    return s1.isEmpty() && s2.isEmpty();
  }*/

  //方法2： push不做处理，第一次访问的函数中专门操作
  Stack<Integer> inputStack;
  Stack<Integer> outputStack;

  /** Initialize your data structure here. */
  public _232_MyQueue() {
    inputStack = new Stack();
    outputStack = new Stack();
  }

  /**
   * Push element x to the back of queue, enqueue() method
   */
  public void push(int x) {
    inputStack.push(x);
  }

  /**
   * Removes the element from in front of queue and returns that element, dequeue() method
   */
  public int pop() {
    peek();
    return outputStack.pop();
  }

  /**
   * Get the front element. 具体操作放在第一访问元素时处理
   */
  public int peek() {
    if (outputStack.isEmpty()) {
      while (!inputStack.isEmpty()) {
        outputStack.push(inputStack.pop());
      }
    }
    return outputStack.peek();
  }

  /**
   * Returns whether the queue is empty.
   */
  public boolean empty() {
    return inputStack.isEmpty() && outputStack.isEmpty();
  }


}
