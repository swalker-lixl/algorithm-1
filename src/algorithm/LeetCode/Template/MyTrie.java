package algorithm.LeetCode.Template;

/**
 * describe:
 *
 * @author lixilong
 * @date 2019/01/19
 */
public class MyTrie {

  public static void main(String[] args) {

    MyTrie myTrie = new MyTrie();
    System.out.println(myTrie.retrunTest(1));;
    System.out.println(myTrie.retrunTest(5));;
    System.out.println(myTrie.retrunTest(10));;
    System.out.println(myTrie.retrunTest(15));;
    System.out.println(myTrie.retrunTest(0));;
    System.out.println(myTrie.retrunTest(-5));;
    //Trie
  }

  public int retrunTest(int  n) {
    //嵌套条件，可以先单独写两层各自条件的语句，然后替换具体位置处
    //当两处的return 语句完全一致的是时候，可以将if写成三目表达式
    return n > 0 ? (n < 10 ? n : 10) : -1;
  }



/*
  *//** Initialize your data structure here. *//*
  public MyTrie() {

  }

  *//** Inserts a word into the trie. *//*
  public void insert(String word) {

  }

  *//** Returns if the word is in the trie. *//*
  public boolean search(String word) {

  }

  *//** Returns if there is any word in the trie that starts with the given prefix. *//*
  public boolean startsWith(String prefix) {

  }*/
}
