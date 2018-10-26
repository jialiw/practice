//Q283. Move zeros 

// iterate and count number of zero
// O(n) Q(1)

class Solution {
    public void moveZeroes(int[] nums) {
    	int pos = 0;
 		for (int i = 0; i < nums.length; i++ ) {
 			if (nums[i] != 0) {
 				nums[i-pos] = nums[i]; // let later non-zero pos to take the place 
            }
 			else { 
                pos++;
            }
 		}    

 		for (int i = nums.length - pos; i < nums.length; i++) {
 			nums[i] = 0;
 		}   
    }
}

// same idea but better coding 
class Solution {
    public void moveZeroes(int[] nums) {
        
        int lastNonZeroPosition = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                nums[lastNonZeroPosition] = nums[i];
                lastNonZeroPosition++;
            }
        }
        
        for(int j = lastNonZeroPosition; j < nums.length; j++){
            nums[j] = 0;
        }
    }
}