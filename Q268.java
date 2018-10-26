//Q268. Missing number


// extra array solution
// o(n) o(n)
class Solution {
    public int missingNumber(int[] nums) {
        int[] tmp = new int[nums.length+1];
        for (int n : nums) {
        	tmp[n] = n + 1; // + 1 to differentiate with array default value 0
        }

        for (int i = 0; i < tmp.length; i++) {
        	if (tmp[i] == 0) return i;
        }
        return -1;
    }
}

// hashSet solution 
// o(n) o(n)
class Solution {
    public int missingNumber(int[] nums) {
        Set<Integer> numSet = new HashSet<Integer>();
        for (int num : nums) numSet.add(num);

        int expectedNumCount = nums.length + 1;
        for (int number = 0; number < expectedNumCount; number++) {
            if (!numSet.contains(number)) {
                return number;
            }
        }
        return -1;
    }
}


// sum difference solution 
// o(n) o(1)
class Solution {
	public int missingNumber(int[] nums) {
		int eSum = nums.length*(nums.length+1)/2;
		int aSum = 0;
		for (int n: nums) {
			aSum += n;
		}
		return eSum - aSum;
	}
}