package algorithm.SwordMeansOffer.page2;

/**
 * describe:
 *[编程题]数组中出现次数超过一半的数字
 *
 *
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 * （不可能有两个数字满足条件，因为数组总长度如此）
 * @author lixilong
 * @date 2019/01/11
 */
public class MoreThanHalfNum_Solution {
  public static void main(String[] args) {
    MoreThanHalfNum_Solution moreThanHalfNum = new MoreThanHalfNum_Solution();
    moreThanHalfNum.test();
  }

  public void test(){
    int[] array= {4,2,4,1,4,2};
    int[] array1= {1,2,3,2,2,2,5,4,2};
   // System.out.println(MoreThanHalfNum_Solution(array));
    System.out.println(MoreThanHalfNum_Solution(array1));
  }
 /* public int getMaxValueCount(int [] array){
    int maxCount = 0;
    for (Integer value : array) {

    }
      int[] array= {1, 2, 3, 4, 5};
  }

  public int getMaxValue(int [] array){
      int[] array= {1, 2, 3, 4, 5};
  }
*/


 /*
  作者：cm问前程
  链接：https://www.nowcoder.com/questionTerminal/e8a1b01a2df14cb2b228b30ee6a92163
  来源：牛客网
  采用阵地攻守的思想：
  第一个数字作为第一个士兵，守阵地；count = 1；
  遇到相同元素，count++;
  遇到不相同元素，即为敌人，同归于尽,count--；当遇到count为0的情况，又以新的i值作为守阵地的士兵，继续下去，到最后还留在阵地上的士兵，有可能是主元素。
  再加一次循环，记录这个士兵的个数看是否大于数组一般即可。

   运行时间：16ms   占用内存：9272k
  */
 /*public int MoreThanHalfNum_Solution(int[] array) {
   int length = array.length;
   if (array == null || length <= 0) {
     return 0;
   }

   int result = array[0];
   int times = 1;
   for (int i = 1; i < length; i++) {
     if (times == 0) {
       result = array[i];  // result 只有在 times == 0 的时候才会变，即 result 表示 当前节点之前的所有元素中，出现次数最多的元素。
       times = 1;
     } else {
       if (array[i] == result) {
         times++;
       } else {
         times--;
       }
     }
   }

   times = 0;
   for (int i = 0; i < length; i++) {
     if (result == array[i]) {
       times++;
     }
   }

   if (times  > length/2) {
     return result;
   }else {
     return 0;
   }
 }*/


  //链接：https://www.nowcoder.com/questionTerminal/e8a1b01a2df14cb2b228b30ee6a92163
  //来源：牛客网
  //
  //采用用户“分形叶”思路
  //注意到目标数 超过数组长度的一半，对数组同时去掉两个不同的数字，到最后剩下的一个数就是该数字。
  //如果剩下两个，那么这两个也是一样的，就是结果，。
  // 其基础上把最后剩下的一个数字或者两个回到原来数组中，将数组遍历一遍统计一下数字出现次数进行最终判断。

  public int MoreThanHalfNum_Solution(int [] array) {
    int length=array.length;
    if(array==null||length<=0){
      return 0;
    }

    if(length==1){
      return array[1];
    }

    int[] tempArray=new int[length];
    for(int i=0;i<length;i++){
      tempArray[i]=array[i];
    }

    for(int i=0;i<length;i++){
      //后面需要用零来代表抹除数字，所以对0时做特殊处理
      if(tempArray[i]==0){
        continue;
      }

      for(int j=i+1;j<length;j++){
        if(tempArray[i]!=tempArray[j]&&tempArray[j]!=0){
          tempArray[i]=0;//此处用0代表抹去该数字
          tempArray[j]=0;
          break;
        }

      }
    }

    for(int i=0;i<length;i++){
      System.out.println(tempArray[i]);
    }

    //找出未被抹去的数字
    int result=0;
    for(int i=0;i<length;i++){
      if(tempArray[i]!=0){
        result=tempArray[i];
        break;
      }
    }

    int times=0;
    for(int i=0;i<length;i++){
      if(result==array[i]){

        times++;
      }
    }

    if(times*2<length){
      result=0;
    }
    return result;
  }


   /*public int MoreThanHalfNum_Solution(int [] array) {
    int maxValueCount = getMaxValueCount(array);
    if (maxValueCount > (maxValueCount+1)/2){
      return getMaxValue(array);;
    }else {
      return 0;
    }
  }*/

}
