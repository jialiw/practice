// #119. Pascal's Triangle II

class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> pre = new ArrayList<Integer>();
        List<Integer> cur = new ArrayList<Integer>();

        if (rowIndex == 0) {
        	cur.add(1);
        	return cur;
        }
        
        for (int i = 1; i <= rowIndex; i++) {
            cur = new ArrayList<Integer>();
        	for (int j = 0; j <= i; j++) {
        		if (j == 0 || j == i) {
        			cur.add(1);
        		} else {
        			cur.add(pre.get(j-1) + pre.get(j));
        		}
        	}
        	pre = cur;
        }
        return cur;
    }
}