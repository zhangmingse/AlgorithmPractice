package spider_7;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class Picture_downloader_7 implements Runnable {

	private int page_number = 0;
	private String url;

	public Picture_downloader_7(int page_num, String url) {
		// TODO Auto-generated constructor stub
		this.page_number = page_num;
		this.url = url;
	}

	@Override
	public void run() {
		try {
			// TODO Auto-generated method stub
			String dir = "c:/jiandan";
			File dFile = new File(dir);
			String file_name = url.substring(url.lastIndexOf("/")+1);
			if (!dFile.exists()) {
				dFile.mkdir();
			}
			URL image_url = new URL(url);
			URLConnection uConnection = image_url.openConnection();
			InputStream inputStream = uConnection.getInputStream();
			byte[] in_buffer = new byte[1024*512];
			int read_len = 0;
			File file = new File(dir+"/"+page_number+"-"+file_name);
			FileOutputStream fOutputStream = new FileOutputStream(file);
			while(true){
				read_len = inputStream.read(in_buffer);
				if(read_len<=0)
					break;
				fOutputStream.write(in_buffer, 0, read_len);
			}
			inputStream.close();
			fOutputStream.close();
			System.out.println(page_number+"-"+file_name+" download complite");
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
