//Q189. Rotate Array

// brute force
// O(n^2) O(1)
class Solution {
	public void rotate(int[] nums, int k) {
		for (int i = 0; i < k; i++) {
			int temp = nums[nums.length-1];
			for (int j = nums.length-1; j > 0; j-- ) {
				nums[j] = nums[j-1];
			}
			nums[0] = temp;
		}
	}
}

// extra array
// O(n) O(n)
//  the number at index i in the original array is placed at the index (i+k)
class Solution {
	public void rotate(int[] nums, int k) {
		int[] temp = new int[nums.length];
        k = k % nums.length; // get rid of outbound
		for (int i = 0; i <k; i++) {
			temp[i] = nums[nums.length-k+i];
		}
		for (int i = k; i < nums.length; i++) {
			temp[i] = nums[i - k];
		}
		for (int i = 0; i < nums.length; i++) {
			nums[i] = temp[i];
		}
	}
}

class Solution {
    public void rotate(int[] nums, int k) {
        int[] a = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            a[(i + k) % nums.length] = nums[i]; // % nums.length to get rid outofboundaryexception
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = a[i];
        }
    }
}


// reverse
// O(n) O(1)
/**
Let n=7n=7 and k=3k=3.

Original List                   : 1 2 3 4 5 6 7
After reversing all numbers     : 7 6 5 4 3 2 1
After reversing first k numbers : 5 6 7 4 3 2 1
After revering last n-k numbers : 5 6 7 1 2 3 4 --> Result
**/
class Solution {
	public void rotate(int[] nums, int k) {
		k = k % nums.length;
		reverse(nums, 0, nums.length - 1);
		reverse(nums, 0, k-1);
		reverse(nums, k, nums.length-1);
	}

	private void reverse (int[] nums, int start, int end) {
		while (start < end ) {
			int temp = nums[start];
			nums[start] = nums[end];
			nums[end]= temp;
			start++;
			end--;
		}
	}
}


