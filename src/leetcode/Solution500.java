package leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution500 {

	public static void main(String[] args) {
		String[] strings = new String[]{"Hello", "Alaska", "Dad", "Peace"};
		Solution500 solution500 = new Solution500();
		
		strings = solution500.findWords(strings);
		for(String s:strings){
			System.out.println(s);
		}
		
	}
    public String[] findWords(String[] words) {
        char[] c1 = new char[]{'q','w','e','r','t','y','u','i','o','p'};
        char[] c2 = new char[]{'a','s','d','f','g','h','j','k','l'};
        char[] c3 = new char[]{'z','x','c','v','b','n','m'};
        
        char[][] cc = new char[][]{c1,c2,c3};
        
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0;i<3;i++){
        	for(int j = 0;j<cc[i].length;j++){
        		map.put(cc[i][j], i);
        		map.put((char)(cc[i][j]-32), i);
        	}
        }
        List<String> result = new LinkedList<>();
        
        for(String string : words){
        	char[] char_arr = string.toCharArray();
        	if(char_arr.length <=0 ){
        		continue;
        	}
        	int temp = map.get(char_arr[0]);
        	boolean flag = true;
        	for(int i = 1;i<char_arr.length;i++){
        		if(map.get(char_arr[i]) == temp){
        			continue;
        		}
        		flag = false;
        		break;
        	}
        	if(flag){
        		result.add(new String(char_arr, 0, char_arr.length));
        	}
        }
        String[] strings = new String[result.size()];
        for(int i = 0;i<result.size();i++){
        	strings[i] = result.get(i);
        }
        return strings;
    }
}
