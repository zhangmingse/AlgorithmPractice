package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class test {

	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		if(scanner.hasNextLine()){
			String string = scanner.nextLine();
			char c;
			int index = 0;
			for(;index < string.length();index++){
				c = string.charAt(index);
				
				if(Character.isLetter(c)){
					StringBuilder sBuilder = new StringBuilder();
					for(;index<string.length();index++){
						c = string.charAt(index);
						if(Character.isLetter(c)){
							sBuilder.append(c);
						}else{
							break;
						}
					}
					sBuilder.reverse();
					System.out.print(sBuilder.toString());
					index--;
				}
				else{
					System.out.print(c);
				}
			}
		}
		scanner.close();
		
		
	}
}
