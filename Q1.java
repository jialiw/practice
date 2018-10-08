class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> indexMap = new HashMap<Integer, Integer>();
        for (int i = 0; i<nums.length; i++ ) {
            indexMap.put(nums[i], i);
        }
        
        for (int i = 0; i<nums.length; i++) {
            int remainValue = target - nums[i];
            if (indexMap.containsKey(remainValue) && indexMap.get(remainValue)!= i) {
                return new int[]{indexMap.get(remainValue), i};
            }
        }
        throw new IllegalArgumentException("no available solution");
    }
}


// a modified version 
class Solution {
    public int[] twoSum(int[] nums, int target) throws IllegalArgumentException {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] {map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("no possible solutions");
    }
}