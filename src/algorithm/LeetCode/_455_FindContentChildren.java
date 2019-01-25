package algorithm.LeetCode;

import java.util.Arrays;

/**
 * describe:
 *
 * @author lixilong
 * @date 2019/01/25
 */
public class _455_FindContentChildren {
  //难度为easy自己初稿
  //问题：反思没做出来原因 【逻辑问题，没熟练应用whlie语句，控制太笨拙】
  public int findContentChildren(int[] g, int[] s) {
    Arrays.sort(g);
    Arrays.sort(s);
    int count = 0;
    int j = 0;
    for (int i = 0; i < g.length; i++) { //从小到大遍历胃口值
      for (; j < s.length; ) {
          if (g[i] <= s[j]) { ++count; ++j;continue;}
          ++j;
      }
    }
    return count;
  }

  /*//难度为easy：while写法
  public int findContentChildren(int[] g, int[] s) {
    Arrays.sort(g);
    Arrays.sort(s);
    int count = 0;

    int i = 0;
    int j = 0;

    while (i < g.length && j < s.length) {
      if (s[j] >= g[i]) {
        count++;
        i++;
        j++;
      } else {
        j++;
      }
    }
    return count;
  }

  //难度为easy： for写法
  public int findContentChildren(int[] g, int[] s) {
    if(s.length==0){return 0;} //return条件判断，加速返回
    Arrays.sort(g);
    Arrays.sort(s);

    int k =0;
    int res=0;
    for(int i  = 0;i<s.length;i++){ //无论如何，每遍历一遍，s都要向前推进一个，但是g不一定
      if(g[k]<=s[i]){
        res++;
        k++;
        if(k==g.length) {return res;} //return条件判断，加速返回
      }
    }
    return res;
  }*/

}
