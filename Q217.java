//Q217. Contains Duplicate 


// sorts array solution
// O(nlogn) O(1)

class Solution {
    public boolean containsDuplicate(int[] nums) {
 		Arrays.sort(nums);
 		for (int i = 1; i < nums.length; i++) {
 			if (nums[i-1]==nums[i]) return true;
 		}       
 		return false;
    }
}

// hashMap solution

class Solution {
	public boolean containsDuplicate(int[] nums) {
		HashMap<Integer, Integer> countMap = new HashMap<Integer, Integer>();
		for (int n: nums) {
			countMap.contains(n) ? countMap.put(n, countMap.get(n)+1) : countMap.put(n,1);
		}
	
		for (Map.Entry<Integer,Integer> entry: map.entrySet()) {
			if (entry.getValue() > 1) return true;
		}
		return false;
	}
}

// same idea but better coding to use hashSet
class Solution {
	public boolean containsDuplicate(int[] nums) {
		Set<Integer> set = new HashSet<Integer>();
		for (int n: nums) {
			if (set.contains(n)) return true;
			set.add(n);
		}
		return false;
	}
}

