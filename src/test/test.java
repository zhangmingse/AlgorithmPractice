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
	public static void main(String args[]){
		System.out.println("hi");
		int i = -1;
		i = i>>1;
		System.out.println(i);
		
		File file = new File("C:\\Users\\think\\Downloads\\view-source_jandan.net_ooxx_page-2174#comments.html");
		if(!file.exists()){
			System.err.println("file doesn't exist!");
			return;
		}
		try {
			Scanner scanner = new Scanner(new FileInputStream(file));
			StringBuilder builder = new StringBuilder();
			
			while(scanner.hasNextLine()){
				builder.append(scanner.nextLine());
			}
			scanner.close();
			Pattern pattern = Pattern.compile("(>)((http)(\\S+?)(large)(\\S+?)(\\.jpg))(<)");
			String string = builder.toString();
			Matcher matcher = pattern.matcher(string);
			while(matcher.find()){
//				System.out.println(string.substring(matcher.start(), matcher.end()));
				System.out.println(matcher.group(2));
			}
//			System.out.println(builder.toString());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		
		System.out.println("done!");
	}

}
