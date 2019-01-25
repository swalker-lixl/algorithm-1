package algorithm.LeetCode;

import algorithm.util.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

/**
 * describe:
 *
 * @author lixilong
 * @date 2019/01/25
 */
public class _104_MaxDepth {
  // 方法1： 递归方式
  public int maxDepth(TreeNode root) {
    return height(root, 0);
  }

  public int max(int first, int second) {
    return first > second ? first : second;
  }

  public int height(TreeNode root, int currentHeight) {
    int leftHeight = 0;
    int rightHeight = 0;
    if (root != null) {
      leftHeight = height(root.left, currentHeight) + 1;
      rightHeight = height(root.right, currentHeight) + 1;
    }
    if (root == null) return 0;
    else return max(leftHeight, rightHeight);
  }

  // 方法2：0ms 递归最简化代码
  public int maxDepth(TreeNode root) {
    if (root == null) return 0;

    int depthRight = maxDepth(root.right);
    int depthLeft = maxDepth(root.left);

    return Math.max(depthRight, depthLeft) + 1;
  }

  // 方法2：1ms 迭代方式   //iterative solution using BFS
  public int maxDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }
    Queue<TreeNode> queue = new LinkedList();
    queue.offer(root);
    int count = 0;
    while (!queue.isEmpty()) {
      int size = queue.size();
      while (size-- > 0) {
        TreeNode node = queue.poll();
        if (node.left != null) {
          queue.offer(node.left);
        }
        if (node.right != null) {
          queue.offer(node.right);
        }
      }
      count++;
    }

    return count;
  }

}
