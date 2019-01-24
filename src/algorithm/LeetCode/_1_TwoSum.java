package algorithm.LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * describe:
 *
 * @author lixilong
 * @date 2019/01/24
 */
public class _1_TwoSum {

  Set set = new HashSet();
  ArrayList<Integer> arrayList = new ArrayList();
  int[] reNums = new int[2];

  //方法1： 暴力解法 O（n * n）
  public int[] twoSum(int[] nums, int target) {
    for (int i = 0; i < nums.length; i++) {
      for (int j = i + 1; j < nums.length; j++) { //当前元素不用再考虑，直接用靠后节点遍历即可，所以 j=i+1做初始化
        if (nums[j] == target - nums[i]) {
          return new int[]{i, j};
        }
      }
    }
    throw new IllegalArgumentException("No two sum solution");
  }


  //方法2：遍hash表  时间复杂度：O(n)  空间复杂度：O(n)
  public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap();
    for (int i = 0; i < nums.length; i++) {
      map.put(nums[i], i);
    }
    for (int i = 0; i < nums.length; i++) {
      int complement = target - nums[i];
      if (map.containsKey(complement) && map.get(complement) != i) {
        return new int[] { i, map.get(complement) };
      }
    }
    throw new IllegalArgumentException("No two sum solution");
  }

  //方法3：一遍hash表  时间复杂度：O(n)  空间复杂度：O(n)
  public int[] twoSum(int[] nums, int target) {
    HashMap<Integer, Integer> map = new HashMap<>();

    for (int index = 0; index < nums.length; index++) {
      int number = nums[index];
      int complement = target - number;
      Integer complementIndex = map.get(complement);

      if (complementIndex != null)
      {
        return new int[] { complementIndex, index };
      }

      map.put(number, index);
    }

    throw new IllegalArgumentException("No solution.");
  }

  //方法4：维护一个数组  时间复杂度：O(n)  空间复杂度：O(n) 但相比3提高了很大效率
  int size = 4096;
  int[] map = new int[size];
  int length = 4095;
  int index;

  public int[] twoSum(int[] nums, int target) {
    for (int i = 0; i < nums.length; i++) {
      index = nums[i]&length; // 大神永远那么娴熟，与2^12与运算「」

      if (map[index] != 0) {
        return new int[] { map[index] - 1, i };
      } else {
        map[(target - index)&length ] = i + 1; //数组的元素赋值，对应索引也用与运算「」
      }
    }
    throw new IllegalArgumentException("No two sum solution");
  }
}
