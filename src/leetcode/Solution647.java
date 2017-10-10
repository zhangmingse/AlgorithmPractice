package leetcode;

public class Solution647 {
	public static void main(String[] args) {
		System.out.println(new Solution647().countSubstrings("abc"));
		System.out.println(new Solution647().countSubstrings("aaa"));
	}
	
    public int countSubstrings(String s) {
        int result = 0;
        
        char[] array = s.toCharArray();
        int[][] temp = new int[array.length][array.length];
        int i,j,jj;
        for(jj=0;jj<array.length;jj++){
        	j = jj;;
        	for(i=0;j<array.length && i<array.length;j++,i++){
        		
        		
        		if(j>i+1){
        			if(temp[i+1][j-1] == 1 && array[i] == array[j]){
        				temp[i][j] = 1;
        				result++;
        			}
        		}else if(j==i+1){
        			if(array[j] == array[i]){
        				temp[i][j] = 1;
        				result ++;
        			}
        		}else{
        			temp[i][j] = 1;
        			result ++;
        		}
        	}
        }
        return result;
    }

}
