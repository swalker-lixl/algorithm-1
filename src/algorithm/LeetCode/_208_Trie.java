package algorithm.LeetCode;

import java.util.HashMap;

/**
 * describe:
 *
 * @author lixilong
 * @date 2019/01/26
 */
public class _208_Trie {


//实现1：Runtime: 117 ms, faster than 28.57%
  private class TrieNode{
    char chr;
    boolean end;
    HashMap<Character, TrieNode> children;
    TrieNode(){
      children = new HashMap<Character, TrieNode>();
    };
    TrieNode(char chr){
      children = new HashMap<Character, TrieNode>();
      this.chr = chr;
    }
  }

  TrieNode root;

  /** Initialize your data structure here. */
  public _208_Trie() {
    root = new TrieNode();
  }

  /** Inserts a word into the trie. */
  public void insert(String word) {
    TrieNode cur = root;
    for(char c: word.toCharArray()){
      if(!cur.children.containsKey(c)){
        TrieNode t = new TrieNode(c);
        cur.children.put(c, t);
      }
      cur = cur.children.get(c);
    }
    cur.end = true;
  }

  /** Returns if the word is in the trie. */
  public boolean search(String word) {
    TrieNode cur = root;
    for(char c: word.toCharArray()){
      if(!cur.children.containsKey(c)){
        return false;
      }
      cur = cur.children.get(c);
    }
    return cur.end;
  }

  /** Returns if there is any word in the trie that starts with the given prefix. */
  public boolean startsWith(String prefix) {
    TrieNode cur = root;
    for(char c: prefix.toCharArray()){
      if(!cur.children.containsKey(c)){
        return false;
      }
      cur = cur.children.get(c);
    }
    return true;
  }


  //实现2：Runtime: 103 ms, faster than 54.76%  不稳定
  private class TrieNode{
    char chr;
    boolean end;
    HashMap<Character, TrieNode> children;
    TrieNode(){
      children = new HashMap<Character, TrieNode>();
    };
    TrieNode(char chr){
      children = new HashMap<Character, TrieNode>();
      this.chr = chr;
    }
  }

  TrieNode root;

  /** Initialize your data structure here. */
  public TrieNode() {
    root = new TrieNode();
  }

  /** Inserts a word into the trie. */
  public void insert(String word) {
    TrieNode cur = root;
    for(char c: word.toCharArray()){
      if(!cur.children.containsKey(c)){
        TrieNode t = new TrieNode(c);
        cur.children.put(c, t);
      }
      cur = cur.children.get(c);
    }
    cur.end = true;
  }

  /** Returns if the word is in the trie. */
  public boolean search(String word) {
    TrieNode cur = root;
    for(char c: word.toCharArray()){
      if(!cur.children.containsKey(c)){
        return false;
      }
      cur = cur.children.get(c);
    }
    return cur.end;
  }

  /** Returns if there is any word in the trie that starts with the given prefix. */
  public boolean startsWith(String prefix) {
    TrieNode cur = root;
    for(char c: prefix.toCharArray()){
      if(!cur.children.containsKey(c)){
        return false;
      }
      cur = cur.children.get(c);
    }
    return true;
  }

}
