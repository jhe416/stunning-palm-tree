package stunning.palm.tree.f;

/*
 * binary search
 */
public class FirstBadVersion {
	public FirstBadVersion() {}
	
    public int firstBadVersion(int n) {
        return helper(1,n);
    }
    
    private int helper(int l, int r){
        if(l==r) return l;
        int mid = l + (r-l)/2;
        
        boolean bad = isBadVersion(mid);
        
        if(bad){
            return helper(l,mid);
        }else{
            return helper(mid+1,r);
        }
    }
    
    public boolean isBadVersion(int mid) {return true;}
}
