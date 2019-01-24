package algorithm.LeetCode;

import algorithm.util.TreeNode;

/**
 * describe:
 * 235. 二叉搜索树的最近公共祖先
 *
 *
 * 嵌套三目运算符
 *
 *
 * @author lixilong
 * @date 2019/01/18
 */
public class _235_LowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
      //方法1：perfect
      if(root.val > p.val && root.val > q.val){
        return lowestCommonAncestor(root.left, p, q);
      }else if(root.val < p.val && root.val < q.val){
        return lowestCommonAncestor(root.right, p, q);
      }else{
        return root;
      }
    }

   /* //方法2：直接套用236的逻辑了，对与case的判断 分类没有柔和在一起
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
      if (root == null || root == p || root == q) {
        return root;
      }
      TreeNode left = lowestCommonAncestor(root.left, p, q);
      TreeNode right = lowestCommonAncestor(root.right, p, q);
      if (left != null && right != null) {
        return root;
      }
      return left != null ? left : right;
    }*/


}
