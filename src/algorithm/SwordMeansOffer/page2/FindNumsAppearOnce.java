package algorithm.SwordMeansOffer.page2;

/**
 * describe:
 * 时间限制：1秒 空间限制：32768K 热度指数：170128
 *
 * 一个整型数组里除了两个数字之外，其他的数字都出现了偶数次。
 *  请写程序找出这两个只出现一次的数字。
 * @author lixilong
 * @date 2019/01/14
 */
public class FindNumsAppearOnce {

    /*
  链接：https://www.nowcoder.com/questionTerminal/e02fdb54d7524710a7d664d082bb7811
  来源：牛客网
  运行时间：22ms 占用内存：9612k
  */
  public void findNumsAppearOnce(int[] array, int num1[], int num2[]) {
    if (array.length < 2) {
      return;
    }
    int size = array.length;
    int temp = array[0];
    for (int i = 1; i < size; i++) {
      temp = temp ^ array[i];
    }
    if (temp == 0) {
      return;
    }
    int index = 0;
    while ((temp & 1) == 0) {
      temp = temp >> 1;
      ++index;
    }
    num1[0] = num2[0] = 0;
    for (int i = 0; i < size; i++) {
      if (IsBit(array[i], index))
    num1[0] ^= array[i];
   else
    num2[0] ^= array[i];
    }
  }

  boolean IsBit(int num,int index)
  {
    num=num>>index;
    return (num&1) > 0;
  }


  /*
  链接：https://www.nowcoder.com/questionTerminal/e02fdb54d7524710a7d664d082bb7811
  来源：牛客网
  */

  public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
    if(array==null ||array.length<2)
      return ;
    int temp = 0;
    for(int i=0;i<array.length;i++)
      temp ^= array[i];

    int indexOf1 = findFirstBitIs(temp);
    for(int i=0;i<array.length;i++){
      if(isBit(array[i], indexOf1))
        num1[0]^=array[i];
      else
        num2[0]^=array[i];
    }
  }
  public int findFirstBitIs(int num){
    int indexBit = 0;
    while(((num & 1)==0) && (indexBit)<8*4){
      num = num >> 1;
      ++indexBit;
    }
    return indexBit;
  }
  public boolean isBit(int num,int indexBit){
    num = num >> indexBit;
    return (num & 1) == 1;
  }

}
