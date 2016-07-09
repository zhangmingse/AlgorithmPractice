package other;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class SocketTest_1 {
	public static void main(String[] args){
		try {
			ServerSocket serverSocket = new ServerSocket(8189);
			Socket socket = null;
			while((socket = serverSocket.accept())!=null){
				new Thread(new MySocketRunnable(socket)).start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private static class MySocketRunnable implements Runnable{
		private Socket socket;
		public MySocketRunnable(Socket s) {
			// TODO Auto-generated constructor stub
			socket = s;
			
			try {
				InputStream in = socket.getInputStream();
				OutputStream out = socket.getOutputStream();
				PrintWriter printWriter = new PrintWriter(out,true);
				printWriter.println("hello.enter BYE to exit");
				Scanner scanner = new Scanner(in);
				while (scanner.hasNextLine()) {
					String str  = scanner.nextLine();
					if(str.equals("BYE")){
						printWriter.println("see you next time");
						scanner.close();
						socket.close();
						return;
					}
					printWriter.println("Echo:"+str);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			
		}
		
	}

}
