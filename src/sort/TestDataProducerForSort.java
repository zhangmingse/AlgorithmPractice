package sort;

import java.util.Random;

//produce test data for sort
public class TestDataProducerForSort {
	public static SortTestData[] geTestDatas(int size){
		
		SortTestData[] tdata = new SortTestData[size];
		Random random = new Random();
		for(int i = 0;i<size;i++){
			tdata[i] = new SortTestData(random.nextInt(size));
		}
		return tdata;
	}

}
