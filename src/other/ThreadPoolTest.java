package other;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

import org.omg.CORBA.PUBLIC_MEMBER;

public class ThreadPoolTest {

	public static void main(String[] args) {
		System.out.println("Please input Directory");
		Scanner scanner = new Scanner(System.in);
		String path = scanner.nextLine();
		System.out.println("Please input Keyword");
		String keyword = scanner.nextLine();
		
		ExecutorService executorService = Executors.newCachedThreadPool();
		MathCounter mathCounter = new MathCounter(new File(path), executorService, keyword);
		Future<Integer> future = executorService.submit(mathCounter);
		try {
			int result = future.get();
			System.out.println(result+" matching files");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		scanner.close();
		executorService.shutdown();
		int largestPoolSize = ((ThreadPoolExecutor)executorService).getLargestPoolSize();
		System.out.println("Largest Pool Size:"+largestPoolSize);
		
		

	}

	private static class MathCounter implements Callable<Integer> {
		private File directory;
		private ExecutorService pool;
		private String keyWord;
		int count = 0;

		public MathCounter(File dir, ExecutorService pool, String key) {
			// TODO Auto-generated constructor stub
			directory = dir;
			this.pool = pool;
			keyWord = key;

		}

		@Override
		public Integer call() throws Exception {
			// TODO Auto-generated method stub
			try {
				List<Future<Integer>> result_list;
				if (directory.isDirectory()) {
					File[] list_file = directory.listFiles();
					result_list = new ArrayList<>();
					for (File f : list_file) {
						MathCounter counter = new MathCounter(f, pool, keyWord);
						Future<Integer> future = pool.submit(counter);
						result_list.add(future);
					}
				}else{
					if(search(directory))
						count++;
					return count;
				}
				
				for(Future<Integer> future : result_list){
					count += future.get();
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
			return count;
		}

		private boolean search(File file) {
			boolean found = false;
			try {
				Scanner scanner = new Scanner(file);
				while (scanner.hasNextLine()) {
					String str = scanner.nextLine();
					if (str.contains(keyWord)) {
						found = true;
						return found;
					}
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return found;
		}
	}
}
