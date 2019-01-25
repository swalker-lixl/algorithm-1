package algorithm.LeetCode;

import algorithm.util.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * describe:
 *
 * @author lixilong
 * @date 2019/01/25
 */
public class _102_LevelOrder {


 /* public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> retList = new ArrayList();
    if (root == null ) return retList;
    return processTreeNode(retList,root);
  }

  public List<List<Integer>> processTreeNode(List<List<Integer>> retLists,TreeNode root) {
   for (int i= 0; i < retLists.size(); i+=2) {
     if (root != null) retLists.get(i).add(root.val);
     if (root.left != null) retLists.get(i+1).add(root.left.val);
     if (root.right != null) retLists.get(i+1).add(root.right.val);
   }
    return retLists;
  }*/

// BSF 递归写法：
  public List<List<Integer>> levelOrder(TreeNode root) {
    ArrayList<List<Integer>> res= new ArrayList();
    if(root==null) return res;
    helper(root,res,0);
    return res;
  }
  private static void helper(TreeNode root, ArrayList<List<Integer>> res, int level) {
    if(res.size()<level+1) {
      res.add(new LinkedList());
    }
    res.get(level).add(root.val);
    if (root.left!=null) {
      helper(root.left,res,level+1);
    }
    if (root.right!=null) {
      helper(root.right,res,level+1);
    }
  }

}
