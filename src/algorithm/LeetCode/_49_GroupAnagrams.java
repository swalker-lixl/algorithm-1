package algorithm.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * describe:
 *
 * @author lixilong
 * @date 2019/01/25
 */
public class _49_GroupAnagrams {
   Map<String,int[]> hashMap = new HashMap();
  ArrayList arrayList = new ArrayList();
  Set<Integer> hashSet = new HashSet();
  public List<List<String>> groupAnagrams(String[] strs) {
    String t, s;
    for (int i = 0; i < strs.length; i += 2) {
        s = strs[i]; t = strs[i+1];
      if (hashSet.contains(t)) continue;
      if (isAnagram(s, t)) {
        hashSet.add(s);
        hashSet.add(t);
      }
      if (!arrayList.contains(s)) {
        hashMap.put(s,hashMap.get(s)+hashSet.toArray());
      }
    }
    //循环输出hashmap中数组
  }

 
/*
  // 29 ms 后续再观察
  public  List<List<String>> groupAnagrams(String[] strs) {
    int[] prime = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79,
        83, 89, 97, 101, 103};//最多10609个z

    List<List<String>> res = new ArrayList();
    HashMap<Integer, Integer> map = new HashMap();
    for (String s : strs) {
      int key = 1;
      for (char c : s.toCharArray()) {
        key *= prime[c - 'a'];
      }
      List<String> t;
      if (map.containsKey(key)) {
        t = res.get(map.get(key));
      } else {
        t = new ArrayList();
        res.add(t);
        map.put(key, res.size() - 1);
      }
      t.add(s);
    }
    return res;
  }

    // 28 ms 后续再观察
  public List<List<String>> groupAnagrams(String[] strs) {
    int[] prime = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 41, 43, 47, 53,
        59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103};//最多10609个z

    List<List<String>> resultList = new ArrayList<List<String>>();  //

    // key = 唯一键值， value = resultList 中的 Key 的下标；
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

    for (String s : strs) {
      int key = 1;
      for (char c : s.toCharArray()) {// 获得唯一Key
        key *= prime[c - 'a'];
      }

      List<String> targetList;
      if (map.containsKey(key)) {
        targetList = resultList.get(map.get(key));
      } else {
        targetList = new ArrayList<String>();
        resultList.add(targetList);
        map.put(key, resultList.size() - 1);
      }
      targetList.add(s);
    }
    return resultList;
  }*/

}
