package algorithm.SwordMeansOffer.page2;

import AlgorithmsDS.util.TreeNode;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * describe:
 * 时间限制：1秒 空间限制：32768K 热度指数：119308
 *
 *输入一棵二叉树，求该树的深度。
 * 从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 *
 *
 *
 * reference resources：
 * https://www.nowcoder.com/practice/435fb86331474282a3499955f0a41e8b?tpId=13&tqId=11191&rp=2&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking&tPage=2
 *
 * @author lixilong
 * @date 2019/01/14
 */
public class TreeDepth {



  public static void main(String[] args) {
    TreeDepth treeDepth = new TreeDepth();
    treeDepth.test();
  }

  public void test(){
    int n;
    Scanner in = new Scanner(System.in);
    n = in.nextInt();
    TreeNode treeNode = new TreeNode(n);

    System.out.println(treeDepth(treeNode));
  }
  /*
  递归法：运行时间：19ms 占用内存：9292k
  */
 /* public int treeDepth(TreeNode root) {
    //回朔法加上递归
    //int currentDepth = 0 ;
    int treeDepth = 0;
    if (root == null ) return treeDepth;

    if (treeDepth(root.left) > treeDepth(root.right)) {
      treeDepth = 1+treeDepth(root.left);
    } else {
      treeDepth = 1+treeDepth(root.right);
    }

    return treeDepth;
  }*/

  /*
  非递归，层次遍历（类广度优先遍历）
  链接：https://www.nowcoder.com/questionTerminal/435fb86331474282a3499955f0a41e8b
  运行时间：16ms 占用内存：9304k
  来源：牛客网
  */
  public int treeDepth(TreeNode pRoot) {
    if(pRoot == null){
      return 0;
    }
    Queue<TreeNode> queue = new LinkedList<TreeNode>();
    queue.add(pRoot);
    int depth = 0, count = 0, nextCount = 1;
    while(queue.size()!=0){
      TreeNode top = queue.poll();
      count++;
      if(top.left != null){
        queue.add(top.left);
      }
      if(top.right != null){
        queue.add(top.right);
      }
      if(count == nextCount){
        nextCount = queue.size();
        count = 0;
        depth++;
      }
    }
    return depth;
  }

}
