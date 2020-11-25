package stunning.palm.tree.contest;

import java.util.HashMap;
import java.util.Map;

/*
 * I tried to build a db linked list and brute force this solution but didn't work..
 * ugh.
 */
public class WaysToMakeAFairArrayBruteForce {
	public WaysToMakeAFairArrayBruteForce() {}
	
    public int waysToMakeFair(int[] nums) {
        if(nums == null) return 0;
        if(nums.length == 1) return 1;
        if(nums.length < 3) return 0;
        Map<Integer, Node> map = new HashMap<>();
        DBLinkedList list = new DBLinkedList();
        
        for(int i=0;i<nums.length;i++){
            Node node = new Node(i,nums[i]);
            list.add(node);
            map.put(i,node);
        }
        
        int res = 0;
        for(int i=0;i<nums.length;i++){
            list.remove(map.get(i));
            Node pointer1 = list.head.next;
            Node pointer2 = list.head.next.next;
            int sum1 = 0;
            int sum2 = 0;
            while(pointer1 != null && pointer1.next != null && pointer2 != null && pointer2.next != null){
                sum1 += pointer1.val;
                sum2 += pointer2.val;
                pointer1 = pointer1.next.next;
                pointer2 = pointer2.next.next;
            }
            
            while(pointer1 != null && pointer1.next != null){
                sum1 += pointer1.val;
                pointer1 = pointer1.next.next;
            }
            
            while(pointer2 != null && pointer2.next != null){
                sum2 += pointer2.val;
                pointer2 = pointer2.next.next;
            }
            
            res += sum1 == sum2? 1 : 0;
            list.addOri(map.get(i));
        }
        
        return res;
    }
    
    class DBLinkedList{
        Node head = new Node(0,0);
        Node tail = new Node(0,0);
        
        public DBLinkedList(){
            head.next = tail;
            tail.prev = head;
        }
        
        public void add(Node node){
            head.next.prev = node;
            node.next = head.next;
            node.prev = head;
            head.next = node;
        }
        
        public void remove(Node node){
            node.next.prev = node.prev;
            node.prev.next = node.next;
        }
        
        public void addOri(Node node){
            node.prev.next = node;
            node.next.prev = node;
        }
    }
    
    class Node{
        int val;
        int key;
        Node next;
        Node prev;
        
        public Node(int key,int val){
            this.key = key;
            this.val = val;
        }
    }
}
