package algorithm.SwordMeansOffer.page1;

/**
 * describe:
 *
 *时间限制：1秒 空间限制：32768K 热度指数：772288
 *
 *请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 *
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 * @author lixilong
 * @date 2019/01/09
 *
 * https://www.nowcoder.com/practice/4060ac7e3e404ad1a894ef3e17650423?tpId=13&tqId=11155&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 */
public class ReplaceBlankSpace {
  public static void main(String[] args) {
    ReplaceBlankSpace replaceBlankSpace = new ReplaceBlankSpace();
    replaceBlankSpace.test();
  }

  public void test(){
    StringBuffer stringBuffer = new StringBuffer("We Are Happy");
    System.out.println(replaceSpace(stringBuffer));

  }

  public String replaceSpace(StringBuffer str) {
    String  stri = str.toString();
    char[] strChar= stri.toCharArray();
    StringBuffer retStringBuffer = new StringBuffer();
    for(int i=0;i < strChar.length ;i++){
      if(strChar[i] == ' ') {
        retStringBuffer.append("%20");
      }else {
        retStringBuffer.append(strChar[i]);
      }
    }
    return retStringBuffer.toString();
  }


}
