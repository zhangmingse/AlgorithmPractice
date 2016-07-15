package spider_7;


public class PageParser_7 implements Runnable {

	private int page_number;
	private String raw_html;
	public PageParser_7(String raw_html,int page_number) {
		// TODO Auto-generated constructor stub
		this.page_number = page_number;
		this.raw_html = raw_html;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try{
			int start_index = 0;
			int end_index = 0;
			start_index = raw_html.indexOf("class=\"commentlist\"");
			end_index = raw_html.indexOf("</ol>");
			if(start_index<0 || end_index < 0 || end_index < start_index){
				System.out.println("may be been found . start_index=" +start_index +" end index = "+end_index );
				return;
			}
			raw_html = raw_html.substring(start_index,end_index);
			String[] post_items_arr = raw_html.split("/li>");
			for(String post_item : post_items_arr){
				String [] image_url_arr = post_item.split("view_img_link\">\\[");
				int image_count = image_url_arr.length-1;
				for(int i = 0;i<image_count;i++){
					start_index = image_url_arr[i].lastIndexOf("http://");
					end_index = image_url_arr[i].lastIndexOf(".jpg")+4;
					if(start_index<0 || end_index < 0 || end_index < start_index){
						System.out.println("error when parse image url . start_index=" +start_index +" end index = "+end_index );
						continue;
					}
					String image_url = image_url_arr[i].substring(start_index,end_index);
					System.out.println("found a picture: " + image_url);
					new Thread(new Picture_downloader_7(page_number, image_url)).start();
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	
}
