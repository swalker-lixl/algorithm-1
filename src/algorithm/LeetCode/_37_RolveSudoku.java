package algorithm.LeetCode;

/**
 * describe:
 *
 *
 * 编写一个程序，通过已填充的空格来解决数独问题。
 *
 * 一个数独的解法需遵循如下规则：
 *
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 * 空白格用 '.' 表示。
 *
 *
 *
 * @author lixilong
 * @date 2019/01/26
 */
public class _37_RolveSudoku {

  // Runtime: 8 ms, faster than 92.86%
  int[][] hCounts;
  int[][] vCounts;
  int[][][] sqCounts;
  public void solveSudoku(char[][] board) {
    hCounts = new int[9][9];
    vCounts = new int[9][9];
    sqCounts = new int[3][3][9];
    for (int row=0;row<9;row++) {
      for (int col=0;col<9;col++) if (board[row][col] != '.') set(board, row, col, board[row][col]);
    }
    solve(board, 0, 0);
  }
  private boolean solve(char[][] board, int row, int col) {
    if (row == board.length) return true;
    if (col == board[0].length) return solve(board, row+1, 0);
    if (board[row][col] != '.') return solve(board, row, col+1);

    for (int i=1;i<10;i++) {
      char n = (char)('0' + i);
      if (canAdd(row, col, n)) {
        set(board, row, col, n);
        if (solve(board, row, col+1)) return true;
        unset(board, row, col, n);
      }
    }
    return false;
  }
  private boolean canAdd(int row, int col, char c) {
    int n = c-'0'-1;
    return hCounts[row][n] == 0 && vCounts[col][n] == 0 && sqCounts[row/3][col/3][n] == 0;
  }
  private void set(char[][] board, int row, int col, char c) {
    board[row][col] = c;
    int n = c-'0'-1;
    hCounts[row][n]++;
    vCounts[col][n]++;
    sqCounts[row/3][col/3][n]++;
  }
  private void unset(char[][] board, int row, int col, char c) {
    board[row][col] = '.';
    int n = c-'0'-1;
    hCounts[row][n]--;
    vCounts[col][n]--;
    sqCounts[row/3][col/3][n]--;
  }



  // Runtime: 3 ms, faster than 100.00%

  public void solveSudoku(char[][] board) {
    solveSudoku_Fast(board);
  }

    /*

        We could replace '.' one by one with a digit that is compatible, if we can't find a compatible digit for a cube, we backtrace to a cube and
        fill it with another compatible digit. if we have replace all '.' with a compatible digit, we get a solution.

        Heuristic method: The key point is which '.' should we replace first? we should first replace intuitively a '.' which has the fewest compatible
        digit. why? let‘s say，we chosed a digit for the first '.' and finally we find it is a wrong digit, we have to traceback to this first '.', it
        would be painfully inefficient, so, we should first replace a '.' which we are most likely choose a right digit for it. The fewer compatible
        digits the '.' has, the more likely we can choose a right digits for it.


    Key Idea:
        1. Keep going till the Board is full. We always play valid moves, so we do nothave to check for isValid() every time we fill a entry.
        2. Get the nextMove which is the location which ahs minimum number of  qualifying chars
        3. For each char:
            3.1 fill the entry and call recursively
        4. Keep trying till no more moves are possible.
    */

  public void solveSudoku_Fast(char[][] board) {
    solve(board);
  }

  // Recursively and Heuristic solve it
  // Using a heuristic solution, each step looks for the grid with the least degree of freedom. Of course, if you encounter a grid with a
  // degree of freedom of 0, return this time, and return when you find a solution.
  public boolean solFound = false;      // Have we found out the solution? 是否找到了解
  public void solve(char[][] board) {
    if(solFound || isFull(board)) {
      solFound = true;
      return;
    }

    int[] index = findIndex(board);    // findout the ’.‘ we should replace
    if(index != null) {
      char[] values = findAvaible(index[2], index[3]);   // what digits can we replace
      for(char e : values) {
        board[index[0]][index[1]] = e;
        solve(board);

        if(solFound) {
          return;
        }
      }

      board[index[0]][ index[1]] = '.';    // If there is no solution under these values, then return, but restore it first.
    }
  }

  // return int[4]:null if that board can't be a solution.
  //           [0] and [1] is the index,
  //           [2] is the total compatible digits it has,
  //           [3] is a vector record those digits
  // for example: if [3] = 00..001110, then we have compatible digits 2,3,4 (the 2th, 3th, 4th bits is 1)
  public int[] findIndex(char[][] board) {
    int[] result = null;    // Record the location of the solution with the lowest degree of freedom, and the feasible solution
    short[] r = new short[9];   // a vector representing the remaining elements
    short[] c = new short[9];   // Representing each column...
    short[] g = new short[9];   // The representative does not have a 3*3 square
    short mask = 0x01FF;

    // Horizontal, vertical vector
    for(int i = 0; i < board.length; i++) {
      short sr = 0, sc = 0, cell = 0;    // Record occupied location
      for(int j = 0; j < board.length; j++) {
        if(board[i][j] != '.') {
          sr |= (1 << (board[i][j] - '1'));
        }

        if(board[j][i] != '.') {
          sc |= (1 << (board[j][i] - '1'));
        }

        int cellRow = i / 3;
        int cellCol = i % 3;
        int row = cellRow * 3 + j / 3;
        int col = cellCol * 3 + j % 3;
        if (board[row][col] != '.') {
          cell |= (1 << (board[row][col] - '1'));
        }
      }

      sr = (short)((~sr) & mask);    // Now the bit of 1 in sr represents a desirable character.
      sc = (short)((~sc) & mask);
      cell = (short)((~cell) & mask);
      r[i] = sr;
      c[i] = sc;
      g[i] = cell;
    }

    //The solution vectors for all dimensions have been solved, and now we need to solve the solution for each position, and the subscripts
    //  with the least degree of freedom, the degrees of freedom, and the vector return
    int min = Integer.MAX_VALUE;    // Minimum degree of freedom
    for(int i = 0; i < board.length; i++) {
      for(int j = 0; j < board.length; j++) {
        if(board[i][j] == '.') {
          short m = (short) (r[i] & c[j] & g[(i / 3) * 3 + j / 3]);

          if(m == 0) {
            return null;
          }

          int n = countBit(m);
          if(min > n) {
            min = n;
            result = new int[]{i, j, min, m};
          }
        }
      }
    }

    return result;
  }

  // count the bits with value 1 in the integer vector
  public int countBit(int x) {
    int count = 0;
    while(x != 0) {
      count++;
      x &= (x - 1);
    }
    return count;
  }

  // Solving the characters on the corresponding bits according to the vector m
  public char[] findAvaible(int n, int m) {
    char[] r = new char[n];
    int i = 0, j = 0;
    while(j < n) {
      if((m & (1 << i)) != 0) {
        r[j++] = "123456789".charAt(i);
      }
      i++;
    }
    return r;
  }

  public boolean isFull(char[][] board) {
    for(char[] row : board) {
      for(char c : row) {
        if (c == '.') {
          return false;
        }
      }
    }
    return true;
  }



}
