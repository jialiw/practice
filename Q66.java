// #66. Plus One

// back thorough array and break until finding a non 9 number 
// otherwise, create a new array with length + 1
class Solution {
    public int[] plusOne(int[] digits) {
        int length = digits.length;
        for (int i = length; i > 0; --i) {
        	if (digits[i-1]!= 9) {
        		digits[i-1] ++;
        		return digits;
        	} else {
        		digits[i-1] = 0;
        	}
        }

        int[] newDigits = new int[length+1];
        newDigits[0]=1;
        for (int i = 0; i < length; i++) {
        	newDigits[i+1] = digits[i];
        }
        return newDigits;
    }
}