package spider_5;

import java.net.InetAddress;

public class PageParser_5 implements Runnable {

	private int page_number;
	private String raw_html;
	public PageParser_5(String raw_html,int page_number) {
		// TODO Auto-generated constructor stub
		this.raw_html = raw_html;
		this.page_number = page_number;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		int start_index = raw_html.indexOf("class=\"commentlist\"");
		int end_index = raw_html.indexOf("</ol>");
		raw_html = raw_html.substring(start_index,end_index);
		String[] post_item_arr = raw_html.split("/li>");
		for(String post_item : post_item_arr){
			String[] image_url_arr = post_item.split("view_img_link\">\\[");
			int image_count = image_url_arr.length-1;
			for(int i = 0;i<image_count;i++){
				String image_url = image_url_arr[i];
				start_index = image_url.lastIndexOf("http");
				end_index = image_url.lastIndexOf(".jpg")+4;
				image_url = image_url.substring(start_index,end_index);
				System.out.println("find picture : " + image_url);
				new Thread(new PictureDownloader_5(image_url, page_number)).start();
			}
		}
		
	}
	

}
