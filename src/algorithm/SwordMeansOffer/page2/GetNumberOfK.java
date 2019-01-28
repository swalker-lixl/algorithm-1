package algorithm.SwordMeansOffer.page2;

import java.util.ArrayList;

/**
 * describe:
 *
 * @author lixilong
 * @date 2019/01/11
 */
public class GetNumberOfK {



  public static void main(String[] args) {
    GetNumberOfK getNumberOfK = new GetNumberOfK();
    getNumberOfK.test();
  }

  public void test(){
    int[] array= {4,2,4,1,4,2};
    System.out.println(GetNumberOfK(array,4));
  }


  public int GetNumberOfK(ArrayList<Integer> data, int k) {
    return biSearch(data, k + 0.5) - biSearch(data, k - 0.5);
  }

  public int biSearch(ArrayList<Integer> data, double num) {
    int s = 0, e = data.size() - 1;
    while (s <= e) {
      int mid = (e - s) / 2 + s;
      if (data.get(mid) < num) {
        s = mid + 1;
      } else if (data.get(mid) > num) {
        e = mid - 1;
      }
    }
    return s;
  }

/*
  链接：https://www.nowcoder.com/questionTerminal/70610bf967994b22bb1c26f9ae901fa2
  来源：牛客网
  运行时间：17ms  占用内存：9432k
  */

  public int GetNumberOfK(int [] array , int k) {
    int length = array.length;
    if(length == 0){
      return 0;
    }
    int firstK = getFirstK(array, k, 0, length-1);
    int lastK = getLastK(array, k, 0, length-1);
    if(firstK != -1 && lastK != -1){
      return lastK - firstK + 1;
    }
    return 0;
  }
  //递归写法
  private int getFirstK(int [] array , int k, int start, int end){
    if(start > end){
      return -1;
    }
    int mid = (start + end) >> 1;
    if(array[mid] > k){
      return getFirstK(array, k, start, mid-1);
    }else if (array[mid] < k){
      return getFirstK(array, k, mid+1, end);
    }else if(mid-1 >=0 && array[mid-1] == k){
      return getFirstK(array, k, start, mid-1);
    }else{
      return mid;
    }
  }
  //循环写法
  private int getLastK(int [] array , int k, int start, int end){
    int length = array.length;
    int mid = (start + end) >> 1;
    while(start <= end){
      if(array[mid] > k){
        end = mid-1;
      }else if(array[mid] < k){
        start = mid+1;
      }else if(mid+1 < length && array[mid+1] == k){
        start = mid+1;
      }else{
        return mid;
      }
      mid = (start + end) >> 1;
    }
    return -1;
  }



/*  public int GetNumberOfK(int [] array , int k) {
    if (array.length == 0) {
      return 0;
    }
    ArrayList arrayList = new ArrayList();
    for (int value : array) {
      arrayList.add(value);
    }
    int index = arrayList.indexOf(k);//getIndexOfK();
    if (index == -1){
      return 0;
    }
    int pre = 1, value = 0,count = 0;
    while (value != pre) {
      value = Integer.parseInt(arrayList.get(index - 1).toString());
      pre = Integer.parseInt(arrayList.get(index).toString());
      if (value == pre) {
        ++index;
        ++count;
      }
    }
    return count;
  }*/

}
