package leetcode;

public class Solution441 {
	
	public static void main(String[] args) {
		Solution441 solution441 = new Solution441();
		System.out.println(solution441.arrangeCoins(8));
		System.out.println(solution441.arrangeCoins(6));
		System.out.println(solution441.arrangeCoins(2147483647));
		
	}
	
    public int arrangeCoins(int n) {
        
        long start = 1;
        long end = n;
        long middle = 0;
        while(start <= end){
        	middle = start + (end -start)/2;
        			
        	long temp = (1+ middle)*middle/2;
        	if( temp == n){
        		return (int)middle;
        	}
        	if(temp > n){
        		end = middle-1;
        	}else{
        		start = middle +1;
        	}
        }
        return (int)(start-1);
    }

}
