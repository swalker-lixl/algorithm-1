package algorithm.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * describe:
 *
 * @author lixilong
 * @date 2019/01/25
 */
public class _438_FindAnagrams {
  //方法1: 把子串所有所有可能的子母异位词加到set里，然后类似滑动 子串长度的窗口一样，挨个判断是否在set中
  public List<Integer> findAnagrams(String s, String p) {
    //之后更新实现逻辑
  }

  //方法2: 把子串所有所有可能的子母异位词加到set里，然后类似滑动 子串长度的窗口一样，挨个判断是否在set中
  public List<Integer> findAnagrams(String s, String p) {
    int left = 0;
    int right = 0;
    int sLen = s.length();
    int pLen = p.length();
    int[] hash = new int[256];
    List<Integer> pos = new ArrayList<Integer>();

    for (int i = 0; i<pLen; i++) {
      hash[(int)p.charAt(i)]++;
    }
    int count = 0;

    while (right < sLen) {
      if (hash[(int)s.charAt(right)] > 0) {
        hash[(int)s.charAt(right)]--;
        count++;
        right++;
      } else {
        hash[(int)s.charAt(left)]++;
        count--;
        left++;
      }

      if(count == pLen) {
        pos.add(left);
      }

    }
    return pos;
  }

  //方法3: 把子串所有所有可能的子母异位词加到set里，
  public List<Integer> findAnagrams(String s, String p) {
    char[] ch1 = s.toCharArray(), ch2 = p.toCharArray();
    int[] count = new int[26];
    List<Integer> res = new LinkedList<>();
    for (char c : ch2)
      count[c-'a']++;
    int left = 0, right = 0, match = 0;
    while (right < ch1.length) {
      if (count[ch1[right++]-'a']-- > 0)
        match++;
      while (match == ch2.length) {
        if (right - left == ch2.length)
          res.add(left);
        if (count[ch1[left++]-'a']++ == 0)
          match--;
      }
    }
    return res;
  }

  //方法4: 把子串所有所有可能的子母异位词加到set里，
  public List<Integer> findAnagrams(String s, String p) {
    List<Integer> list=new ArrayList<Integer>();
    int[] sump=new int[123];
    int[] sums=new int[123];
    char[] chs=s.toCharArray();
    char[] chp=p.toCharArray();
    int k=chp.length,end=chp.length;
    if(chs.length<end) return list;

    for(int i=0;i<end;i++){
      sump[chp[i]]++;
      sums[chs[i]]++;
    }

    while(true){
      boolean flag=true;
      for(int j=97;j<123;j++){
        if(sums[j]!=sump[j]) {
          flag=false;
          break;
        }
      }
      if(flag)list.add(k-end);
      if(k==chs.length)break;
      sums[chs[k-end]]--;
      sums[chs[k]]++;
      k++;
    }
    return list;
  }

}
