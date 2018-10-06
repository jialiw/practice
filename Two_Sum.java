//1. two sums
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
