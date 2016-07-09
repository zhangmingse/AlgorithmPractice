package Spider;

import java.util.ArrayList;
import java.util.List;

public class HtmlParser_Picture_url implements Runnable {
	private String html_raw_str;
	private int page_number;
	private List<String> down_load_list;
	public HtmlParser_Picture_url(String s,int num){
		html_raw_str  = s;
		page_number = num;
		down_load_list = new ArrayList<>();
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try{
		html_raw_str = html_raw_str.substring(html_raw_str.indexOf("commentlist"));
		String[] images = html_raw_str.split("li>");
		for(String str_item : images){
			try{
			String str_1 = str_item.substring(str_item.indexOf("<img src=\""));
			int start_index = str_1.indexOf("http");
			int end_index = str_1.indexOf(".jpg")+4;
			str_1 = str_1.substring(start_index, end_index);
			str_1 = str_1.replace("mw600", "large");
			new Thread(new PictureDownloader(str_1, page_number)).start();
			}catch(IndexOutOfBoundsException e){
				System.out.println("index out of bound exception : "+str_item);
			}
			
		}
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("maybe be found:"+html_raw_str);
		}
		
		
	}
	
	

}
