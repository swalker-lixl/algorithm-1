package algorithm.LeetCode;

import algorithm.util.TreeNode;

/**
 * describe:
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 * https://leetcode-cn.com/problems/validate-binary-search-tree/
 *
 * @author lixilong
 * @date 2019/01/18
 */
public class _98_IsValidBST {
  /*int max, min;
  public boolean isValidBST(TreeNode root) {
    if (root == null) return true;

    max =root.val;  min =root.val;
    if (max <= root.val || min >= root.val) return false;

    if (root.left != null) isValidBST(root.left);
    if (root.right != null) isValidBST(root.right);

  }

  // 方法1：对比方法2 性能一样
  public boolean isValidBST(TreeNode root) {
    return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
  }

  public boolean isValidBST(TreeNode root, long minVal, long maxVal) {
    if (root == null) return true;
    if (root.val >= maxVal || root.val <= minVal) return false;
    return isValidBST(root.left, minVal, root.val) && isValidBST(root.right, root.val, maxVal);
  }*/

  // 方法1：再查看左子树（右子树）递归条件
  public boolean isValidBST(TreeNode root) {

    if(root == null)
      return true;
    return BSTHelper(root, null,null);

  }

  public boolean BSTHelper(TreeNode node, Integer min, Integer max){

    //forthe left subtree                   for the right subtree
    //max 是左子树中最大值                    min 是右子树中最小值
    if((max!=null && node.val>=max) || (min!=null && node.val <= min))
      return false;

    boolean left, right;
    if(node.left!= null){
      left = BSTHelper(node.left, min, node.val);
    }
    else
      left = true;

    if(node.right!=null)
      right = BSTHelper(node.right, node.val, max);
    else
      right = true;

    return (left&&right);
  }

}
