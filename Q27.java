// 27. Remove Element

// sort first and find where to push new value 
class Solution {
    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) return 0;
        Arrays.sort(nums);
        int l = 0;
        int p = 0;
        for (int n: nums) {
        	if (n < val) {
        		l++;
        		p++;
        	}
        	if (n > val) {
        		nums[l] = n;
        		l++;
        		p++;
        	}
        }
        return p; 
    }
}

// better solution
// arbitrarily adds position j value into position i if 
// position j value is not equal to val
class Solution {
    public int removeElement(int[] nums, int val) {
        int i = 0; // final position
        int j = 0;
        for(j = 0; j < nums.length ; j++)
        {
            if(nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        
        return i;
               
    }
}