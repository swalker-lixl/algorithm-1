package algorithm.LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

/**
 * describe:
 *
 * 班上有 N 名学生。其中有些人是朋友，有些则不是。他们的友谊具有是传递性。
 * 如果已知 A 是 B 的朋友，B 是 C 的朋友，那么我们可以认为 A 也是 C 的朋友。
 * 所谓的朋友圈，是指所有朋友的集合。
 *
 * 给定一个 N * N 的矩阵 M，表示班级中学生之间的朋友关系。
 * 如果M[i][j] = 1，表示已知第 i 个和 j 个学生互为朋友关系，否则为不知道。
 * 你必须输出所有学生中的已知的朋友圈总数。
 *
 * @author lixilong
 * @date 2019/01/27
 */
public class _547_FindCircleNum {

//解法1：不稳定
  // Runtime: 10 ms, faster than 30.23%
  //Runtime: 5 ms, faster than 98.45%
  public int findCircleNum(int[][] M) {
    if (M == null || M.length ==0){
      return 0;
    }
    int[] visited = new int[M.length];
    int count = 0;
    for (int i =0; i< M.length; i++){
      if (visited[i] ==0){
        dfs(i, M, visited);
        count ++;
      }
    }
    return count;
  }

  public void dfs(int i, int[][] M, int[] visited){
    visited[i] =1;
    for (int j = 0; j< M.length; j++){
      if (M[i][j]==1 && visited[j]==0){
        dfs(j, M, visited);
      }
    }
  }




// 解3：Runtime: 6 ms
  class UnionFind {
    private int count = 0;
    private int[] parent, rank;

    public UnionFind(int n) {
      count = n;
      parent = new int[n];
      rank = new int[n];
      for (int i = 0; i < n; i++) {
        parent[i] = i;
      }
    }

    public int find(int p) {
      while (p != parent[p]) {
        parent[p] = parent[parent[p]];    // path compression by halving
        p = parent[p];
      }
      return p;
    }

    public void union(int p, int q) {
      int rootP = find(p);
      int rootQ = find(q);
      if (rootP == rootQ) return;
      if (rank[rootQ] > rank[rootP]) {
        parent[rootP] = rootQ;
      }
      else {
        parent[rootQ] = rootP;
        if (rank[rootP] == rank[rootQ]) {
          rank[rootP]++;
        }
      }
      count--;
    }

    public int count() {
      return count;
    }
  }

  public int findCircleNum(int[][] M) {
    int n = M.length;
    UnionFind uf = new UnionFind(n);
    for (int i = 0; i < n - 1; i++) {
      for (int j = i + 1; j < n; j++) {
        if (M[i][j] == 1) uf.union(i, j);
      }
    }
    return uf.count();
  }


  //解法2：Runtime: 58 ms, faster than 3.88%
  public int findCircleNum(int[][] M) {
    if (M == null || M.length ==0){
      return 0;
    }
    int size = M.length;
    Map<Integer, List<Integer>> graph = new HashMap();
    for (int i =0; i<size; i++){
      for (int j = i+1; j<size; j++){
        if (M[i][j]==1){
          if (graph.containsKey(i)){
            graph.get(i).add(j);
          }
          else {
            List<Integer> tmp = new ArrayList<>();
            tmp.add(j);
            graph.put(i, tmp);
          }
          if (graph.containsKey(j)){
            graph.get(j).add(i);
          }
          else {
            List<Integer> tmp = new ArrayList();
            tmp.add(i);
            graph.put(j, tmp);
          }
        }
      }
    }
    Set<Integer> visited = new HashSet();
    int connected_components = 0;
    for (int i =0; i< size; i++){
      if (!visited.contains(i)){
        dfs(i, graph, visited);
        connected_components++;
      }
    }
    return connected_components;
  }

  public void dfs(int start, Map<Integer, List<Integer>> graph, Set<Integer> visited){
    Stack<Integer> stack = new Stack<Integer>();
    stack.push(start);
    while (!stack.isEmpty()){
      int cur = stack.pop();
      visited.add(cur);
      if (graph.containsKey(cur)){
        for (int next: graph.get(cur)){
          if (!visited.contains(next)){
            stack.push(next);
          }
        }
      }
    }
  }




}
