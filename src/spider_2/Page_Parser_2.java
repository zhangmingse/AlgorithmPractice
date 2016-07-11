package spider_2;

public class Page_Parser_2 implements Runnable {
	
	private String raw_html;
	private int page_number;
	public Page_Parser_2(String raw_html , int page_number) {
		// TODO Auto-generated constructor stub
		this.raw_html = raw_html ;
		this.page_number = page_number;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		int start_index=0;
		int end_index = 0;
		start_index = raw_html.indexOf("class=\"commentlist\"");
		end_index = raw_html.indexOf("</ol>");
		if(start_index<0 || end_index < 0 || end_index < start_index){
			System.out.println("maybe  been found:" + raw_html);
			return;
			}
		raw_html = raw_html.substring(start_index,end_index);
		String[] paragraph = raw_html.split("/li>");
		for(String p_str :paragraph){
			String[] image_arr = p_str.split("view_img_link\">\\[");
			if(image_arr.length<=0)
				continue;
			int count = image_arr.length - 1;
			for(int i = 0;i<count;i++){
				String image_url = image_arr[i];
				start_index = image_url.lastIndexOf("http");
				end_index = image_url.lastIndexOf(".jpg")+4;
				if(start_index<0 || end_index < 0 || end_index < start_index)
					continue;
				image_url = image_url.substring(start_index,end_index);
				System.out.println("find a picture:" + image_url);
				new Thread(new PictureDownloader_2(image_url, page_number)).start();
				
				
			}
		}
	}

}
