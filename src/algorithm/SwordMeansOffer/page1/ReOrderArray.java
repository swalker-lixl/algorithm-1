package algorithm.SwordMeansOffer.page1;

/**
 * describe:
 * 时间限制：1秒 空间限制：32768K 热度指数：371265
 *
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 * @author lixilong
 * @date 2019/01/10
 */
public class ReOrderArray {
  public static void main(String[] args) {
    ReOrderArray reOrderArray = new ReOrderArray();
    reOrderArray.test();
  }

  public void test(){
    int[] array= {1, 2, 3, 4, 5};
    reOrderArray(array);
    for (Integer value: array) {
      System.out.print(value+"   ");
    }
  }

  /*时间限制：1秒 空间限制：32768K 热度指数：371265
 // 运行时间：运行时间：18ms 占用内存：9228k
  输入一个整数数组，实现一个函数来调整该数组中数字的顺序.
  使得所有的奇数位于数组的前半部分，
  所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
  */


  public void reOrderArray(int[] array) {
    if (array == null || array.length == 0) {
      return;
    } 
    int i = 0, j;
    while (i < array.length) {
      while (i < array.length && isOddNumber(array[i])) {
        i++;
      }
      j = i + 1;
      while (j < array.length && !isOddNumber(array[j])) {
        j++;
      }
      if (j < array.length) {
        int tmp = array[j];
        for (int j2 = j - 1; j2 >= i; j2--) {
          array[j2 + 1] = array[j2];
        }
        array[i++] = tmp;
      } else {// 查找失敗
        break;
      }
    }
  }

  /* public void reOrderArray(int [] array) {
    int[] preArray = new int[](array.length);
    int[] aftArray = new int[](array.length);
      for (int i=0;i < array.length; i++) {
        if (isOddNumber(array[i])){
          preArray[i] = array[i];
        }else {
          aftArray[i] = array[i];
        }
      }

    }*/

  public boolean isOddNumber(int value){
    return value%2 == 0 ? false : true ;
  }


}
