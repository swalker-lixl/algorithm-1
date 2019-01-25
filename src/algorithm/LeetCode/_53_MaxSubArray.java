package algorithm.LeetCode;

/**
 * describe:
 *
 * @author lixilong
 * @date 2019/01/25
 */
public class _53_MaxSubArray {

  //方法1：加注释说明
  //Time complexity : O(nlgn)  Space complexity : O(lgn)
  public int maxSubArray(int[] nums) {
    int sum = nums[0];
    int maxOfAll = nums[0];
    for (int i = 1; i < nums.length; i++) {
      if (sum >= 0) {
        sum += nums[i];
        maxOfAll = Math.max(sum, maxOfAll);
      } else {
        sum = nums[i];
        maxOfAll = Math.max(sum, maxOfAll);
      }
    }
    return maxOfAll;
  }

  //方法2：对方法1的优化
  //Time complexity : O(nlgn)  Space complexity : O(lgn)
  public int maxSubArray(int[] nums) {
    int max = Integer.MIN_VALUE;
    int sum = 0;
    for(int i : nums){
      sum = sum + i;
      max = Math.max(max, sum);
      if(sum < 0){
        sum = 0;
      }
    }

    return max;
  }

}
