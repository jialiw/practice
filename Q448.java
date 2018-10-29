//448. Find All Numbers Disappeared in an Array

// O(n) O(n)
// initial thought: 43ms 
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        HashSet<Integer> numSet = new HashSet<Integer>();
        List<Integer> missList = new ArrayList<Integer>();

        for (int i = 0; i < nums.length; i++) {
        	numSet.add(i+1);
        }

        for (int i: nums) {
        	if (numSet.contains(i)) numSet.remove(i);
        }

        for (int n: numSet) {
        	missList.add(n);
        }
        return missList;
    }
}

// O(n) O(n)
// 7ms 
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        
    	List<Integer> missList = new ArrayList<Integer>();
    	int [] check = new int[nums.length];

    	for (int n: nums) {
    		check[n-1]++;
    	}

    	for (int i = 0; i < check.length; i++) {
    		if (check[i]==0) missList.add(i+1);
    	}

    	return missList;
    }
}

// O(n) O(1)
// 11ms
class Solution {
	public List<Integer> findDisappearedNumbers(int[] nums) {
		List<Integer> missList = new ArrayList<Integer>();
		for (int n: nums) {
			int indx = Math.abs(n) - 1;
			nums[indx] = (nums[indx] > 0 ) ? -nums[indx]: nums[indx];
		}

		for(int i = 0; i < nums.length; i++) {
			if (nums[i] > 0 ) missList.add(i+1);
		}
		return missList;
	}
}