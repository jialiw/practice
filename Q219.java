//Q219. Contains Duplicate II

// hashTable solution
// O(n) O(n) 
// iterate the array and check difference between current position and last position of same value
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
        	int elem = nums[i];
        	if (map.containsKey(elem)) {
        		if (i - map.get(elem)<= k) return true;
        		else map.put(elem, i);
        	} else {
        		map.put(elem, i);
        	}
        }
        return false;
    }
}

// hsshSet solution
// O(n) O(n)
class Solution {
	public boolean containsNearbyDuplicate(int[] nums, int k) {
		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (i > k ) set.remove(nums[i - k -1]);
			if (!set.add(nums[i])) return true; // !set.add() == true ==> same element is already in set
		}
		return false;
	}
}