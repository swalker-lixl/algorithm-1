package algorithm.LeetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * describe:
 * 212. 单词搜索 II : https://leetcode-cn.com/problems/word-search-ii/
 *
 *
 * 给定一个二维网格 board 和一个字典中的单词列表 words，找出所有同时在二维网格和字典中出现的单词。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
 * 同一个单元格内的字母在一个单词中不允许被重复使用。
 *
 * @author lixilong
 * @date 2019/01/19
 */
public class _212_FindWords {
  //方法1：DFS 遍历
  //方法2：预处理再DFS：
  // 候选词入Tire，得字典树  board中的每个元素作为起点搜索字典树


  /*public List<String> findWords(char[][] board, String[] words) {

  }*/


  //Runtime: 18 ms, faster than 72.73%
  public List<String> findWords(char[][] board, String[] words) {
    List<String> res = new ArrayList();
    TrieNode root = buildTrie(words);
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        dfs (board, i, j, root, res);
      }
    }
    return res;
  }

  public void dfs(char[][] board, int i, int j, TrieNode p, List<String> res) {
    char c = board[i][j];
    if (c == '#' || p.next[c - 'a'] == null) return;
    p = p.next[c - 'a'];
    if (p.word != null) {   // found one
      res.add(p.word);
      p.word = null;     // de-duplicate
    }

    board[i][j] = '#';
    if (i > 0) dfs(board, i - 1, j ,p, res);
    if (j > 0) dfs(board, i, j - 1, p, res);
    if (i < board.length - 1) dfs(board, i + 1, j, p, res);
    if (j < board[0].length - 1) dfs(board, i, j + 1, p, res);
    board[i][j] = c;
  }

  public TrieNode buildTrie(String[] words) {
    TrieNode root = new TrieNode();
    for (String w : words) {
      TrieNode p = root;
      for (char c : w.toCharArray()) {
        int i = c - 'a';
        if (p.next[i] == null) p.next[i] = new TrieNode();
        p = p.next[i];
      }
      p.word = w;
    }
    return root;
  }

  class TrieNode {
    TrieNode[] next = new TrieNode[26];
    String word;
  }


  // Runtime: 13 ms, faster than 95.80%
  List<String> res;
  public List<String> findWords(char[][] board, String[] words) {
    res = new ArrayList<>();
    Node root = buildTrie(words);
    int m= board.length, n=board[0].length;
    for(int i=0; i<m; i++) {
      for(int j=0; j<n; j++) {
        dfs(i, j, board, root, m, n);
      }
    }
    return res;
  }

  public void dfs(int i, int j, char[][] board, Node node, int m, int n) {
    char c = board[i][j];
    if(board[i][j] == '#') return; // this position has visited
    node = node.next[c- 'a'];
    if(node == null) return; // no such node in trie after this root
    if(node.word != null) {
      res.add(node.word);  // found one
      node.word= null;     // de-duplicate
      // return;  // No return, this is the key
    }
    board[i][j] = '#'; // mark this position is visited and continue searching
    if(i+1 < m && board[i+1][j] != '#') dfs(i+1, j, board, node, m, n);
    if(j+1 < n && board[i][j+1] != '#') dfs(i, j+1, board, node, m, n);
    if(i-1 >=0 && board[i-1][j] != '#') dfs(i-1, j, board, node, m, n);
    if(j-1 >=0 && board[i][j-1] != '#') dfs(i, j-1, board, node, m, n);
    board[i][j] = c; // restore its orginal state
  }

  public Node buildTrie(String[] words) {
    Node root = new Node();
    for(String word : words) {
      Node cur = root;
      for(char c: word.toCharArray()) {
        if(cur.next[c-'a'] == null) {
          cur.next[c-'a'] = new Node();
        }
        cur = cur.next[c-'a'];
      }
      cur.word = word;
    }
    return root;
  }

  class Node {
    String word;
    Node[] next= new Node[26];
  }
}
