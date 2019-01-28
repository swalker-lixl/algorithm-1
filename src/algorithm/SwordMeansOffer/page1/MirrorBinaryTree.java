package algorithm.SwordMeansOffer.page1;

import AlgorithmsDS.util.TreeNode;
import java.util.Scanner;
import java.util.Stack;

/**
 * describe:
 * 时间限制：1秒 空间限制：32768K 热度指数：203663
 *
 *操作给定的二叉树，将其变换为源二叉树的镜像。
 * @author lixilong
 * @date 2019/01/10
 */
public class MirrorBinaryTree {



  public static void main(String[] args) {
    MirrorBinaryTree mirrorBinaryTree = new MirrorBinaryTree();
    mirrorBinaryTree.test();
  }

  public void test(){
    int n;
    Scanner in = new Scanner(System.in);
    n = in.nextInt();
    TreeNode treeNode = new TreeNode(n);
    mirrorBinaryTree(treeNode);

    System.out.println();
  }

  /*// 方法1： 递归方式 运行时间：26ms  占用内存：9728k
    // 链接：https://www.nowcoder.com/questionTerminal/564f4c26aa584921bc75623e48ca3011
  public void mirrorBinaryTree(TreeNode root) {
    TreeNode tmpeNode = null;
    *//*if (root == null) {
      return; //没做任何操作就可以不加对逻辑的处理
    } else*//*
    if (root != null) { //递归和循环不要混淆了，递归本身就是嵌套调用，不要多加循环控制
      tmpeNode = root.left;
      root.left = root.right;
      root.right = tmpeNode;
      if (root.left != null) {
        mirrorBinaryTree(root.left);
      }
      if (root.right != null) {
        mirrorBinaryTree(root.right);
      }
    }
  }*/


  // 方法2： 迭代方式 待验测
  public void mirrorBinaryTree(TreeNode root) {

    //非递归实现
    if (root == null) {
      return;
    }
    Stack<TreeNode> stackNode = new Stack<TreeNode>();
    stackNode.push(root);
    while (stackNode.size() > 0) {
      TreeNode tree = stackNode.pop();
      stackNode.pop();
      if (tree.left != null || tree.right != null) {
        TreeNode tmpTree = tree.right;
        tree.right = tree.left;
        tree.left = tmpTree;
      }
      if (tree.left != null) {
        stackNode.push(tree.left);
      }
      if (tree.right != null) {
        stackNode.push(tree.right);
      }
    }
  }

  }



