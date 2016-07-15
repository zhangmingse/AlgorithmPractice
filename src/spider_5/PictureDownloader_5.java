package spider_5;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class PictureDownloader_5 implements Runnable {

	private int page_number;
	private String url;

	public PictureDownloader_5(String url, int page_number) {
		// TODO Auto-generated constructor stub
		this.url = url;
		this.page_number = page_number;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			String base_dir = "c:/jiandan";
			File dir = new File(base_dir);
			if (!dir.exists()) {
				dir.mkdir();
			}
			String file_name = url.substring(url.lastIndexOf("/") + 1);
			String full_path_name = base_dir + "/" + page_number + "-" + file_name;
			URL image_url = new URL(url);
			URLConnection uConnection = image_url.openConnection();
			InputStream inputStream = uConnection.getInputStream();
			byte[] in_buffer = new byte[1024*512];
			int read_len = 0;
			FileOutputStream fOutputStream = new FileOutputStream(new File(full_path_name));
			
			while(true){
				read_len = inputStream.read(in_buffer);
				if(read_len <=0)
					break;
				fOutputStream.write(in_buffer, 0, read_len);
				
			}
			fOutputStream.close();
			inputStream.close();
			System.out.println(full_path_name + "download complite!");
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
