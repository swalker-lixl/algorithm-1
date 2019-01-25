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
public class _111_MinDepth {

//方法1：递归方式 0ms
  public int minDepth(TreeNode root) {
    if (root == null) {
      return 0;
    } else {
      int leftD = minDepth(root.left);
      int rightD = minDepth(root.right);

      if (leftD == 0) return rightD + 1;
      else if (rightD == 0) return leftD + 1;
      else return Math.min(leftD, rightD) + 1; //加上当前这一层，或者说根节点这一层【第一层】
    }
  }

  //方法2：迭代方式 2ms
  public int minDepth(TreeNode root) {
    if (root == null) return 0;
    Queue<TreeNode> q = new LinkedList<TreeNode>();
    q.add(root);
    int minH = Integer.MAX_VALUE, h = 1;
    while (!q.isEmpty()) {
      Queue<TreeNode> tmp = new LinkedList<TreeNode>();
      while(!q.isEmpty()) {
        TreeNode cur = q.poll();
        if (cur.left == null && cur.right == null)
          minH = Math.min(h, minH);
        if (cur.left != null) tmp.add(cur.left);
        if (cur.right != null) tmp.add(cur.right);
      }
      q = tmp;
      h++;
    }
    return minH;
  }

  }
