// #35. Search Insert Position

// naive method 
// time complexity O(n)
class Solution {
    public int searchInsert(int[] nums, int target) {
        int pos = 0;
        for ( int n : nums) {
        	if (n >= target) {
        		return pos;
        	}
        	pos ++;
        }
        return pos;
    }
}

// better solution, time complexity O(log(n))
class Solution {
	public int searchInsert(int[] nums, int target) {
		int low = 0, high = nums.length -1;
		while (low <= high) {
			int mid = low + (high-low)/2;
			if (nums[mid] == target) return mid;
			if (nums[mid] < target ) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return low;
	}
}

