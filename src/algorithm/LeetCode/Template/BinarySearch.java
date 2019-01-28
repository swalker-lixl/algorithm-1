package algorithm.LeetCode.Template;

/**
 * describe:
 * 条件(3个)：
 * sorted + bounded + accessible by index
 *
 *
 *
 * 应用case：
 * 二分查找只适用顺序存储结构（所以数组很适合，链表不适合）。
 *
 * 主体逻辑：
 *
 *
 * @author lixilong
 * @date 2019/01/19
 */
public class BinarySearch {


  //假定链表单调递增
  public int binarySearch(int[] array, int target) {
    int left = 0, mid = 0, right = array.length - 1;
    while (left <= right) {
      mid = left + (right - left) / 2;
      if (array[left] == target) {
        return left;
      } else if (left < target) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return -1;
  }

}
