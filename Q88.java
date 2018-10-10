// 88. Merge Sorted Array

// O(n) O(n)
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] newNums1 = new int[nums1.length];
        int pos1 = 0, pos2 = 0, pos = 0;
        while (pos2 < n && pos1 < m) {
        	if (nums1[pos1] <= nums2[pos2]) {
        		newNums1[pos] = nums1[pos1];
        		pos1++;
        	} else {
        		newNums1[pos] = nums2[pos2];
        		pos2++;
        	}
        	pos++;
        }
        while (pos1 < m) {
        	newNums1[pos] = nums1[pos1];
        	pos++;
        	pos1++;
        }
        while (pos2 < n) {
        	newNums1[pos] = nums2[pos2];
        	pos++;
        	pos2++;
        }
        for (int i = 0; i< newNums1.length; i++) {
            nums1[i] = newNums1[i];
        }
    }
}

// method no need to create the extra array 
// O(n) O(1)
class Solution {
	public void merge(int[]nums1, int m, int[] nums2, int n) {
		int pos1 = m -1 , pos2 = n -1, pos = m+n-1;
		while (pos1 >= 0 && pos2 >= 0) {
			if (nums1[pos1]>nums2[pos2]) {
				nums1[pos--] = nums1[pos1--];
			} else {
				nums1[pos--] = nums2[pos2--];
			}
		} 
		while(pos2 >= 0) {
			nums1[pos--] = nums2[pos2--];
		}
	}
}

// lamada expression
class Solution {
	public void merge(int[]nums1, int m, int[] nums2, int n) {
		int pos1 = m -1 , pos2 = n -1, pos = m+n-1;
		while (pos1 >= 0 && pos2 >= 0) {
			nums1[pos--] = (nums1[pos1] > nums2[pos2]) ? nums1[pos1--] : nums2[pos2--];
		} 
		while(pos2 >= 0) {
			nums1[pos--] = nums2[pos2--];
		}
	}
}