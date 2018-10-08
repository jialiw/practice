// 26. Remove Duplicates from Sorted Array
// main idea: since the array is sorted, if the current value is equal to 
// the previous one, then current value needs to be removed

class Solution {
    public int removeDuplicates(int[] nums) {
        int l = nums.length > 0 ? 1 : 0;
        for (int i : nums) {
     		if (i > nums[l-1]) {
     			nums[l++] = i;
     		}   	
        } 

        return l;
    }
}


class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int j = 1;
        for (int i = 1; i<nums.length; i++) {
        	if(nums[i]>nums[i-1]) {
                nums[j]=nums[i];
                j++;
        	}
        }
        return j;
    }
}