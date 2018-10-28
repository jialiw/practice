//Q414. Third Maximum Number 
// 7ms
class Solution {
    public int thirdMax(int[] nums) {
    	Integer [] max = new Integer[3];
    	for (int n: nums) {
    		if (max[0]==null) {
    			max[0] = n;
    		} else if (n > max[0]) {
    			max[2] = max[1];
    			max[1] = max[0];
    			max[0] = n;
    		} else if (n != max[0] && max[1] == null) {
    			max[1] = n;
    		} else if ( n != max[0] && n > max[1] ) {
    			max[2] = max[1];
    			max[1] = n;
    		} else if ( n != max[0] && n != max[1] && max[2] == null) {
                max[2] = n;
            }
            else if ( n != max[0] && n != max[1] && n > max[2] ) {
    			max[2] = n;
    		}
    	}

    	int n = (max[2] == null) ? max[0] : max[2];
    	return n;
    }
}

// neater solution using Integer 
public int thirdMax(int[] nums) {
        Integer max1 = null;
        Integer max2 = null;
        Integer max3 = null;
        for (Integer n : nums) {
            if (n.equals(max1) || n.equals(max2) || n.equals(max3)) continue;
            if (max1 == null || n > max1) {
                max3 = max2;
                max2 = max1;
                max1 = n;
            } else if (max2 == null || n > max2) {
                max3 = max2;
                max2 = n;
            } else if (max3 == null || n > max3) {
                max3 = n;
            }
        }
        return max3 == null ? max1 : max3;
    }

// 2ms 
class Solution {
	public int thirdMax(int[] nums) {
		int fMax = Integer.MIN_VALUE, sMax = Integer.MIN_VALUE, tMax = Integer.MIN_VALUE;
		boolean hit3 = false;

		for (int n: nums) {
			if (n > fMax) fMax = n;
		}

		if (nums.length <= 2) return fMax;

		for (int n: nums) {
			if (n > sMax && n < fMax) sMax = n;
		}

		for (int n: nums) {			
			if (n >= tMax && n < sMax) { // for corner case, tMax = MIN_VALUE
				tMax = n;
                hit3 = true;
			}
		}

		if (hit3 || tMax> Integer.MIN_VALUE) return tMax;
		else return fMax;
	}
}

// 3ms 
// use long to get rid of Integer range limit 
class Solution {
    public int thirdMax(int[] nums) {
        if (nums == null || nums.length < 1){
            return -1;
        }
        long max = (long) 2 * Integer.MIN_VALUE;
        long secondmax = (long) 2 * Integer.MIN_VALUE;
        long result = (long) 2 * Integer.MIN_VALUE;
        for (int n : nums){
            max = Math.max(n, max);
        }
        for (int n : nums){
            if (n != max){
                secondmax = Math.max(n, secondmax);
            }
        }
        for (int n : nums){
            if (n != max && n != secondmax){
                result = Math.max(n, result);
            }
        }
        return result == (long) 2 * Integer.MIN_VALUE ? (int) max : (int) result;
    }
}