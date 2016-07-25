package spider_8;

public class PageParser_8 implements Runnable{

	int page_number;
	String raw_html;
	public PageParser_8(int page_number,String raw_html) {
		// TODO Auto-generated constructor stub
		this.page_number = page_number;
		this.raw_html = raw_html;
		
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			int start_index = 0;
			int end_index = 0;
			start_index = raw_html.indexOf("class=\"commentlist\"");
			end_index = raw_html.indexOf("</ol>");
			if(start_index<=0 || end_index<=0 || end_index<= start_index)
				return;
			raw_html = raw_html.substring(start_index,end_index);
			String[] post_arr = raw_html.split("/li>");
			for(String post_item : post_arr){
				String[] image_url_arr = post_item.split("view_img_link\">\\[");
				int image_count = image_url_arr.length-1;
				for(int i = 0;i<image_count;i++){
					String image_url_str = image_url_arr[i];
					start_index = image_url_str.lastIndexOf("http://");
					end_index = image_url_str.lastIndexOf(".jpg")+4;
					if(start_index<=0 || end_index<=0 || end_index<= start_index)
						continue;
					image_url_str = image_url_str.substring(start_index,end_index);
					System.out.println("found : " +image_url_str);
					new Thread(new PictureDownloader_8(page_number, image_url_str)).start();
				}
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	
}
