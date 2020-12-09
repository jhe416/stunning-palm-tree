package stunning.palm.tree.a;

import java.util.HashMap;
import java.util.Map;

/*
 * concept is similar to LRU cache
 * we use a map keep a double linked list for lru with the frequency
 * each node has a key a val and a frequency
 * we get a node we increment the node's frequency and put the node to the incremented frenquency's dlink
 * and remove the node from the current dlink. if the current dlink is now empty and is the lowest frequency we increment the lowf
 * when add, if already exits we update the value and do above^
 * when add if the size reached max we remove from the low_f's tail node;
 * when add we set low_f to 1 as we a new node that is accessed only once
 * we add node in n_map as well as f_map for 1
 * Time O(1)
 * Space O(n)
 */
class LFUCache {
    Map<Integer, DLinkedList> f_map =  new HashMap<>();
    Map<Integer,Node> n_map = new HashMap<>();
    int max;
    int size;
    int low_f;
    public LFUCache(int capacity) {
        this.max = capacity;
        this.size = 0;
        this.low_f = 0;
    }
    
    public int get(int key) {
        Node node = n_map.get(key);
        if(node == null) return -1;
        
        DLinkedList dlink = f_map.get(node.f);
        dlink.remove(node);
        if(dlink.size == 0 && low_f == node.f){
            low_f++;
        }
        dlink = f_map.getOrDefault(++node.f, new DLinkedList());
        dlink.add(node);
        f_map.putIfAbsent(node.f,dlink);
        
        return node.val;
    }
    
    public void put(int key, int value) {
        if(max == 0) return;
        if(n_map.containsKey(key)){
            Node node = n_map.get(key);
            node.val = value;
            get(key);
        }else{
            Node newNode = new Node(key,value,1);
            if(size == max){
                DLinkedList dlink = f_map.get(low_f);
                n_map.remove(dlink.removeLast().key);
                size--;
            }
            low_f = 1;
            n_map.put(key,newNode);
            DLinkedList dlink = f_map.getOrDefault(1, new DLinkedList());
            dlink.add(newNode);
            f_map.putIfAbsent(1,dlink);
            size++;
        }
    }
}

class DLinkedList{
    Node head = new Node(0,0,0);
    Node tail = new Node(0,0,0);
    int size = 0;
    public DLinkedList(){
        this.head.next = tail;
        this.tail.prev = head;
    }
    
    public void add(Node node){
        node.next = head.next;
        head.next.prev = node;
        node.prev = head;
        head.next = node;
        size++;
    }
    
    public Node remove(Node node){
        node.next.prev = node.prev;
        node.prev.next = node.next;
        size--;
        return node;
    }
    
    public Node removeLast(){
        if(size == 0) return null;
        return remove(tail.prev);
    }
    
    class Node{
        int key;
        int val;
        int f;
        Node prev;
        Node next;
        
        public Node(int key, int val, int f){
            this.key = key;
            this.val = val;
            this.f = f;
        }
    }
}

