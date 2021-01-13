package stunning.palm.tree.a;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * build a double linked list and use a map to track each nodes position
 * we a duplicate is added we know map exists so we remove the node from the double linked list
 * also using a set to keep track the unique values in the double linked list
 * Time O(1)
 * space O(n)
 */
class FirstUniqueNumber {
    public DLink dl;
    public Map<Integer, Node> map; //for keep track pos of nodes in the dl;
    public Set<Integer> set;// for keep track remove nodes;
    public FirstUniqueNumber(int[] nums) {
        this.dl = new DLink();
        this.set = new HashSet<>();
        this.map = new HashMap<>();
        
        for(int num : nums){
            if(map.containsKey(num)){
                if(set.add(num)){
                    dl.remove(map.get(num));   
                }
            }else{
                Node node = new Node(num);
                dl.add(node);
                map.put(num,node);
            }
        }
    }
    
    public int showFirstUnique() {
        return dl.getFirst();
    }
    
    public void add(int value) {
        if(map.containsKey(value)){
            if(set.add(value)){
                dl.remove(map.get(value));
            }
        }else{
            Node node = new Node(value);
            dl.add(node);
            map.put(value,node);
        }
    }
    
    private class Node{
        public int val;
        public Node prev;
        public Node next;
        public Node(int val){
            this.val = val;
        }
    }
    
    private class DLink{
        public Node head = new Node(-1);
        public Node tail = new Node(-1);
        
        public DLink(){
            head.next = tail;
            tail.prev = head;
        }
        
        public void add(Node node){
            tail.prev.next = node;
            node.prev = tail.prev;
            node.next = tail;
            tail.prev = node;
        }
        
        public void remove(Node node){
            node.next.prev = node.prev;
            node.prev.next = node.next;
        }
        
        public int getFirst(){
            return this.head.next.val;
        }
        
    }
}
