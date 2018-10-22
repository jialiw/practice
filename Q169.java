//Q169. Majority Element

// HashMap solution 
// O(n) O(n)
class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<Integer, Integer>();
        int max = 0, maxIndex = 0;
        for (int n: nums) {
        	if (countMap.containsKey(n)) {
        		countMap.put(n, countMap.get(n)+1);
        	} else {
        		countMap.put(n, 1);
        	}
        	/** Option1
			if (countMap.get(n) > nums.length/2) {
				maxIndex = n;
				break;
			}
				
        	**/
			}

        }

        // Option2
        for (Map.Entry<Integer, Integer> entry: countMap.entrySet()) {
        	if (entry.getValue() > max) {
        		max = entry.getValue();
        		maxIndex = entry.getKey();
        	} 
        }
        return maxIndex;
    }
}

// Boyer-Moore Voting Algorithm 
// O(n) O(1)
// NOTE : This Method only works when we are given that majority element do exist in the array , otherwise this method won’t work , 
// as in the problem definition we said that majority element may or may not exist but for applying this approach 
//you can assume that majority element do exist in the given input array

// The first step gives the element that may be majority element in the array. 
// If there is a majority element in an array, then this step will definitely return majority element, otherwise it will return candidate for majority element.
// Check if the element obtained from above step is majority element.
// This step is necessary as we are not always sure that element return by first step is majority element.
/**
	1.  Initialize index and count of majority element
     maj_index = 0, count = 1
	2.  Loop for i = 1 to size – 1
	    (a) If a[maj_index] == a[i]
	          count++
	    (b) Else
	        count--;
	    (c) If count == 0
	          maj_index = i;
	          count = 1
	3.  Return a[maj_index]
**/
class Solution {
	public int majorityElement(int[] nums) {
		int count = 1, e = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if (nums[i]==e) {
				count ++;
			} else {
				count --;
			}
			if(count ==0) {
				e = nums[i];
				count = 1;
			}
		}
		return e;
	}
}

// Divide and Conquer
// O(nlogn) (T(n)=2T(n/2)+2n)

class Solution {
    private int countInRange(int[] nums, int num, int lo, int hi) {
        int count = 0;
        for (int i = lo; i <= hi; i++) {
            if (nums[i] == num) {
                count++;
            }
        }
        return count;
    }

    private int majorityElementRec(int[] nums, int lo, int hi) {
        // base case; the only element in an array of size 1 is the majority
        // element.
        if (lo == hi) {
            return nums[lo];
        }

        // recurse on left and right halves of this slice.
        int mid = (hi-lo)/2 + lo;
        int left = majorityElementRec(nums, lo, mid);
        int right = majorityElementRec(nums, mid+1, hi);

        // if the two halves agree on the majority element, return it.
        if (left == right) {
            return left;
        }

        // otherwise, count each element and return the "winner".
        int leftCount = countInRange(nums, left, lo, hi);
        int rightCount = countInRange(nums, right, lo, hi);

        return leftCount > rightCount ? left : right;
    }

    public int majorityElement(int[] nums) {
        return majorityElementRec(nums, 0, nums.length-1);
    }
}


// Sorting
class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}
