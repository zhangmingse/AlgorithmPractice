package other;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class HashSetTest {
	public static void main(String[] args) {
		Set<String> words = new HashSet<>();
		File file = null;
		FileInputStream fio = null;
		try {
			file = new File("C:\\Users\\think\\Desktop\\pg11.txt");
			fio = new FileInputStream(file);

		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
		
		Scanner scanner = new Scanner(fio);
		long totalTime = 0;
		long startTime = 0;
		long endTime = 0;
		while (scanner.hasNext()) {
			String word =  scanner.next();
			startTime = System.currentTimeMillis();
			words.add(word);
			endTime = System.currentTimeMillis();
			totalTime +=(endTime-startTime);
			
		}
		
		System.out.println("HashSet:"+totalTime);
		
		try {
			scanner.close();
			
			fio = new FileInputStream(file);
			scanner = new Scanner(fio);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		totalTime = 0;

		Set<String> words_tree_set = new TreeSet<>();
		while(scanner.hasNext()){
			String word = scanner.next();
			startTime = System.currentTimeMillis();
			words_tree_set.add(word);
			endTime = System.currentTimeMillis();
			totalTime += (endTime-startTime);
		}
		System.out.println("TreeSet:"+totalTime);
		
		Iterator<String> iterator = words_tree_set.iterator();
		for(int i = 0;i<1000 && iterator.hasNext();i++){
			System.out.println(iterator.next());
		}
		scanner.close();
	}

}
