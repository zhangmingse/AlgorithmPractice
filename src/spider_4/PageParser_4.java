package spider_4;

public class PageParser_4 implements Runnable {

	private String raw_html;
	private int page_number;
	public PageParser_4(String raw_html,int page_number) {
		// TODO Auto-generated constructor stub
		this.raw_html = raw_html;
		this.page_number = page_number;
	}
	@Override
	public void run() {
		
		// TODO Auto-generated method stub
		int start_index = 0;
		int end_index = 0;
		start_index = raw_html.indexOf("class=\"commentlist\"");
		end_index = raw_html.indexOf("</ol>");
		if(start_index <= -1 || end_index <=-1 || end_index<start_index)
			return;
		
		raw_html = raw_html.substring(start_index,end_index);
		String[] post_item_arr = raw_html.split("/li>");
		for(String post_item:post_item_arr){
			String[] image_url_arr = post_item.split("view_img_link\">\\[");
			int image_count = image_url_arr.length - 1;
			for(int i = 0;i<image_count;i++){
				String image_url = image_url_arr[i];
				start_index = image_url.lastIndexOf("http");
				end_index = image_url.lastIndexOf(".jpg")+4;
				if(start_index<=-1 || end_index<=-1|| end_index<start_index)
					continue;
				image_url = image_url.substring(start_index,end_index);
				new Thread(new Picture_downloader_4(image_url, page_number)).start();
				System.out.println("find image : " + image_url);
			}
		}
		
	}

	
}
