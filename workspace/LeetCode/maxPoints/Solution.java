package maxPoints;
/**
 * Max Points on a Line Total Accepted: 444 Total Submissions: 5567 My Submissions
Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
http://oj.leetcode.com/problems/max-points-on-a-line/
 */
import java.util.HashMap;
 class Point {
	int x;
      int y;
      Point() { x = 0; y = 0; }
      Point(int a, int b) { x = a; y = b; }
  }
 class Fraction{
	    long numerator;
	    long denominator;
	    public Fraction(long numerator, long denominator){
	        this.numerator = numerator;
	        this.denominator = denominator;
	    }
	    
	    @Override
	    public int hashCode(){
	        if(denominator == 0) return 0;
	        if(numerator == 0) return -0;
	        return new Double((double)numerator / denominator).hashCode();
	    }
	    @Override
	    public boolean equals(Object o){
	        if(o == null) return this == null;
	        if(o == this) return true;
	        if(o instanceof Fraction){
	        	Fraction f = (Fraction)o;
	            if(this.denominator * f.denominator == 0){
	                return this.denominator == 0 && f.denominator == 0;
	            }
	            return this.denominator * f.numerator == this.numerator * f.denominator;
	        }
	        return false;
	    }
	}
public class Solution {
    public int maxPoints(Point[] points) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
    	if(points.length <= 2) return points.length;
    	HashMap<Fraction, Integer> m = new HashMap<Fraction, Integer>();
    	int i, j, k, add;
    	int re = 0;
    	for(i = 0; i < points.length; ++i){
    		add = 1;
    		m.clear();
    		int tmp = 0;
    		for(j = i + 1; j < points.length; ++j){
    			if(points[j].x == points[i].x){
    				if(points[j].y == points[i].y){
    					add++;
    				} else {
    					Integer t = m.get(null);
    					if(t == null){
    						t = 0;
    					}
    					m.put(null, t + 1);
    				}
    			} else {
    				Fraction f = new Fraction(points[i].y - points[j].y, points[i].x - points[j].x);
    				Integer t = m.get(f);
    				if(t == null){
    					t = 0;
    				}
    				m.put(f, t + 1);
    			}
    		}
    		for(Integer t : m.values()){
    			tmp = Math.max(tmp, t);
    		}
    		tmp += add;
    		re = Math.max(re, tmp);
    	}
    	return re;
    }
    
    public static void main(String[] args){
    	Point[] a = new Point[3];
    	a[0] = new Point(2, 3);
    	a[1] = new Point(3, 3);
    	a[2] = new Point(-5, 3);
    	Solution sol = new Solution();
    	sol.maxPoints(a);
    }
}
