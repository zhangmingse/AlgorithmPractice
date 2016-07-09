package other;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerSocketTest {
	
	public static void main(String[] args){
		try {
			ServerSocket serverSocket = new ServerSocket(8189);
			Socket incoming;
			while((incoming = serverSocket.accept())!=null){
			Runnable r = new ThreadEchoHandler(incoming);
			new Thread(r).start();
			System.out.println("program exit");
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private static class ThreadEchoHandler implements Runnable{
		private Socket socket;
		
		public ThreadEchoHandler(Socket s) {
			// TODO Auto-generated constructor stub
			socket = s;
		}

		@Override
		public void run() {
			try{
				InputStream in = socket.getInputStream();
				OutputStream out = socket.getOutputStream();
				
				Scanner scanner = new Scanner(in);
				PrintWriter writer = new PrintWriter(out,true);
				boolean done = false;
				writer.println("Hello, Enter BYE to exit.");
				while(!done && scanner.hasNextLine()){
					String line = scanner.nextLine();
					if(line.equals("BYE")){
						writer.println("BYE");
						done = true;
					}else{
						writer.println("Echo:"+line);
						
					}
					
				}
				scanner.close();
				socket.close();
			}catch(Exception exception){
				exception.printStackTrace();
			}
			// TODO Auto-generated method stub
			
		}
		
	}

}
