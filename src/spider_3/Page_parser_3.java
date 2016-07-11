package spider_3;

public class Page_parser_3 implements Runnable {

	private int page_number;
	private String raw_html;
	public Page_parser_3(String raw_html,int page_number) {
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
		if(start_index == -1 || end_index==-1 || end_index<start_index){
			System.out.println("maybe been found");
			return;
		}
		raw_html = raw_html.substring(start_index,end_index);
		String[] post_item_content = raw_html.split("/li>");
		if(post_item_content.length<=0)
			return;
		for(String poString : post_item_content){
			String[] image_arr_url = poString.split("view_img_link\">\\[");
			if(image_arr_url.length<=0)
				continue;
			int image_arr_length = image_arr_url.length ;
			for(int i = 0;i<image_arr_length - 1;i++){
				String image_url = image_arr_url[i];
				start_index = image_url.lastIndexOf("http");
				end_index = image_url.lastIndexOf(".jpg")+4;
				if(start_index<0 || end_index <0 || end_index<start_index)
					continue;
				image_url = image_url.substring(start_index, end_index);
				System.out.println("find a picture:" + image_url);
				new Thread(new Picture_downloader_3(image_url, page_number)).start();
			}
		}
		
		
		
	}
	
}
