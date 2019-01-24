package algorithm.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * describe:
 *  给出两个字符串，判断是否元素内容一样，但位置可能不同。
 * @author lixilong
 * @date 2019/01/24
 */
public class _242_IsAnagram {


  public static void main(String[] args) {
    String s ="anagram", t = "nagaram";
    _242_IsAnagram isAnagram = new _242_IsAnagram();
    System.out.println(isAnagram.isAnagram(s,t));
  }


//方法1；先排序 Arrays 的排序功能，再比对 n * log n
public boolean isAnagram(String s, String t) {
  if (s.length() != t.length()) return false;
  char[] as = s.toCharArray();
  char[] ts = t.toCharArray();
  Arrays.sort(as);
  Arrays.sort(ts);
  return Arrays.equals(as, ts);
}

//方法2；分别对对应的元素计数，最后比较两个map是否相同 O（n）+ O (1)
Map<Character,Integer> sMap = new HashMap();
Map<Character,Integer> tMap = new HashMap();

  public boolean isAnagram(String s, String t) {
    char[] sChars = s.toCharArray();
    char[] tChars = t.toCharArray();
    boolean isAnagram = false;
    if (sChars.length < 1 || tChars.length < 1 || sChars.length != tChars.length) {
      return isAnagram;
    }
    for (int i = 0; i < sChars.length; i++) { //因为 sChars.length == tChars.length，所以此时用一个即可
      if (sMap.containsKey(sChars[i])) {
        sMap.put(sChars[i], sMap.get(sChars[i]) + 1);
      } else {
        sMap.put(sChars[i], 1);
      }
      if (tMap.containsKey(tChars[i])) {
        tMap.put(tChars[i], tMap.get(tChars[i]) + 1);
      } else {
        tMap.put(tChars[i], 1);
      }
    }
    return sMap.equals(tMap);
  }

//方法3: 对以一个字符串的的元素存储，最后拿第二个map判断是否相同 O（n）+ O (n)
  Map<Integer,Character> charMap = new HashMap();
  public boolean isAnagram(String s, String t) {
    char[] sChars = s.toCharArray();
    char[] tChars = t.toCharArray();
    boolean isAnagram = false;
    if (sChars.length == 0 && tChars.length == 0) return isAnagram;
    if (sChars.length != tChars.length) return isAnagram;
    for (int i = 0; i < sChars.length; i++) charMap.put(i, sChars[i]);
    for (int j = 0; j < tChars.length; j++) {
      if (charMap.containsValue(tChars[j])){
        if (!charMap.get(j).equals(tChars[j])){ //// equals方法有问题，具体再参详
          isAnagram = true;
        }
      }else {
        return false;
      }
    }
    return isAnagram;
  }

}
