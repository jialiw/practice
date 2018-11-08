//561. Array Partition I

// Sorted array solution
// O(nlogn) 
class Solution {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length-1; i=i+2) {
        	sum += nums[i];
        }
        return sum;
    }
}

// O(n)      
class Solution {
	public int arrayPairSum(int[] nums) {
		int [] exist = new int[20001]; // 10000+10000+1
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			exist[nums[i]+10000]++;
		}
		boolean odd = true;
		// O(n) here although having two for/while
		// as the inner while loop is for exist[i] itself 
		for (int i = 0; i < exist.length; i++) {  
			while (exist[i] > 0) {
				if (odd) {
					sum += i - 10000;
				}
				exist[i]--;
				odd = !odd;
			}
		}
		return sum;
	}
}