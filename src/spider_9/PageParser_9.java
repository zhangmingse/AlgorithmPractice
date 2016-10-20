package spider_9;

public class PageParser_9 implements Runnable {

	private int page_number;
	private String content;
	public PageParser_9(String _content,int _page_number) {
		// TODO Auto-generated constructor stub
		content = _content;
		page_number = _page_number;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		int start = 0;
		int end = 0;
		int middle = 0;
		start = content.indexOf("class=\"commentlist\"");
		end = content.indexOf("class=\"comments\"", content.indexOf("class=\"comments\"")+1);
		content = content.substring(start,end);
		String list[] = content.split("</li>");
		for(String item : list){
			middle = item.indexOf("/large/");
			if(middle<=0)
				continue;
			start = item.lastIndexOf("http://", middle);
			end = item.indexOf(".jpg",middle) + 4;
			if(start>0 && end>start){
				String url = item.substring(start,end);
				System.out.println(page_number+" ======>"+url);
				new Thread(new PictureDownloader_9_1(url, page_number)).start();
			}
		}
		
	}

	
	
}
