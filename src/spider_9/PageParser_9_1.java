package spider_9;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PageParser_9_1 implements Runnable{

	String content;
	int page_number;
	public PageParser_9_1(String _content,int _number) {
		// TODO Auto-generated constructor stub
		content = _content;
		page_number = _number;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("parsing........");
		Pattern pattern = Pattern.compile("(http)(\\S+?)(large)(\\S+?)(\\.jpg)");
		Matcher matcher = pattern.matcher(content);
		while(matcher.find()){
			String url = matcher.group();
			System.out.println(page_number+" ===>" + url);
			new Thread(new PictureDownloader_9_1(url, page_number)).start();
//			Spider_9.pool.submit(new PictureDownloader_9_1(url, page_number));
		}
		
	}

	
}
