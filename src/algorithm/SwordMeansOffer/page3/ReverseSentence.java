package algorithm.SwordMeansOffer.page3;/*
package AlgorithmsDS.SwordMeansOffer.page3;

*/
/**
 * describe:
 * 时间限制：1秒 空间限制：32768K 热度指数：238752
 *
 * 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。
 * 同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。
 * 例如，“student. a am I”。
 * 后来才意识到，这家伙原来把句子单词的顺序翻转了，正确的句子应该是“I am a student.”。
 * Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
 *
 * @author lixilong
 * @date 2019/01/14
 *//*

public class ReverseSentence {

  public String ReverseSentence(String str) {
    if (str.equals(" ") || str.equals("")) {
      return str;
    }
    StringBuffer stringBuffer = new StringBuffer();
    String[] strChars = str.split(" ");
    for (int i = strChars.length - 1; i >= 0; i--) {
      if (i == 0) {
        stringBuffer.append(strChars[i]);
      }else {
        stringBuffer.append(strChars[i]+" ");
      }
    }
    return stringBuffer.toString();
  }


  */
/*
  来源：牛客网
  链接：https://www.nowcoder.com/questionTerminal/3194a4f4cf814f63919d0790578d51f3
  *//*

 */
/* public String ReverseSentence(String str) {
      String.reverse(str.begin(),str.end());
      int front=0;
      int back=0;
      int size = str.size();
      while(front<size){
        while(front<size&&str[front]==' ')++front;
        back=front;
        while(back<size&&str[back]!=' ')++back;
        reverse(str.begin()+front, str.begin()+back);
        front=back;
      }
      return str;
    }
  }*//*

  */
/*
  来源：牛客网
  链接：https://www.nowcoder.com/questionTerminal/3194a4f4cf814f63919d0790578d51f3
  运行时间：21ms 占用内存：9528k
  *//*

  public String ReverseSentence(String str) {
    return (str.lastIndexOf(" ")==-1)?str:str.substring(str.lastIndexOf(" ")+1) +" "+ReverseSentence(str.substring(0,str.lastIndexOf(" ")));
  }
  }

}
*/
