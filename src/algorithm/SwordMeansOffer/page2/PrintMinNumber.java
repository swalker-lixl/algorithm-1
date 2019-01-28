package algorithm.SwordMeansOffer.page2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * describe:
 *
 * @author lixilong
 * @date 2019/01/11
 */
public class PrintMinNumber {



  public static void main(String[] args) {
    NumberOf1Between1AndN_Solution numberOf1Between1AndN_solution = new NumberOf1Between1AndN_Solution();
    numberOf1Between1AndN_solution.test();
  }

  public void test(){
    int[] array= {4,2,4,1,4,2};
    int[] array1= {1,2,3,2,2,2,5,4,2};
    // System.out.println(MoreThanHalfNum_Solution(array));
    System.out.println(printMinNumber(array1));
  }

/*
  来源：牛客网
  链接：https://www.nowcoder.com/questionTerminal/8fecd3f8ba334add803bf2a06af1b993
   运行时间：29ms 占用内存：9600k
  具体思路再去看，先归纳，在总结，最后化简。
  */
  public String printMinNumber(int[] numbers) {
    int n;
    String s = "";
    ArrayList<Integer> list = new ArrayList<Integer>();
    n = numbers.length;
    for (int i = 0; i < n; i++) {
      list.add(numbers[i]);
    }
    Collections.sort(list, new Comparator<Integer>() {
      // 比较器写得好，最后整体是一个String
      public int compare(Integer str1, Integer str2) {
        String s1 = str1 + "" + str2;
        String s2 = str2 + "" + str1;
        return s1.compareTo(s2);
      }
    });

    for (int j : list) {
      s += j;
    }
    return s;

  }

}
