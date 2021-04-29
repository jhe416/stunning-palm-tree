package stunning.palm.tree.f;

/*
 * x^(2n) -> (x^n) * (x^n)
 * x^n - > n is even? x^n/2 * x^n/2 : x^n/2 * x^n/2 * x
 * Time O(log(N))
 * space constant
 */
public class PowXN {
	public PowXN() {}
	
    public double myPow(double x, int n) {
        if(x == 0) return 0;
        if(n == 0) return 1;
        boolean negative = n < 0;
        long p = n;
        p = negative? -p : p;
        double res = helper(x,p);
        
        return negative? 1/res : res;
    }
    
    private double helper(double x, long p){
        if(p == 1) return x;
        double res = helper(x,p/2);
        return p%2==0? res*res : x*res*res;
    }
}
