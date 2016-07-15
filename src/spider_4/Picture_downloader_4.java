package spider_4;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class Picture_downloader_4 implements Runnable {
	private String url = "";
	private int page_number = 0;
	private String dir = "c:/jiandan";

	public Picture_downloader_4(String url, int page_number) {
		// TODO Auto-generated constructor stub
		this.url = url;
		this.page_number = page_number;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			File des_dir = new File(dir);
			if(!des_dir.exists()){
				des_dir.mkdir();
			}
			String file_name = url.substring(url.lastIndexOf("/") + 1);
			URL image_url = new URL(url);
			URLConnection uConnection = image_url.openConnection();
			InputStream inputStream =  uConnection.getInputStream();
			byte[] in_buffer = new byte[1024*512];
			int read_len = 0;
			File des_file = new File(dir+"/"+page_number+"-"+file_name);
			FileOutputStream fileOutputStream = new FileOutputStream(des_file);
			while(true){
				read_len = inputStream.read(in_buffer);
				if(read_len <= 0 )
					break;
				fileOutputStream.write(in_buffer, 0, read_len);
				
			}
			fileOutputStream.close();
			System.out.println(file_name+" download done!");
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
