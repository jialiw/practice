//532. K-diffs Pairs in an Array 

// Set solution 
// O(n) 
// when k != 0, set1 join set2 and get the number of matched pairs
class Solution {
    public int findPairs(int[] nums, int k) {
   		HashSet<Integer> set1 = new HashSet<Integer> ();
   		HashSet<Integer> set2 = new HashSet<Integer> ();
   		int pairs = 0;
   		if (k < 0) return 0;
   		if (k>0) {
   			for (int n: nums) {
	   			set1.add(n);
	   			set2.add(n+k);
	   		}
	   		set1.retainAll(set2);
            pairs = set1.size();
   		} else if (k==0) {
   			for (int n: nums) {
   				if (!set1.contains(n)){
   					set1.add(n);
   				} else {
                    if (!set2.contains(n)) {
                        set2.add(n);
                        pairs++;
                    }
   				}
   			}
   		}
   		
   		return pairs;
    }
}

// Map solution
// O(n)
class Solution {
	public int findPairs(int[] nums, int k) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int count = 0;
		if (k < 0) return 0;
		for (int n: nums) {
			map.put(n, map.getOrDefault(n,0) + 1);
		}

		for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
			if (k == 0) {
				if (entry.getValue() >= 2) count++;
			} else {
				if (map.containsKey(entry.getKey() + k)) count++;
			}
		}
		return count;
	}
}

// two pointer
// O(n^2)
class Solution {
	public int findPairs(int[] nums, int k) {
		if (nums == null || nums.length <=1 ) return 0;
		if (k < 0) return 0;
		Arrays.sort(nums);
		int count = 0;
		int low = 0, high = 1;
		while ( high < nums.length) {
			if (nums[high] == nums[low] + k) {
				count++;
				low++;
				while(high + 1< nums.length && (nums[high]==nums[high+1])) { // skip all duplicates
					high++;
				}
				high++;
			} else if (nums[high] > nums[low] + k) {
				low ++;
			} else {
				high++;
			}
			if (low == high) high++;
		}
		return count++;
	}
}