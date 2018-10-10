// #53. Maximum Subarray

// when the sum is negative => get rid of it as (n) + (negative) < (n)
// => let sum be next number 
// when the sum is still positive => keep adding next number
// make a judgement when current sum is larger than max, if so take current sum
// O(n) time, O(1) space
class Solution {
    public int maxSubArray(int[] nums) {
		int sum = Integer.MIN_VALUE, max = Integer.MIN_VALUE;
		for (int i = 0; i < nums.length; i++) {
			if (sum < 0 ) {
				sum = nums[i];
			} else {
				sum += nums[i];
			}

			if (sum > max) {
				max = sum;
			}
		}    
		return max;    
    }
}

// Dynamic programming solution
// O(n) time, O(n) space 
// maxSubArray(A, i) = A[i] + maxSubArray(A, i - 1) > 0 ? maxSubArray(A, i - 1) : 0 ; 
class Solution {
	public int maxSubArray(int[] nums) {
		int length = nums.length;
		int [] dpArray = new int[length];
		dpArray[0] = nums[0];
		int max = dpArray[0];

		for (int i = 1; i < length; i++) {
			dpArray[i] = (dpArray[i-1] > 0 ? dpArray[i-1]:0) + nums[i];
			if (dpArray[i] > max) {
				max = dpArray[i]; 
			}
		}
		return max;
	}
}

