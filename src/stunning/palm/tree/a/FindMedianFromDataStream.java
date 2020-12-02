package stunning.palm.tree.a;

import java.util.PriorityQueue;

/*
 * double heap to order the incoming num
 * the follow up question1:
 * If all integer numbers from the stream are between 0 and 100, how would you optimize it?
 * see how I did it in StatisticsFromALargeSample.java
 * If 99% of all integer numbers from the stream are between 0 and 100, how would you optimize it?
 * same idea as in the first question but adding two arraylist, one to store the numbers less than 0 
 * and another one to store the numbers greater than 100
 * 
 * Time complexity for this solution O(nlog(n))
 * space O(n)
 */
public class FindMedianFromDataStream {
	PriorityQueue<Double> left = new PriorityQueue<>((a,b) -> a>b? -1 : 1);
    PriorityQueue<Double> right = new PriorityQueue<>((a,b) -> a>b? 1 : -1);
    /** initialize your data structure here. */
    public FindMedianFromDataStream() {}
    
    public void addNum(int num) {
        if(left.isEmpty()){
            left.offer((double)num);
            return;
        }
        
        if(num<left.peek()){
            left.offer((double)num);
        }else{
            right.offer((double)num);
        }
        
        if(left.size() -1 > right.size()){
            right.offer(left.poll());
        }else if(right.size() - 1 > left.size()){
            left.offer(right.poll());
        }
    }
    
    public double findMedian() {
        if((left.size() + right.size()) %2 == 1){
            return left.size() > right.size()? left.peek() : right.peek();
        }else{
            return (left.peek() + right.peek())/2.0;
        }
    }
}
