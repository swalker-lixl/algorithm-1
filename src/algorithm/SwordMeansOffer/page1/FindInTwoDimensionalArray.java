package algorithm.SwordMeansOffer.page1;

/**
 * describe:
 *时间限制：1秒 空间限制：32768K 热度指数：885043
 *
 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * @author lixilong
 * @date 2019/01/09
 *
 *
 * 技巧，画一个样例，然后对着看，最后看总结出的规律是否对所有适用
 *
 * https://www.nowcoder.com/practice/abc3fe2ce8e146608e868a70efebf62e?tpId=13&tqId=11154&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 */
public class FindInTwoDimensionalArray {


  public static void main(String[] args) {
    FindInTwoDimensionalArray findInTwoDimensionalArray = new FindInTwoDimensionalArray();
    findInTwoDimensionalArray.test();
  }

  public void test(){
    int[][] array= {
        {1, 2, 3, 4, 5},
        {6, 7, 8, 9, 10},
        {11, 12, 13, 14, 15},
        {16, 17, 18, 19, 20},
        {21, 22, 23, 24,25}};
    System.out.println(Find(5,array));
    System.out.println(Find(25,array));
    System.out.println(Find(30,array));
  }

  public boolean Find(int target, int[][] array){
    //涉及技巧，行最大列最小（行最小列最大），只留一个变量变化   运行时间：190ms 占用内存：17004k
    int row=0;
    int col=array[0].length-1;
    while(row<=array.length-1&&col>=0){
      if(target==array[row][col])
        return true;
      else if(target>array[row][col])
        row++;
      else
        col--;
    }
    return false;
  }

}
