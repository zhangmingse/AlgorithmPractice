package spider_1;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class Picture_DownLoader_1 implements Runnable {

	private int page_number;
	private String url;
	private String basePath = "c:/jiandan";
	public Picture_DownLoader_1(String url,int page_number) {
		// TODO Auto-generated constructor stub
		this.url = url;
		this.page_number = page_number;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try{
			String file_name = url.substring(url.lastIndexOf("/")+1);
			File dir = new File(basePath);
			if(!dir.exists()){
				dir.mkdir();
			}
			URL image_url = new URL(url);
			URLConnection uConnection = image_url.openConnection();
			InputStream inputStream = uConnection.getInputStream();
			byte[] in_buffer = new byte[1024*512];
			int read_len = 0;
			File file = new File(basePath+"/"+page_number+"-p"+file_name);
			FileOutputStream fileOutputStream = new FileOutputStream(file);
			while(true){
				read_len = inputStream.read(in_buffer);
				if(read_len<=0){
					break;
				}
				fileOutputStream.write(in_buffer, 0, read_len);	
			}
			fileOutputStream.close();
			inputStream.close();
			System.out.println("image " + url + " download complite!");
			
		}catch(Exception e){
			System.out.println("Thread "+Thread.currentThread().getId()+" Exception:"+e.getMessage());
		}

		
	}

}
