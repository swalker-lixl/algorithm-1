package algorithm.SwordMeansOffer.page2;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * describe:
 *
 * @author lixilong
 * @date 2019/01/11
 */
public class GetUglyNumber_Solution {

  public static void main(String[] args) {
    GetUglyNumber_Solution getUglyNumber_solution = new GetUglyNumber_Solution();
    getUglyNumber_solution.test();
  }

  public void test(){
    Scanner in = new Scanner(System.in);
    int intN = in.nextInt();
    // System.out.println(MoreThanHalfNum_Solution(array));
    System.out.println(getUglyNumber_solution(2));
  }





  //三个队列思维

  /*
  链接：https://www.nowcoder.com/questionTerminal/6aa9e04fc3794f68acf8778237ba065b
  来源：牛客网
  运行时间：22ms 占用内存：9460k
  */
  public int getUglyNumber_solution(int index) {
    // 0-6的丑数分别为0-6
    if(index < 7) return index;
    //p2，p3，p5分别为三个队列的指针，newNum为从队列头选出来的最小数
    int p2 = 0, p3 = 0, p5 = 0, newNum = 1;
    ArrayList<Integer> arr = new ArrayList();
    arr.add(newNum);
    while(arr.size() < index) {
      //选出三个队列头最小的数
      newNum = Math.min(arr.get(p2) * 2, Math.min(arr.get(p3) * 3, arr.get(p5) * 5));
      //这三个if有可能进入一个或者多个，进入多个是三个队列头最小的数有多个的情况
      if(arr.get(p2) * 2 == newNum) p2++;
      if(arr.get(p3) * 3 == newNum) p3++;
      if(arr.get(p5) * 5 == newNum) p5++;
      arr.add(newNum);
    }
    return newNum;
  }


 /* public int getUglyNumber_solution(int index) {
    int i = 0 ;
    while(i < index){
         if (isUglyNumber(i)){
           ++i;
         }
    }
    return i+1;
  }

  public boolean isUglyNumber(int num){
    if (num <= 0) {
      return false;
    }
    while (num % 2 == 0) {
      num = num / 2;
    }
    while (num % 3 == 0) {
      num = num / 3;
    }

    while (num % 5 == 0) {
      num = num / 5;
    }

    if (num == 1) {
      return true;
    } else {
      return false;
    }

  }*/


}
