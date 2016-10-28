package leetcode;

public class PalindromeNumber {

    public boolean isPalindrome(int x) {
        int newResult = 0;
        int oldParam = x;
        while(x!=0){
        	int temp = x%10;
        	newResult = newResult*10+temp;
        	x=x/10;
        }
        if(newResult == oldParam)
        	return true;
        else
        	return false;
    }
    
    public boolean isPalindrome_1(int x){
    	
    	return (new StringBuffer(new Integer(x).toString())).reverse().toString().equals(new Integer(x).toString());
    }
}
