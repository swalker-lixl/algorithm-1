package algorithm.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * describe:
 *
 * @author lixilong
 * @date 2019/01/25
 */
public class _18_FourSum {

  int len = 0;
  public List<List<Integer>> fourSum(int[] nums, int target) {
    len = nums.length;
    Arrays.sort(nums);
    return kSum(nums, target, 4, 0);
  }

  //通用解法来说，只要会做 2sum Problem问题，以后只需要将k 经变换不断降低即可 Runtime: 39 ms
  private ArrayList<List<Integer>> kSum(int[] nums, int target, int k, int index) {
    ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
    if(index >= len) {
      return res;
    }
    if(k == 2) {
      int i = index, j = len - 1;
      while(i < j) {
        //find a pair
        if(target - nums[i] == nums[j]) {
          List<Integer> temp = new ArrayList();
          temp.add(nums[i]);
          temp.add(target-nums[i]);
          res.add(temp);
          //skip duplication
          while(i<j && nums[i]==nums[i+1]) i++;
          while(i<j && nums[j-1]==nums[j]) j--;
          i++;
          j--;
          //move left bound
        } else if (target - nums[i] > nums[j]) {
          i++;
          //move right bound
        } else {
          j--;
        }
      }
    } else{
      for (int i = index; i < len - k + 1; i++) {
        //use current number to reduce ksum into k-1sum
        ArrayList<List<Integer>> temp = kSum(nums, target - nums[i], k-1, i+1);
        if(temp != null){
          //add previous results
          for (List<Integer> t : temp) {
            t.add(0, nums[i]);
          }
          res.addAll(temp);
        }
        while (i < len-1 && nums[i] == nums[i+1]) {
          //skip duplicated numbers
          i++;
        }
      }
    }
    return res;
  }


  //the faster : Runtime: 39 ms
  public List<List<Integer>> fourSum(int[] nums, int target) {
    List<List<Integer>> result = new ArrayList();
    Arrays.sort(nums);

    for(int i=0; i < nums.length - 3; i++) {
      if(nums[i]+nums[i+1]+nums[i+2]+nums[i+3] > target)
        break;
      if(nums[i]+nums[nums.length-1]+nums[nums.length-2]+nums[nums.length-3]<target)
        continue;
      if(i>0 && nums[i-1]==nums[i]) continue;

      for(int j=i+1; j<nums.length-2; j++) {
        if(nums[i]+nums[j]+nums[j+1]+nums[j+2]>target)
          break;
        if(nums[i]+nums[j]+nums[nums.length-1]+nums[nums.length-2]<target)
          continue;
        if(j>i+1 && nums[j]==nums[j-1])
          continue;

        int current = nums[i] + nums[j];

        int k = j+1;
        int l = nums.length-1;

        while(k<l) {
          int sum = current + nums[k] + nums[l];
          if(sum==target) {
            result.add(Arrays.asList(new Integer[]{nums[i], nums[j], nums[k], nums[l]}));
            while(k<l && nums[k]==nums[k+1]) {
              k++;
            }
            while(k<l && nums[l]==nums[l-1]) {
              l--;
            }

            k++;
            l--;
          } else if(sum<target) {
            k++;
          } else {
            l--;
          }
        }
      }
    }

    return result;
  }

}
