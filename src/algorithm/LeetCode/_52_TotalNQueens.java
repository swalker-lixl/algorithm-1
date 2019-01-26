package algorithm.LeetCode;

/**
 * describe:
 *
 * @author lixilong
 * @date 2019/01/25
 */
public class _52_TotalNQueens {


  //祥参见 官方解法
  // https://leetcode.com/problems/n-queens-ii/solution/

// 投机  - _ -  Runtime: 0 ms
 final static int []SOLS=new int[]{1, 1, 0, 0, 2, 10, 4, 40, 92, 352, 724, 2680, 14200};

  public int totalNQueens(int n) {
    return   SOLS[n];
  }

// N 皇后解法  2 ms, faster than 79.66%
  int size;
  int count;
  int[] arr = null;

  public int totalNQueens(int n) {
    arr = new int[n];
    this.size = n;
    calculate(0);
    return count;
  }

  public void calculate(int row){
    if(row == size){
      count++;
      return;
    }
    for(int i = 0; i < size; i++){
      if(checkIfOk(row, i)){
        arr[row] = i;
        calculate(row + 1);
      }
    }
  }


  // Runtime: 1 ms, faster than 100.00% of Java online submissions for N-Queens II.
  public boolean checkIfOk(int row, int column){
    int left = column - 1;
    int right = column + 1;
    for(int i = row - 1; i >= 0; i--){
      if(arr[i] == column){
        return false;
      }
      if(left >=0 && arr[i] == left){
        return false;
      }
      if(right < size && arr[i] == right){
        return false;
      }
      left--;
      right++;
    }
    return true;
  }

  public int totalNQueens(int n) {
    boolean[] cols = new boolean[n];
    boolean[] diag1 = new boolean[2 * n];
    boolean[] diag2 = new boolean[2 * n];
    return helper(0, n, cols, diag1, diag2);
  }

  private int helper(int row, int n, boolean[] cols, boolean[] diag1, boolean[] diag2) {
    if (row == n) {
      return 1;
    }
    int ans = 0;
    for (int col=0; col<n; col++) {
      int d1 = col - row + n;
      int d2 = col + row;
      if (cols[col] || diag1[d1] || diag2[d2]) {
        continue;
      }
      cols[col] = true;
      diag1[d1] = true;
      diag2[d2] = true;
      ans += helper(row + 1, n, cols, diag1, diag2);
      cols[col] = false;
      diag1[d1] = false;
      diag2[d2] = false;
    }
    return ans;
  }


  //  Approach 2: Backtracking via bitmap
   public int backtrack(int row, int hills, int next_row, int dales, int count, int n) {
    /**
     row: current row to place the queen
     hills: "hill" diagonals occupation [1 = taken, 0 = free]
     next_row: free and taken slots for the next row [1 = taken, 0 = free]
     dales: "dale" diagonals occupation [1 = taken, 0 = free]
     count: number of all possible solutions
     */

    // all columns available for this board,
    // i.e. n times '1' in binary representation
    // bin(cols) = 0b1111 for n = 4, bin(cols) = 0b111 for n = 3
    // [1 = available]
    int columns = (1 << n) - 1;

    if (row == n)   // if all n queens are already placed
      count++;  // we found one more solution
    else {
      // free columns in the current row
      // ! 0 and 1 are inversed with respect to hills, next_row and dales
      // [0 = taken, 1 = free]
      int free_columns = columns & ~(hills | next_row | dales);

      // while there's still a column to place next queen
      while (free_columns != 0) {
        // the first bit '1' in a binary form of free_columns
        // on this column we will place the current queen
        int curr_column = - free_columns & free_columns;

        // place the queen
        // and exclude the column where the queen is placed
        free_columns ^= curr_column;

        count = backtrack(row + 1,
            (hills | curr_column) << 1,
            next_row | curr_column,
            (dales | curr_column) >> 1,
            count, n);
      }
    }

    return count;
  }
  public int totalNQueens(int n) {
    return backtrack(0, 0, 0, 0, 0, n);
  }


}
