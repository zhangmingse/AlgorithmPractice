package spider_9;

import java.util.Random;
import java.util.Scanner;

import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class Spider_9 {

	public static void main(String args[]) {
		Random random = new Random();
		int start_page_number = 2174;
		int page_count = 5;
		int end_page_number = start_page_number - page_count;
		String url = "http://jandan.net/ooxx/page-";
		
		try {
			for(int i = start_page_number;i>end_page_number;i--){
				String cString = url + i + "#comments";
				System.out.println("parsing : "  + cString);
				
				RequestConfig config = RequestConfig.custom().setCookieSpec(CookieSpecs.STANDARD).build();
				
				HttpGet httpGet = new HttpGet(cString);
				httpGet.addHeader("User-Agent",
						"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/42.0.2311.152 Safari/537.36");
				httpGet.addHeader("Cookie",
						"_gat=1; nsfw-click-load=off; gif-click-load=off; bad-click-load=off; _ga=GA1.2.1458040468.1468034472 ; ");
				
				
				CloseableHttpClient httpClient = HttpClients.custom().setDefaultRequestConfig(config).build();
				CloseableHttpResponse response = httpClient.execute(httpGet);
				StringBuilder builder = new StringBuilder();
				Scanner scanner = new Scanner(response.getEntity().getContent(),"utf-8");
				while(scanner.hasNextLine()){
					builder.append(scanner.nextLine());
				}
				scanner.close();
				
				
				PageParser_9_1 parser_9 = new PageParser_9_1(builder.toString(), i);
				new Thread(parser_9).start();
				
				
				int time_span = (3+random.nextInt(7)) * 1000;
				Thread.sleep(time_span);
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(e.getMessage());
		}

	}
}
