package leetcode;

public class Solution650 {
	public static void main(String[] args) {
		System.out.println(new Solution650().minSteps1(1));
		System.out.println(new Solution650().minSteps1(2));
		System.out.println(new Solution650().minSteps1(3));
		System.out.println(new Solution650().minSteps1(4));
		System.out.println(new Solution650().minSteps1(5));
	}
	public int minSteps1(int n){//best solution from leetcode
		if(n <= 1)
			return 0;
		for(int i = 2;i<=n;i++){
			if(n % i == 0){
				return i + minSteps1(n/i);
			}
		}
		return 0;
	}
    public int minSteps(int n) {
        int[] arr = new int[n+1];

        
        for(int i= 1;i<n+1;i++){
        	arr[i] = Integer.MAX_VALUE;
        }
        arr[1] = 0;
        
        for(int i = 2;i<=n;i++){
        	int index = i;
        	int temp = 2;
        	int steps = 0;
        	while(temp <= i){
        		if(i % temp == 0){
        			index = i/temp;
        			steps = arr[index] + temp;
        			arr[i] = steps;
        			break;
//        			if(steps < arr[i])
//        				arr[i] = steps;
        		}
        		temp++;
        		
        	}
        }
        
        return arr[n];
    }

}
