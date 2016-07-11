package spider_3;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class Picture_downloader_3 implements Runnable {

	private String url;
	private int page_number;
	private String base_dir = "c:/jiandan";

	public Picture_downloader_3(String url, int page_number) {
		// TODO Auto-generated constructor stub
		this.url = url;
		this.page_number = page_number;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			File dir = new File(base_dir);
			if (!dir.exists()) {
				dir.mkdir();
			}
			String file_name = url.substring(url.lastIndexOf("/") + 1);
			String full_file_path = base_dir+"/" + page_number+"-"+file_name;
			URL image_url = new URL(url);
			URLConnection uConnection = image_url.openConnection();
			InputStream inputStream = uConnection.getInputStream();
			byte[] in_buffer = new byte[1024*512];
			boolean done = false;
			FileOutputStream fileOutputStream = new FileOutputStream(new File(full_file_path));
			int read_len = 0;
			while(!done){
				read_len = inputStream.read(in_buffer);
				if(read_len<=0){
					done = true;
					break;
				}
				fileOutputStream.write(in_buffer, 0, read_len);
			}
			inputStream.close();
			fileOutputStream.close();
			System.out.println(file_name+" done");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
