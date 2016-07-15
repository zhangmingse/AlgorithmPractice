package spider_6;

import java.util.Random;
import java.util.Scanner;

import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class Spider_6 {
	public static void main(String[] args) {
		try {
			String pre_url = "http://jandan.net/ooxx/page-";
			int start_page_number = 2048;
			Random random = new Random();
			int page_count = 4;
			String follow_url = "#comments";
			RequestConfig config = RequestConfig.custom().setCookieSpec(CookieSpecs.STANDARD).build();
			CloseableHttpClient httpClient = HttpClients.custom().setDefaultRequestConfig(config).build();
			for (int i = start_page_number; i > start_page_number - page_count; i--) {
				System.out.println("parsing page " + i);
				String full_url = pre_url + i + follow_url;
				HttpGet httpGet = new HttpGet(full_url);
				httpGet.addHeader("User-Agent",
						"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/42.0.2311.152 Safari/537.36");
				httpGet.addHeader("Cookie",
						"_gat=1; nsfw-click-load=off; gif-click-load=off; bad-click-load=off; _ga=GA1.2.1458040468.1468034472 ; ");
				
				CloseableHttpResponse response = httpClient.execute(httpGet);
				Scanner scanner = new Scanner(response.getEntity().getContent(),"utf-8");
				StringBuilder sBuilder = new StringBuilder();
				
				while(scanner.hasNextLine()){
					sBuilder.append(scanner.nextLine());
					
				}
				scanner.close();
				new Thread(new Page_parser_6(i,sBuilder.toString())).start();
				Thread.sleep(1000*(5+random.nextInt(5)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
