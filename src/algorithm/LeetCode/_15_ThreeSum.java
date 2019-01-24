package algorithm.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * describe:
 *
 * @author lixilong
 * @date 2019/01/24
 */
public class _15_ThreeSum {


/*  public List<List<Integer>> threeSum(int[] nums) {
    Arrays.sort(nums);
    List<List<Integer>> result = new ArrayList<>();
    for (int i = 0; i < nums.length - 2; i++) {
      if (i == 0 || nums[i - 1] != nums[i]) {
        int leftIndex = i + 1;
        int rightIndex = nums.length - 1;
        int smallest = nums[i] + nums[leftIndex] + nums[leftIndex + 1];
        int largest = nums[i] + nums[rightIndex] + nums[rightIndex - 1];
        if (0 < smallest) {
          continue;
        } else if (0 > largest) {
          continue;
        } else {
          while (leftIndex < rightIndex) {
            int sum = nums[i] + nums[leftIndex] + nums[rightIndex];
            if (sum < 0) {
              leftIndex++;
            } else if (sum > 0) {
              rightIndex--;
            } else {
              result.add(Arrays.asList(nums[i], nums[leftIndex], nums[rightIndex]));
              while (leftIndex < rightIndex && nums[leftIndex] == nums[leftIndex + 1]) {
                leftIndex++;
              }
              while (leftIndex < rightIndex && nums[rightIndex] == nums[rightIndex - 1]) {
                rightIndex--;
              }
              leftIndex++;
              rightIndex--;
            }
          }
        }
      }
    }
    return result;
  }*/


  //耗时 Runtime: 22 ms，目前最快的  对特殊情况分析细致
  public List<List<Integer>> threeSum(int[] nums) {
    if (nums.length < 3) {
      return Collections.emptyList();
    }
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    int minValue = Integer.MAX_VALUE;
    int maxValue = Integer.MIN_VALUE;
    int negSize = 0, posSize = 0, zeroSize = 0;
    for (int v : nums) {
      if (v < minValue) {
        minValue = v;
      }
      if (v > maxValue) {
        maxValue = v;
      }
      if (v > 0) {
        posSize++;
      } else if (v < 0) {
        negSize++;
      } else {
        zeroSize++;
      }
    }
    if (zeroSize >= 3) {
      res.add(Arrays.asList(0, 0, 0));
    }
    if (negSize == 0 || posSize == 0) {
      return res;
    }
    if (minValue * 2 + maxValue > 0) {
      maxValue = -minValue * 2;
    } else if (maxValue * 2 + minValue < 0) {
      minValue = -maxValue * 2;
    }

    int[] map = new int[maxValue - minValue + 1];
    int[] negs = new int[negSize];
    int[] poses = new int[posSize];
    negSize = 0;
    posSize = 0;
    for (int v : nums) {
      if (v >= minValue && v <= maxValue) {
        if (map[v - minValue]++ == 0) {
          if (v > 0) {
            poses[posSize++] = v;
          } else if (v < 0) {
            negs[negSize++] = v;
          }
        }
      }
    }
    Arrays.sort(poses, 0, posSize);
    Arrays.sort(negs, 0, negSize);
    int basej = 0;
    for (int i = negSize - 1; i >= 0; i--) {
      int nv = negs[i];
      int minp = (-nv) >>> 1;
      while (basej < posSize && poses[basej] < minp) {
        basej++;
      }
      for (int j = basej; j < posSize; j++) {
        int pv = poses[j];
        int cv = 0 - nv - pv;
        if (cv >= nv && cv <= pv) {
          if (cv == nv) {
            if (map[nv - minValue] > 1) {
              res.add(Arrays.asList(nv, nv, pv));
            }
          } else if (cv == pv) {
            if (map[pv - minValue] > 1) {
              res.add(Arrays.asList(nv, pv, pv));
            }
          } else {
            if (map[cv - minValue] > 0) {
              res.add(Arrays.asList(nv, cv, pv));
            }
          }
        } else if (cv < nv) {
          break;
        }
      }
    }
    return res;
  }

}
