package spider_6;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class Picture_downloader_6 implements Runnable {

	private int page_number;
	private String url;
	private String dir_str = "c:/jiandan";

	public Picture_downloader_6(int page_number, String url) {
		// TODO Auto-generated constructor stub
		this.page_number = page_number;
		this.url = url;
	}

	@Override
	public void run() {
		try {
			// TODO Auto-generated method stub
			File dir = new File(dir_str);
			if (!dir.exists()) {
				dir.mkdir();
			}
			
			String file_name = url.substring(url.lastIndexOf("/")+1);
			String full_path_filename = dir_str+"/" +page_number +"-"+file_name;
			File file = new File(full_path_filename);
			FileOutputStream fOutputStream = new FileOutputStream(file);
			URL image_url = new URL(url);
			URLConnection uConnection = image_url.openConnection();
			InputStream inputStream = uConnection.getInputStream();
			byte[] in_buffer = new byte[1024*512];
			
			int read_len = 0;
			while(true){
				read_len = inputStream.read(in_buffer);
				if(read_len<=0){
					break;
				}
				fOutputStream.write(in_buffer, 0, read_len);
			}
			fOutputStream.close();
			inputStream.close();
			System.out.println(page_number+"-"+file_name+" download complite!");
			
		} catch (Exception e) {

		}
	}

}
