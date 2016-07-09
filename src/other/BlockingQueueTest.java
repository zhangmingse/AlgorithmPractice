package other;

import java.io.File;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueTest {
	private static final int FILE_QUEUE_SIZE = 10;
	private static final int SEARCH_THREAD_SIZE = 100;
	
	public static void main(String[] args) {
		BlockingQueue<File> blockingQueue = new ArrayBlockingQueue<>(FILE_QUEUE_SIZE);
		System.out.println("Please input start directory path");
		Scanner scanner = new Scanner(System.in);
		String start_directory_path = scanner.nextLine();
		System.out.println("Please input key word");
		String key_word = scanner.nextLine();
		scanner.close();
		
		FileEnumerationTask enumerationTask = new FileEnumerationTask(blockingQueue, new File(start_directory_path));
		new Thread(enumerationTask).start();
		
		for(int i = 0;i<100;i++){
			new Thread(new SearchTask(blockingQueue, key_word)).start();
		}
		
		
	}
	
	private static class FileEnumerationTask implements  Runnable {
		private BlockingQueue<File> blockingQueue;
		private File start_file;
		public static File DUMP_FILE = new File("");
		public FileEnumerationTask(BlockingQueue<File> queue,File start_file){
			blockingQueue = queue;
			this.start_file = start_file;
		}
		public void run() {
			try {
				enumerate(start_file);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		private void enumerate(File file_dir) throws InterruptedException{
			File[] file_list = file_dir.listFiles();
			for(File file:file_list){
				if(file.isDirectory())
					enumerate(file);
				else{
					blockingQueue.put(file);
				}
			}
			blockingQueue.put(DUMP_FILE);
		}
	}
	
	private static class SearchTask implements Runnable{
		private BlockingQueue<File> blockingQueue;
		private String key_word;
		private boolean done = false;
		
		public SearchTask(BlockingQueue<File> queue,String key) {
			// TODO Auto-generated constructor stub
			blockingQueue = queue;
			key_word = key;
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			try {
				while(!done){
					File file = blockingQueue.take();
					if(file == FileEnumerationTask.DUMP_FILE){
						done = true;
						blockingQueue.put(file);
						continue;
					}else{
						Scanner scanner = new Scanner(file);
						int line_number = 0;
						while(scanner.hasNextLine()){
							String s = scanner.nextLine();
							if(s.contains(key_word)){
								System.out.println("path:"+file.getPath()+"\n line number:" + line_number + "\n Content:"+s+"\n\n######################");
							}
							line_number++;
						}
						scanner.close();
					}
				}
			}catch(Exception e){
				
			}finally {
			}
				// TODO: handle finally clause
			}
			
		}
		

}
