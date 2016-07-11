package spider_1;

public class PageParser_1 implements Runnable {

	private String raw_html;
	private int page_number;

	public PageParser_1(String raw_html, int page_number) {
		// TODO Auto-generated constructor stub
		this.raw_html = raw_html;
		this.page_number = page_number;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try{
			int start_index = raw_html.indexOf("class=\"commentlist\"");
			int end_index = raw_html.indexOf("</ol>");
			raw_html = raw_html.substring(start_index,end_index);
			String[] raw_html_arr = raw_html.split("</li>");
			for(String str_item : raw_html_arr){
//				System.out.println(str_item);
				String[] image_url_arr = str_item.split(">\\[");
//				System.out.println(image_url_arr[0]);
				String image_item_url;
				for(int i = 0;i<image_url_arr.length-1;i++){
					image_item_url = image_url_arr[i];
					start_index = image_item_url.lastIndexOf("http://");
					end_index = image_item_url.lastIndexOf(".jpg");
					if(start_index==-1 || end_index ==-1)
						continue;
					image_item_url = image_item_url.substring(start_index,end_index+4);
					System.out.println("find image : " + image_item_url);
					new Thread(new Picture_DownLoader_1(image_item_url, page_number)).start();
				}
			}
		}catch(Exception e){
			System.out.println("Thread-"+Thread.currentThread().getId()+" Exception :" +e.getMessage());
		}
		
	}

}
