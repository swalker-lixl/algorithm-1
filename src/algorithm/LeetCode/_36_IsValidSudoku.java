package algorithm.LeetCode;

import java.util.HashMap;

/**
 * describe:
 * 36. 有效的数独 https://leetcode-cn.com/problems/valid-sudoku/
 *
 *
 * 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
 *
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 *
 * @author lixilong
 * @date 2019/01/19
 */
public class _36_IsValidSudoku {

  //官方解法：Runtime: 17 ms, faster than 59.80%
  public boolean isValidSudoku(char[][] board) {
    // init data
    HashMap<Integer, Integer> [] rows = new HashMap[9];
    HashMap<Integer, Integer> [] columns = new HashMap[9];
    HashMap<Integer, Integer> [] boxes = new HashMap[9];
    for (int i = 0; i < 9; i++) {
      rows[i] = new HashMap<Integer, Integer>();
      columns[i] = new HashMap<Integer, Integer>();
      boxes[i] = new HashMap<Integer, Integer>();
    }

    // validate a board
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        char num = board[i][j];
        if (num != '.') {
          int n = (int)num;
          int box_index = (i / 3 ) * 3 + j / 3;

          // keep the current cell value
          rows[i].put(n, rows[i].getOrDefault(n, 0) + 1);
          columns[j].put(n, columns[j].getOrDefault(n, 0) + 1);
          boxes[box_index].put(n, boxes[box_index].getOrDefault(n, 0) + 1);

          // check if this value has been already seen before
          if (rows[i].get(n) > 1 || columns[j].get(n) > 1 || boxes[box_index].get(n) > 1)
            return false;
        }
      }
    }

    return true;
  }


  //推荐解法：Runtime: 13 ms, faster than 100.00%

  private final int boxSize = 3;

  public boolean isValidSudoku(char[][] board) {
    for (int i = 0; i < board.length; i ++) {
      for (int j = 0; j < board[0].length; j ++) {
        if (!valid(board, i, j)) {
          return false;
        }
      }
    }
    return true;
  }

  private boolean valid(char[][] board, int row, int column) {
    char val = board[row][column];
    if (val == '.') {
      return true;
    }
    for (int i = 0; i < board.length; i ++) {
      if (i != row && board[i][column] == val) {
        return false;
      }
    }
    for (int j = 0; j < board[0].length; j ++) {
      if (j != column && board[row][j] == val) {
        return false;
      }
    }
    int rStart = row / boxSize * boxSize;
    int cStart = column / boxSize * boxSize;
    for (int i = rStart; i < rStart + boxSize; i ++) {
      for (int j = cStart; j < cStart + boxSize; j ++) {
        if ((i != row || j != column) && board[i][j] == val) {
          return false;
        }
      }
    }
    return true;
  }

}
