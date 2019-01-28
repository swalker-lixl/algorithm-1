package algorithm.SwordMeansOffer.page1;

import AlgorithmsDS.util.TreeNode;

/**
 * describe:
 * 时间限制：1秒 空间限制：32768K 热度指数：346616
 *
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 *
 * @author lixilong
 * @date 2019/01/10
 */
public class HasSubtree {

  //方法1： 递归判断
  public boolean HasSubtree(TreeNode root1,TreeNode root2) {
    if (root1 == null || root2 == null) {
      return false;
    }
    return isSubtree(root1,root2) || HasSubtree(root1.left,root2) || HasSubtree(root1.right,root2);
  }


  public boolean isSubtree (TreeNode root1,TreeNode root2) {
    if (root1 == null) {
      return false;
    }
    if (root2 == null) {
      return true;
    }
    if (root1.val == root2.val) {
      return isSubtree(root1.left,root2.left) && isSubtree(root1.right,root2.right);
    }else {
      return false;
    }
  }

   public boolean isNodeEqules (TreeNode root1,TreeNode root2) {
      if (root1.val != root2.val) {
        return false;
      }
      if (!isNodeEqules(root1.left, root2.left)) {
        return false;
      }
      if (!isNodeEqules(root1.right, root2.right)) {
        return false;
      }
      return true;
    }
}
