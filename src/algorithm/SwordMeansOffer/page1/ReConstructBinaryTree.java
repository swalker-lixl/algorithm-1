package algorithm.SwordMeansOffer.page1;/*
package AlgorithmsDS.SwordMeansOffer.page1;

import TestMap.A;
import java.util.ArrayList;

*/
/**
 * describe:
 * 时间限制：1秒 空间限制：32768K 热度指数：484369
 *
 *
 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 * @author lixilong
 * @date 2019/01/10
 *//*

public class ReConstructBinaryTree {

  public static void main(String[] args) {
    ReConstructBinaryTree reConstructBinaryTree = new  ReConstructBinaryTree();
   // System.out.println(ReConstructBinaryTree.test());
  }

  public String test(){
    TreeNode listNode1 =new  TreeNode(1);
    TreeNode listNode2 =new  TreeNode(2);
    TreeNode listNode3 =new  TreeNode(3);
    TreeNode listNode4 =new  TreeNode(4);

    listNode1.left = listNode2;
    listNode1.right = listNode3;
    listNode2.left = listNode4;
    listNode2.right = null;
    listNode3.left = null;
    listNode3.right = null;
    listNode4.right = null;
    listNode2.left = null;
    ArrayList<TreeNode> arrayList = new ArrayList();
    arrayList.add(listNode1);
    arrayList.add(listNode2);
    arrayList.add(listNode3);
    arrayList.add(listNode4);
    arrayList.add(listNode1);
   // return reConstructBinaryTree(1,2).val+"";
    return "";
  }




  public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
    TreeNode root=reConstructBinaryTree(pre,0,pre.length-1,in,0,in.length-1);
    return root;
  }

 */
/*
  链接：https://www.nowcoder.com/questionTerminal/8a19cbe657394eeaac2f6ea9b0f6fcf6
  来源：牛客网
  *//*


  //前序遍历{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}
  private TreeNode reConstructBinaryTree(int [] pre,int startPre,int endPre,int [] in,int startIn,int endIn) {

    if(startPre>endPre||startIn>endIn)
      return null;
    TreeNode root=new TreeNode(pre[startPre]);

    for(int i=startIn;i<=endIn;i++)
      if(in[i]==pre[startPre]){
        root.left=reConstructBinaryTree(pre,startPre+1,startPre+i-startIn,in,startIn,i-1);
        root.right=reConstructBinaryTree(pre,i-startIn+startPre+1,endPre,in,i+1,endIn);
        break;
      }

    return root;
  }
}

}



*/
