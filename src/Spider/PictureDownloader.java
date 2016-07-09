package Spider;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class PictureDownloader implements Runnable{
	private String image_url;
	private int page_number;
	private String basePath = "C:/jiandan";
	public PictureDownloader(String l,int number){
		image_url = l;
		page_number = number;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		File file = new File(basePath);
		if(!file.exists()){
			file.mkdir();
		}
		
		String file_name = image_url.substring(image_url.lastIndexOf("/")+1);
		try{
			file = new File(basePath+"/"+page_number+"_"+file_name);
			FileOutputStream fileOutputStream = new FileOutputStream(file);
			
			URL url = new URL(image_url);
			
			URLConnection uConnection = url.openConnection();
			InputStream inputStream = uConnection.getInputStream();
			byte[] in_buffer = new byte[1024];
			while(true){
				int read_len = inputStream.read(in_buffer);
				if(read_len == -1)
					break;
				fileOutputStream.write(in_buffer, 0, read_len);
			}
			fileOutputStream.close();
			inputStream.close();
			
			
		}catch(Exception e){
			e.printStackTrace();
			file.deleteOnExit();
		}
			
	}
	
	 

}
