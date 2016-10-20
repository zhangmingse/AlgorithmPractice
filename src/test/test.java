package test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;

public class test {
	public static void main(String args[]){
		System.out.println("hi");
		int i = -1;
		i = i>>1;
		System.out.println(i);
		
		File file = new File("C:\\Users\\think\\workspace\\ZMpractice\\src\\test\\test.txt");
		if(!file.exists()){
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.exit(-1);
			}
		}
		OutputStream outputStream;
		try {
			outputStream = new FileOutputStream(file);
			byte buffer[];
			String string = "hello world";
			buffer = string.getBytes();
			outputStream.write(buffer, 0, buffer.length);
			outputStream.flush();
			file.delete();
			outputStream.close();
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		System.out.println("done!");
	}

}
