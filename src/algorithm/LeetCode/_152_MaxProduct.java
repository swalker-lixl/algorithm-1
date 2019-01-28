package algorithm.LeetCode;

/**
 * describe:
 *
 * @author lixilong
 * @date 2019/01/28
 */
public class _152_MaxProduct {

// Runtime: 1 ms, faster than 99.11%
  public int maxProduct(int[] A) {
    // edge case
    if (A == null || A.length == 0)
      return 0;

    int max = Integer.MIN_VALUE;
    int product = 1;
    // first go from left to right
    for (int i = 0; i < A.length; i++) {
      product *= A[i];
      if (product > max)
        max = product;
      if (product == 0)
        product = 1; // reset if encounter 0
    }

    // then go from right to left
    product = 1;
    for (int i = A.length - 1; i >= 0; i--) {
      product *= A[i];
      if (product > max)
        max = product;
      if (product == 0)
        product = 1; // reset if encounter 0
    }

    return max;
  }


  // Runtime: 0 ms, faster than 100.00%
  public int maxProduct(int[] nums) {
    int[] prods = new int[nums.length];

    int currProd = 1;
    int maxProd = nums[0];

    //find max from left -> right
    for(int i = 0; i < nums.length; i++) {
      currProd *= nums[i];
      if(currProd > maxProd) {
        maxProd = currProd;
      }

      if(nums[i] == 0) {
        currProd = 1;
      }
    }

    currProd = 1;
    //find max from right -> left
    for(int j = nums.length - 1; j >= 0; j--) {
      currProd *= nums[j];
      if(currProd > maxProd) {
        maxProd = currProd;
      }

      if(nums[j] == 0) {
        currProd = 1;
      }
    }

    return maxProd;
  }


}
