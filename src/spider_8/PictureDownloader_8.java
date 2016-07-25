package spider_8;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class PictureDownloader_8 implements Runnable {
	int page_number;

	String url_str;

	public PictureDownloader_8(int page_number, String url_str) {
		// TODO Auto-generated constructor stub
		this.page_number = page_number;
		this.url_str = url_str;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			String filename = url_str.substring(url_str.lastIndexOf("/")+1);
			filename = page_number + "-" + filename;
			
			String dir_str = "c:/jiandan";
			File dir = new File(dir_str);
			if(!dir.exists())
				dir.mkdir();
			String full_path = dir_str + "/" +filename;
			File file = new File(full_path);
			FileOutputStream fOutputStream = new FileOutputStream(file);
			
			URL url = new URL(url_str);
			URLConnection uConnection = url.openConnection();
			InputStream inputStream = uConnection.getInputStream();
			byte[] in_buffer = new byte[1024*512];
			int read_len = 0;
			while(true){
				read_len=inputStream.read(in_buffer);
				if(read_len<=0)
					break;
				fOutputStream.write(in_buffer, 0, read_len);
			}
			fOutputStream.close();
			inputStream.close();
			System.out.println(filename+"  done!");
			
			
		} catch (Exception e) {

		}

	}

}
