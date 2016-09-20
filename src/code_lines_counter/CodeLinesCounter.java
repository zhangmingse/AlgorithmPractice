package code_lines_counter;

import java.io.File;
import java.util.Scanner;

public class CodeLinesCounter {

	public static void main(String[] args) {
		try {
			System.out.println("please input the code directory:");
			Scanner scanner = new Scanner(System.in);
			String dir_path = scanner.nextLine();
			scanner.close();
			File file = new File(dir_path);
			int count = 0;
			if (file.exists()&&file.isFile()) {
				count = count_file_lines(file);
			} else if (file.exists()&&file.isDirectory()) {
				count = count_dirextory_lines(file);
			}
			System.out.println("total lines : " + count);
			System.out.println("done!");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	private static int count_dirextory_lines(File file)throws Exception{
		int lines_count = 0;
		try{
			for(File file_item : file.listFiles()){
				if(file_item.isDirectory()){
					lines_count += count_dirextory_lines(file_item);
				}else if (file_item.isFile()) {
					lines_count+=count_file_lines(file_item);
				}
			}
			return lines_count;
		}catch(Exception e){
			throw e;
		}
	}
	private static int count_file_lines(File file)throws Exception{
		int lines_count = 0;
		try {
			
			Scanner scanner = new Scanner(file);
			while(scanner.hasNextLine()){
				scanner.nextLine();
				lines_count++;
			}
			scanner.close();
			return lines_count;
		} catch (Exception e) {
			throw e;
		}	
	}
}
