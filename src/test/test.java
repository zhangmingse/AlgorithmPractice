package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class test {
	public static void main(String args[]) {
		System.out.println("hi");
		int i = -1;
		i = i >> 1;
		System.out.println(i);

//		File file = new File("C:\\Users\\think\\Downloads\\view-source_jandan.net_ooxx_page-2174#comments.html");
//		if (!file.exists()) {
//			System.err.println("file doesn't exist!");
//			return;
//		}
//		try {
//			Scanner scanner = new Scanner(new FileInputStream(file));
//			StringBuilder builder = new StringBuilder();
//
//			while (scanner.hasNextLine()) {
//				builder.append(scanner.nextLine());
//			}
//			scanner.close();
//			Pattern pattern = Pattern.compile("(>)((http)(\\S+?)(large)(\\S+?)(\\.jpg))(<)");
//			String string = builder.toString();
//			Matcher matcher = pattern.matcher(string);
//			while (matcher.find()) {
//				// System.out.println(string.substring(matcher.start(),
//				// matcher.end()));
//				System.out.println(matcher.group(2));
//			}
//			// System.out.println(builder.toString());
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		String p1 = "11";
		String p2 = "99";
		System.out.println(addStrings(p1, p2));

		System.out.println("done!");
	}

	static public String addStrings(String num1, String num2) {
		char[] param_shorter;
		char[] param_longer;
		char[] param_longer_pre;
		if (num1.length() < num2.length()) {
			param_shorter = num1.toCharArray();
			param_longer_pre = num2.toCharArray();
		} else {
			param_longer_pre = num1.toCharArray();
			param_shorter = num2.toCharArray();
		}
		param_longer = new char[param_longer_pre.length + 1];
		for (int i = 0; i < param_longer_pre.length; i++) {
			param_longer[i + 1] = param_longer_pre[i];
		}
		param_longer[0]='0';
		int int_temp = 0;
		int result_each_char = 0;
		int param1 = 0;
		int param2 = 0;
		int current_shorter_param_index = param_shorter.length - 1;
		int current_longer_param_index = param_longer.length - 1;
		while (current_shorter_param_index >= 0 || int_temp > 0) {
			if (current_shorter_param_index < 0) {
				param1 = 0;
			} else {
				param1 = convertCharToInt(param_shorter[current_shorter_param_index]);
			}
			param2 = convertCharToInt(param_longer[current_longer_param_index]);
			result_each_char = param1 + param2 + int_temp;
			if (result_each_char >= 10) {
				int_temp = result_each_char / 10;
				result_each_char = result_each_char % 10;
			} else {
				int_temp = 0;
			}
			param_longer[current_longer_param_index] = convertIntToChar(result_each_char);
			current_longer_param_index--;
			current_shorter_param_index--;
		}
		if(param_longer[0] == '0'){
			return new String(param_longer,1,param_longer.length-1);
		}else{
			return new String(param_longer,0,param_longer.length);	
		}

		
	}

	static private char convertIntToChar(int c) {
		switch (c) {
		case 0:
			return '0';
		case 1:
			return '1';
		case 2:
			return '2';
		case 3:
			return '3';
		case 4:
			return '4';
		case 5:
			return '5';
		case 6:
			return '6';
		case 7:
			return '7';
		case 8:
			return '8';
		case 9:
			return '9';

		default:
			break;
		}
		return 'x';
	}

	static private int convertCharToInt(char c) {
		switch (c) {
		case '0':
			return 0;
		case '1':
			return 1;
		case '2':
			return 2;
		case '3':
			return 3;
		case '4':
			return 4;
		case '5':
			return 5;
		case '6':
			return 6;
		case '7':
			return 7;
		case '8':
			return 8;
		case '9':
			return 9;

		default:
			break;
		}
		return -1;
	}

}
