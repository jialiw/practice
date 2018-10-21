//Q167. Two Sum II - Input array is sorted

// naive greedy solution 
// O(n^2)
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        for (int i = 1; i <= numbers.length; i++) {
        	int m = numbers[i-1];
        	if (m > target) break;
        	for (int j = i+1; j <= numbers.length; j++) {
        		if (numbers[j-1]+m==target) {
        			result[0] = i;
        			result[1] = j;
        		}
        		if (numbers[j-1]>target) break;
        	}
        }
        return result;
    }
}

// 1ms solution O(n)
// start count from head and tail, if > target, tail --; if < target, head ++; 
class Solution {
	public int[] twoSum(int[] numbers, int target) {
		int[] result = new int[2];
		int left = 0, right = numbers.length-1;
		while (left < right) {
			int sum = numbers[left] + numbers[right];
			if (sum==target) {
				result[0] = left + 1;
				result[1] = right + 1;
				break;
			} else if (sum>target) {
				right--;
			} else {
				left++;
			}
		}
		return result;
	}
}

