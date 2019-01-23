package algorithm.LeetCode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * describe:
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 *
 *
 * https://leetcode.com/problems/valid-parentheses/description/
 * @author lixilong
 * @date 2019/01/23
 */
public class _20_IsValid {

  public static void main(String[] args) {
    _20_IsValid  isValid = new _20_IsValid();
    isValid.test();
  }

  public void test(){
    String s = "()";
    String s1 = "(()";
    String s2 = "))";
    String s3 = ")";
    String s4 = "({[()]})";
    System.out.println(isValid(s));
  }
//方法2： map 字典表方式有待验证，目前存在遗留问题

  public boolean isValid(String s) {
    Stack stack = new Stack();
    Map paren = new HashMap() {
      {
        put(')','(');
        put(']','[');
        put('}','{');
      }
    };
    char[] strArray = s.toCharArray();
    for (char ch : strArray) {
      if (paren.containsKey(ch)) {
        stack.push(ch);
      } else if (paren.containsValue(ch)) {
        if (stack.isEmpty() || !paren.get(ch).equals(stack.pop())) {
          return false;
        }
      }
    }
    if (stack.isEmpty())  return true;
    return false;
  }



/*// 方法2：拆解分析 https://leetcode.com/problems/valid-parentheses/discuss/222435/Java-8ms-faster-than-81.80
  public boolean isValid(String s) {
    Stack<Character> stack = new Stack<Character>();
    boolean match = false;

    if (s.length() == 0 || s == null) {
      return true;
    }

    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (c == '(' || c == '{' || c == '[') {
        stack.push(c);
      } else {
        char open = ' ';
        if (!stack.isEmpty()) {
          open = stack.pop();
        }
        match = matchParentheses(c, open);
        if (!match) {
          return false;
        }
      }
    }
    if (!stack.isEmpty() || !match) {
      return false;
    } else
      return true;
  }

  private boolean matchParentheses(char close, char open) {
    switch (close) {
      case ')': return open == '(';
      case '}': return open == '{';
      case ']': return open == '[';
    }
    return false;
  }*/


}
