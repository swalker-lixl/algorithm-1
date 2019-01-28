package algorithm.SwordMeansOffer.page2;

/**
 * describe:
 *时间限制：2秒 空间限制：32768K 热度指数：235212
 *
 *
 *在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组,求出这个数组中的逆序对的总数P。
 * 并将P对1000000007取模的结果输出。
 * 即输出P%1000000007
 * @author lixilong
 * @date 2019/01/11
 */
public class InversePairs {



  public static void main(String[] args) {
    InversePairs inversePairs = new InversePairs();
    inversePairs.test();
  }

  public void test(){
    int[] array= {1,2,3,4,5,6,7,0};
    //int[] array1= {1,2,3,2,2,2,5,4,2};
   // System.out.println(inversePairs(array));
  }

  /*public int inversePairs(int [] array) {
    ArrayList arrayList = new ArrayList();
    for (int value : array) {
            arrayList.add(value);
    }

    int count = 0;
    int lengthArray = arrayList.size() ;
    if (lengthArray <= 1) {
      return 0;
    }

    int current, pre ;
    current = array[lengthArray - 1];
    pre =  array[lengthArray - 2];

    if ( current < pre ) {
      ++count;
      arrayList.remove(lengthArray-1);
      lengthArray = arrayList.size();
      inversePairs()
    }

    for (int i = 0; i < lengthArray; i++) {

    }


    return
  }*/



  /*
  链接：https://www.nowcoder.com/questionTerminal/96bd6684e04a44eb80e6a68efc0ec6c5
  来源：牛客网
  运行时间：644ms  占用内存：54456k
  */

  public int InversePairs(int[] array) {
    if (array == null || array.length == 0) {
      return 0;
    }
    int[] copy = new int[array.length];
    for (int i = 0; i < array.length; i++) {
      copy[i] = array[i];
    }
    int count = InversePairsCore(array, copy, 0, array.length - 1);//数值过大求余
    return count;

  }

  private int InversePairsCore(int[] array, int[] copy, int low, int high) {
    if (low == high) {
      return 0;
    }
    int mid = (low + high) >> 1;
    int leftCount = InversePairsCore(array, copy, low, mid) % 1000000007;
    int rightCount = InversePairsCore(array, copy, mid + 1, high) % 1000000007;
    int count = 0;
    int i = mid;
    int j = high;
    int locCopy = high;
    while (i >= low && j > mid) {   // ****************************************************犯迷糊
      if (array[i] > array[j]) {
        count += j - mid;
        copy[locCopy--] = array[i--];
        if (count >= 1000000007)//数值过大求余
        {
          count %= 1000000007;
        }
      } else {
        copy[locCopy--] = array[j--];
      }
    }
    for (; i >= low; i--) {
      copy[locCopy--] = array[i];
    }
    for (; j > mid; j--) {
      copy[locCopy--] = array[j];
    }
    for (int s = low; s <= high; s++) {
      array[s] = copy[s];
    }
    return (leftCount + rightCount + count) % 1000000007;
  }



/*  链接：https://www.nowcoder.com/questionTerminal/96bd6684e04a44eb80e6a68efc0ec6c5
  来源：牛客网*//*

  int InversePairs(ArrayList<Integer> data) {
    int length=data.size();
    if(length<=0)
      return 0;
    //vector<int> copy=new vector<int>[length];
    ArrayList<Integer> copy = new ArrayList<Integer>();
    for(int i=0;i<length;i++)
      copy.add(data.get(i));
     long count=InversePairsCore(data,copy,0,length-1);
    //delete[]copy;
    return (int)count%1000000007;
  }
  public long InversePairsCore(ArrayList<Integer> data,ArrayList<Integer> copy,int start,int end)
  {
    if(start==end)
    {
      copy.get(start);
      return 0;
    }
    int length=(end-start)/2;
    long long left=InversePairsCore(copy,data,start,start+length);
    long long right=InversePairsCore(copy,data,start+length+1,end);

    int i=start+length;
    int j=end;
    int indexcopy=end;
    long long count=0;
    while(i>=start&&j>=start+length+1)
    {
      if(data[i]>data[j])
      {
        copy[indexcopy--]=data[i--];
        count=count+j-start-length;          //count=count+j-(start+length+1)+1;
      }
      else
      {
        copy[indexcopy--]=data[j--];
      }
    }
    for(;i>=start;i--)
      copy[indexcopy--]=data[i];
    for(;j>=start+length+1;j--)
      copy[indexcopy--]=data[j];
    return left+right+count;
  }*/
}
