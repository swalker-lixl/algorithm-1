package algorithm.SwordMeansOffer.page3;

/**
 * describe:
 * 时间限制：1秒 空间限制：32768K 热度指数：148343
 *
 *请你把其循环左移K位后的序列输出。
 * 例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。是不是很简单？OK，搞定它！
 *
 * @author lixilong
 * @date 2019/01/14
 */
public class LeftRotateString {
  public static void main(String[] args) {
    LeftRotateString leftRotateString = new LeftRotateString();
    leftRotateString.test();
  }

  public void test(){
   String str = "abcdefg";
    System.out.println(leftRotateString(str,2));
  }


/*
运行时间：21ms 占用内存：9436k

* */
 /* public String leftRotateString(String str,int n) {
    int endIndex = str.toCharArray().length;
    int length = str.length();
    if (endIndex <= 0 || endIndex < n || str.equals("")) {
      return "";
    }
    return str.substring(n,endIndex)+str.substring(0,n);
  }*/

/*
  链接：https://www.nowcoder.com/questionTerminal/12d959b108cb42b1ab72cef4d36af5ec
  来源：牛客网
  */

  public String leftRotateString(String str, int n) {
    int len = str.length();
    if (0 == len || 0 == n) {
      return str;
    }
    String temp = str;
    fun(temp, 0, n - 1);
    fun(temp, n, len - 1);
    fun(temp, 0, len - 1);
    return str;
  }

  public void fun(String s, int start, int end) {
    char temp;
    char[] strChars = s.toCharArray();
    while (start < end) {
      temp = strChars[start];
      strChars[start] = strChars[end];
      strChars[end] = temp;
      start++;
      end--;
    }
    strChars.toString();
  }


}
