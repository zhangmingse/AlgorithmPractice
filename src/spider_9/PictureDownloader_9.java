package spider_9;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

public class PictureDownloader_9 implements Runnable {

	private int index;
	private String url;
	private String path = "c:/jiandan";
	private int buffer_size = 1024 * 1024;

	public PictureDownloader_9(String _url, int _index) {
		// TODO Auto-generated constructor stub
		url = _url;
		index = _index;
	}

	File file;
	InputStream inputStream;
	OutputStream outputStream;

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {

			String file_name = url.substring(url.lastIndexOf("/")+1);
			File dir = new File(path);
			if (!dir.exists()) {
				dir.mkdir();
			}
			file = new File(path + "/" + file_name);
			outputStream = new FileOutputStream(file);
			URL des_url = new URL(url);
			URLConnection uConnection = des_url.openConnection();
			inputStream = uConnection.getInputStream();
			byte buffer[] = new byte[buffer_size];
			int readlen = 0;
			while ((readlen = inputStream.read(buffer)) > 0) {
				outputStream.write(buffer, 0, readlen);
			}
			outputStream.flush();

			outputStream.close();
			inputStream.close();
			System.out.println(index + " " + file_name + " done!");

		} catch (Exception e) {
			// TODO: handle exception
			if (file != null && file.exists()) {
				boolean d = file.delete();
				if(!d){
					System.err.println("execute delete fail");
				}
				System.err.println(" ==download exception== " + url + "   " + e.getMessage() + ".delete and exit!");
			}
			
		} finally {
			try {
				//outputStream.close();
				//inputStream.close();
			}catch(Exception e){
				e.printStackTrace();
			} 

		}

	}

}
