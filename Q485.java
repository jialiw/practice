//485. Max Consecutive Ones

// 7ms 
// O(n) 
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
       
       if (nums.length == 0 ) return 0;
       if (nums.length == 1 && nums[0] == 0) return 0;

       int max = 0, cur = 0;

       for (int i = 0; i < nums.length; i++) {
   			if (nums[i] == 1) {
                cur++;
                if (cur > max) max = cur;
            } else {   
   				cur = 0;
   			}
       }
       return max;
    }
}

//5ms
//O(n)
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int len = nums.length;
        if(len == 0) {
            return 0;
        }
        int count = 0, countMax = 0;
        for(int i = 0; i < len; i++) {
            if(nums[i] == 1) {
                ++count;
                if(countMax < count) {
                    countMax = count;
                }
            }
            else {
                count = 0;
            }
        }
        return countMax;
    }
}