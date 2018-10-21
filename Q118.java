// 118. Pascal's Triangle


// Dynamic Programming
// iterate previous line and make the next row 
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<List<Integer>> ();

        if (numRows == 0) {
        	return triangle;
        }

        // Java cannot directly create a list with value 
        triangle.add(new ArrayList<Integer>());
        triangle.get(0).add(1);

        for(int i = 1; i<numRows; i++) {
        	List<Integer> currentRow = new ArrayList<Integer>();
        	List<Integer> previousRow = triangle.get(i-1);

        	currentRow.add(1);
        	for (int j = 1; j < previousRow.size(); j++) {
        		currentRow.add(previousRow.get(j-1) + previousRow.get(j));
        	}
        	currentRow.add(1);
        	triangle.add(currentRow);
        }
        return triangle;
    }
}


// create a matrix first 
// still use DP solution
class Solution {
    public List<List<Integer>> generate(int numRows) {
        if(numRows<=0) return new ArrayList<>();
        int[][] mat= new int[numRows][numRows];
        for(int i=0;i<mat.length;i++) {
            mat[i][i]=1;
        }
        for(int i=1;i<mat.length;i++) {
            mat[i][0]=1;
        }
        List<List<Integer>> result = new ArrayList<>();
        for(int i=2;i<mat.length;i++) {
            for(int j=1;j<i;j++) {
                mat[i][j]=mat[i-1][j-1]+mat[i-1][j];
            }
        }
        for(int i=0;i<mat.length;i++) {
            List<Integer> list= new ArrayList<>();
            for(int j=0;j<=i;j++) {
                list.add(mat[i][j]);
            }
            result.add(list);
        }
        return result;
    }
}


public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        ArrayList<Integer> pre = null;
        for (int i = 1; i <= numRows; i++) {
            ArrayList<Integer> save = new ArrayList<>();
            for (int j = 1; j <= i; j++)
                if (j == 1 || j == i) save.add(1);
                else save.add(pre.get(j-1) + pre.get(j-2));
            result.add(save);
            pre = save;
        }
        return result;
    }
}