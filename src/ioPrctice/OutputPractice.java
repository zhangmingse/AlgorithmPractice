package ioPrctice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import sort.SortTestData;

public class OutputPractice {
	
	public static void main(String[] args){
		System.out.println("hello world");
		
		SortTestData[] a = new SortTestData[3];
		a[0] = new SortTestData(0);
		a[1] = new SortTestData(1);
		a[2] = new SortTestData(2);
		SortTestData[] a1 = new SortTestData[3];
		a1[0] = a[0];
		a1[1] = a[1];
		a1[2] = a[2];

		
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("please input level number:");
		String levelCountStr ;
		try {
			levelCountStr = reader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("reade error,exit!");
			return;
		}
		
		int levelCount = 0;
		try {
			levelCount = Integer.parseInt(levelCountStr);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			System.out.println("the input can't be translate into number .exit!");
			return;
		}
		
//		Hanoi.solve(levelCount,1,2,3);
		Hanoi.solve_my_practice1(levelCount, 1, 2, 3);
		System.out.println("done !");
		
//		limittest();
	}
	
	private static void limittest(){
		int a = Integer.MIN_VALUE;
		System.out.println("a min ="+a);
		System.out.println("a min - 1 = " + (a-1));
	}

}
