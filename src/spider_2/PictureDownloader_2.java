package spider_2;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

public class PictureDownloader_2 implements Runnable {

	private String url;
	private int page_number;
	private String pre_base_path = "c:/jiandan";

	public PictureDownloader_2(String url, int page_number) {
		// TODO Auto-generated constructor stub
		this.url = url;
		this.page_number = page_number;

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			File dir = new File(pre_base_path);
			if (!dir.exists()) {
				dir.mkdir();
			}
			int start_index = url.lastIndexOf("/")+1;
			int end_index = url.lastIndexOf(".jpg") + 4;
			String file_name = url.substring(start_index, end_index);
			File file = new File(pre_base_path + "/" + page_number + "- " + file_name);
			URL image_url = new URL(url);
			URLConnection uConnection = image_url.openConnection();
			InputStream inputStream = uConnection.getInputStream();
			byte[] in_buffer = new byte[1024*512];
			int read_len = 0;
			OutputStream outputStream = new FileOutputStream(file);
			while(true){
				read_len = inputStream.read(in_buffer);
				if(read_len<=0)
					break;
				
				outputStream.write(in_buffer, 0, read_len);
				
			}
			outputStream.close();
			inputStream.close();
			System.out.println(file_name+" download complite!");
			

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
