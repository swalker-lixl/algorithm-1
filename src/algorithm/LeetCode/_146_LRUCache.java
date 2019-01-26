package algorithm.LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * describe:
 *
 * @author lixilong
 * @date 2019/01/26
 */
public class _146_LRUCache {


//  Runtime: 78 ms, faster than 76.70%
  int size;
  int limit;
  HashMap<Integer, Node> map;
  Node head;
  Node tail;

  public LRUCache(int capacity) {
    limit = capacity;
    map = new HashMap<>();
    head = new Node(0, 0);
    tail = new Node(0, 0);
    head.next = tail;
    tail.prev = head;
  }

  public int get(int key) {
    if(map.containsKey(key)){
      Node n = map.get(key);
      remove(n);
      addFirst(head, n);
      return n.val;
    }
    return -1;
  }

  public void put(int key, int value) {
    if(map.containsKey(key)){
      Node n = map.get(key);
      n.val = value;
      remove(n);
      addFirst(head, n);
      return;
    }
    Node node = new Node(key, value);
    if(limit == 0) return;
    addFirst(head, node);
    if(size < limit)
      ++size;
    else
      removeLast(tail, map);
    map.put(key, node);
  }

  public void addFirst(Node head, Node node){
    node.next = head.next;
    head.next.prev = node;
    node.prev = head;
    head.next = node;
  }

  public void removeLast(Node tail, HashMap<Integer, Node> map){
    Node prev = tail.prev;
    Node prepre = prev.prev;
    prev.next = null;
    prev.prev = null;
    prepre.next = tail;
    tail.prev = prepre;
    map.remove(prev.key);
  }

  public void remove(Node node){
    Node prev = node.prev;
    Node next = node.next;
    node.prev = null;
    node.next = null;
    prev.next = next;
    next.prev = prev;
  }

  class Node{
    int key;
    int val;
    Node next;
    Node prev;
    public Node(int k, int v) { key = k; val = v; next = null; prev = null; }
  }


  //  Runtime: 82 ms, faster than 58.70%
  class ListNode {
    int key;
    int val;
    ListNode next;
    ListNode pre;

    ListNode(int key, int val) {
      this.key = key;
      this.val = val;
    }
  }

  Map<Integer, ListNode> map;
  int capacity;
  ListNode head;
  ListNode tail;

  public LRUCache(int capacity) {
    map = new HashMap();
    this.capacity = capacity;
  }

  public int get(int key) {
    ListNode node = map.get(key);
    if (node == null) {
      return -1;
    } else {
      if (node == tail) return node.val;

      if (node == head) {
        head = head.next;
      } else {
        node.pre.next = node.next;
        node.next.pre = node.pre;
      }
      tail.next = node;
      node.pre = tail;
      node.next = null;
      tail = node;
      return node.val;
    }
  }

  public void put(int key, int value) {
    ListNode node = map.get(key);
    if (node == null) {
      if (capacity == 0) {
        ListNode temp = head;
        head = head.next;
        map.remove(temp.key);
        capacity++;
      }
      ListNode newNode = new ListNode(key, value);
      if (head == null || tail == null) {
        head = newNode;
      } else {
        tail.next = newNode;
        newNode.pre = tail;
        newNode.next = null;
      }

      tail = newNode;
      map.put(key, newNode);
      capacity--;
    } else {
      node.val = value;
      if (node != tail) {
        if (node == head) {
          head = head.next;

        } else {
          node.next.pre = node.pre;
          node.pre.next = node.next;
        }
        tail.next = node;
        node.pre = tail;
        node.next = null;
        tail = node;
      }
    }
  }

}
