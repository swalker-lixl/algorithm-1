package algorithm.SwordMeansOffer.page1;

import java.util.Stack;

/**
 * describe:
 *
 * @author lixilong
 * @date 2019/01/10
 */
public class ImplementAQueueWithTwoStacks {

  Stack<Integer> stack1 = new Stack<Integer>();
  Stack<Integer> stack2 = new Stack<Integer>();

  public void push(int node) {
    stack1.push(node);
  }

  public int pop() {
    if (stack1.empty() && stack2.empty()) {
     throw new RuntimeException("Queue is empty! "); //不符合条件时，throw一个自定义异常抛出，提示原因
    }
    if (stack2.empty()) { //push 操作不能影响2的顺序，只要没有对2的push操作，2就不应该吧1中的元素push
      while (!stack1.empty()){
        stack2.push(stack1.pop());
      }
    }
    return stack2.pop();
  }

  public int peek() {
    if (stack1.empty() && stack2.empty()) {
      throw new RuntimeException("Queue is empty! "); //不符合条件时，throw一个自定义异常抛出，提示原因
    }
    if (stack2.empty()) { //push 操作不能影响2的顺序，只要没有对2的push操作，2就不应该吧1中的元素push
      while (!stack1.empty()){
        stack2.push(stack1.pop());
      }
    }
    return stack2.peek();
  }

}
