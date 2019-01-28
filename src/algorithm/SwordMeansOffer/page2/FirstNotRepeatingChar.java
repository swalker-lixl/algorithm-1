package algorithm.SwordMeansOffer.page2;

import java.util.HashMap;
import java.util.Scanner;

/**
 * describe:
 *
 * @author lixilong
 * @date 2019/01/11
 */
public class FirstNotRepeatingChar {


  public static void main(String[] args) {
    FirstNotRepeatingChar firstNotRepeatingChar = new FirstNotRepeatingChar();
    firstNotRepeatingChar.test();
  }

  public void test(){
    Scanner in = new Scanner(System.in);
    String str = in.nextLine();
    // System.out.println(MoreThanHalfNum_Solution(array));
    System.out.println(firstNotRepeatingChar(str));
  }


 /* public int firstNotRepeatingChar(String str) {
    char[] chars = str.toCharArray();
    char retChar = chars[0];
    for (int i = 1; i < chars.length; i++) {
      if (retChar == chars[i]) {
        retChar =  chars[i];
      }
    }
    return 0;
  }*/
 /*
  链接：https://www.nowcoder.com/questionTerminal/1c82e8cf713b4bbeb2a5b31cf5b0417c
  来源：牛客网
  运行时间：55ms   占用内存：9984k
  */
  public int firstNotRepeatingChar(String str) {
    char[] chars = str.toCharArray();
    HashMap<Character, Integer> mp = new HashMap<Character, Integer>();
    for (int i = 0; i < str.length(); ++i) {
      int value = 0;
      if (mp.get(chars[i]) != null) {
        value  = Integer.parseInt(mp.get(chars[i]).toString());
      }
      ++value;
      mp.put(chars[i],value);
    }
    for(int i = 0; i < str.length(); ++i){
      if(mp.get(chars[i])==1)
        return i;
    }
    return -1;
  }
}
