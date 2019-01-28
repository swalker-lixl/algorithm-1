package algorithm.SwordMeansOffer.page1;

import java.util.Vector;

/**
 * describe:
 *
 *
 * 时间限制：1秒 空间限制：32768K 热度指数：214651
 *
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 * @author lixilong
 * @date 2019/01/11
 */
public class StackGetMin extends Vector {

  Vector<Integer> vector = new Vector<Integer>();
  int count = 0;
  int minValue = 0;
  int minIndex = 0;

  public void push(int node) {
    vector.add(node);
    ++count;
    if (minValue > node) {
      minValue = node;
      minIndex = count;
    }
  }

  public void pop() {
    vector.remove(count);
  }

  public int top() {
    return vector.get(count);
  }

  public int min() {
    return vector.get(minIndex);
  }
}
