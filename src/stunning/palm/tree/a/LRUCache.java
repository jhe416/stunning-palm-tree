package stunning.palm.tree.a;

import java.util.HashMap;
import java.util.Map;

/*
 * double linkedlist with a hashmap reaching O(1) on get and put
 */
class LRUCache {
    Node head = new Node(0,0);
    Node tail = new Node(0,0);
    int max = 0;
    Map<Integer,Node> map = new HashMap<>();
    public LRUCache(int capacity) {
        this.max = capacity;
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        Node currentNode = map.get(key);
        if(currentNode == null) return -1;
        
        currentNode.next.prev = currentNode.prev;
        currentNode.prev.next = currentNode.next;
        
        head.next.prev = currentNode;
        currentNode.next = head.next;
        currentNode.prev = head;
        head.next = currentNode;
        return currentNode.val;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node currentNode = map.get(key);
            currentNode.val = value;
            currentNode.next.prev = currentNode.prev;
            currentNode.prev.next = currentNode.next;
        
            head.next.prev = currentNode;
            currentNode.next = head.next;
            currentNode.prev = head;
            head.next = currentNode;
        }else{
            if(map.size() == max){
                Node remove = tail.prev;
                remove.prev.next = remove.next;
                remove.next.prev = remove.prev;
                map.remove(remove.key);
            }
            Node newNode = new Node(key,value);
            head.next.prev =  newNode;
            newNode.next = head.next;
            newNode.prev = head;
            head.next = newNode;
            map.put(key,newNode);
        }
    }
    
    class Node{
        int key; int val; Node next; Node prev;
        public Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }
}

