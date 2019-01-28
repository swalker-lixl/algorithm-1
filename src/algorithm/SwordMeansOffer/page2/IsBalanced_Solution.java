package algorithm.SwordMeansOffer.page2;

import AlgorithmsDS.util.TreeNode;
import java.util.Scanner;

/**
 * describe:
 * 时间限制：1秒 空间限制：32768K 热度指数：146009
 *
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 *
 * @author lixilong
 * @date 2019/01/14
 */
public class IsBalanced_Solution {



  public static void main(String[] args) {
    TreeDepth treeDepth = new TreeDepth();
    treeDepth.test();
  }

  public void test(){
    int n;
    Scanner in = new Scanner(System.in);
    n = in.nextInt();
    TreeNode treeNode = new TreeNode(n);
    System.out.println(isBalanced_Solution(treeNode));
  }

 /* public boolean isBalanced_Solution(TreeNode root) {
    if (root == null) return false;


  }*/




  /*
  链接：https://www.nowcoder.com/questionTerminal/8b3b95850edb4115918ecebdf1b4d222
  来源：牛客网
  运行时间：17ms 占用内存：9312k
  如果改为从下往上遍历，如果子树是平衡二叉树，则返回子树的高度；如果发现子树不是平衡二叉树，则直接停止遍历，这样至多只对每个结点访问一次。
  */

 /* public boolean isBalanced_Solution(TreeNode root) {
    return getDepth(root) != -1;
  }

  private int getDepth(TreeNode root) {
    if (root == null) return 0;
    int left = getDepth(root.left);
    if (left == -1) return -1;
    int right = getDepth(root.right);
    if (right == -1) return -1;
    return Math.abs(left - right) > 1 ? -1 : 1 + Math.max(left, right);
  }*/

  /*
  链接：https://www.nowcoder.com/questionTerminal/8b3b95850edb4115918ecebdf1b4d222
  来源：牛客网
  如从下到上遍历,在判断上层结点的时候，会多次重复遍历下层结点，增加了不必要的开销。
  运行时间：26ms 占用内存：9244k
  */

  public boolean isBalanced_Solution(TreeNode root) {
    if(root == null) {
      return true;
    }
    return Math.abs(maxDepth(root.left) - maxDepth(root.right)) <= 1 && isBalanced_Solution(root.left) && isBalanced_Solution(root.right);
  }

  private int maxDepth(TreeNode root) {
    if(root == null) {
      return 0;
    }
    return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
  }

}
