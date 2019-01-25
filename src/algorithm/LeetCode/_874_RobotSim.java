package algorithm.LeetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * describe:
 *  机器人在一个无限大小的网格上行走，从点 (0, 0) 处开始出发，面向北方。该机器人可以接收以下三种类型的命令：
 *
 * -2：向左转 90 度
 * -1：向右转 90 度
 * 1 <= x <= 9：向前移动 x 个单位长度
 * 在网格上有一些格子被视为障碍物。
 *
 * 第 i 个障碍物位于网格点  (obstacles[i][0], obstacles[i][1])
 *
 * 如果机器人试图走到障碍物上方，那么它将停留在障碍物的前一个网格方块上，但仍然可以继续该路线的其余部分。
 *
 * 返回从原点到机器人的最大欧式距离的平方。
 *
 *
 * @author lixilong
 * @date 2019/01/25
 */
public class _874_RobotSim {

  static final int[] dx = {0, 1, 0, -1};
  static final int[] dy = {1, 0, -1, 0};


  //耗时 ：12 ms
  public int robotSim(int[] commands, int[][] obstacles) {
    Set<Pos> walls = new HashSet(obstacles.length * 2);
    for (int[] obs : obstacles) {
      walls.add(new Pos(obs[0], obs[1]));
    }

    Pos pos = new Pos(0, 0);
    int incx = 0;
    int incy = 0;
    int dir = 0;
    int max = 0;
    for (int command : commands) {
      switch (command) {
        case -2:
          dir = (dir + 3) % 4;
          break;
        case -1:
          dir = (dir + 1) % 4;
          break;
        default: {

          incx = dx[dir];
          incy = dy[dir];

          for (int step = 1; step <= command; ++step) {
            pos.x += incx;
            pos.y += incy;

            if (walls.contains(pos)) {
              pos.x -= incx;
              pos.y -= incy;
              break;
            }
          }

          max = Math.max(pos.x * pos.x + pos.y * pos.y, max);

          break;
        }
      }
    }

    return max;
  }

  class Pos {
    int x;
    int y;

    Pos(int x, int y) {
      this.x = x;
      this.y = y;
    }

    public int hashCode() {
      return x * 31 + y;
    }

    public boolean equals(Object obj) {
      Pos pos2 = (Pos)obj;
      return x == pos2.x && y == pos2.y;
    }
  }


//耗时 ：48 ms
  private static final int NORTH = 1, EAST = 2, SOUTH = 3, WEST = 4;
  private static final int LEFT = -2, RIGHT = -1;
  private Set<String> coordsBlocked;
  private int direction;
  private int x;
  private int y;

  public int robotSim(int[] commands, int[][] obstacles) {
    if (commands == null || commands.length == 0) return 0;

    this.coordsBlocked = new HashSet<>();
    for(int i = 0; i < obstacles.length; i++) {
      this.coordsBlocked.add(obstacles[i][0] + "_" + obstacles[i][1]);
    }

    this.direction = 1;
    this.x = 0;
    this.y = 0;
    int max = 0;

    for (int c: commands) {
      switch (c) {
        case RIGHT:
          turn(true);
          break;
        case LEFT:
          turn(false);
          break;
        default:
          max = Math.max(max, move(c));
          break;
      }
    }

    return max;
  }

  private int move(int moves) {
    if (moves < 1 || moves > 9) return 0;

    int max = 0;
    int x1 = x;
    int y1 = y;

    for(int i = 0; i < moves; i++) {
      switch(this.direction) {
        case NORTH:
          y1++;
          break;
        case EAST:
          x1++;
          break;
        case SOUTH:
          y1--;
          break;
        case WEST:
          x1--;
          break;
      }
      if (!isObstacle(x1, y1)) {
        this.x = x1;
        this.y = y1;
        max = Math.max(max, x * x + y * y);
      } else {
        x1 = x;
        y1 = y;
      }
    }
    return max;
  }

  private boolean isObstacle(int x1, int y1) {
    return this.coordsBlocked.contains(x1 + "_" + y1);
  }

  private void turn(boolean right) {
    switch(this.direction) {
      case NORTH:
        this.direction = right ? EAST : WEST;
        break;
      case EAST:
        this.direction = right ? SOUTH : NORTH;
        break;
      case SOUTH:
        this.direction = right ? WEST : EAST;
        break;
      case WEST:
        this.direction = right ? NORTH : SOUTH;
        break;
    }
  }


}
