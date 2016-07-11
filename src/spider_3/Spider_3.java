package spider_3;

import java.io.InputStream;
import java.util.Random;
import java.util.Scanner;

import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class Spider_3 {
	public static void main(String[] args) {
		try {
			String pre_url = "http://jandan.net/ooxx/page-";
			int start_page_number = 2048;
			int page_count = 4;
			RequestConfig config = RequestConfig.custom().setCookieSpec(CookieSpecs.STANDARD).build();
			CloseableHttpClient httpClient = HttpClients.custom().setDefaultRequestConfig(config).build();
			Random random = new Random();

			for (int i = start_page_number; i > start_page_number - page_count; i--) {
				System.out.println("page number : " + i);
				String full_url = pre_url + i + "#comments";
				HttpGet httpGet = new HttpGet(full_url);
				httpGet.addHeader("User-Agent",
						"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/42.0.2311.152 Safari/537.36");
				httpGet.addHeader("Cookie",
						"_gat=1; nsfw-click-load=off; gif-click-load=off; bad-click-load=off; _ga=GA1.2.1458040468.1468034472 ; 66a5S%2FJClC%2FvUyhzcLara6xR3gwfqtQk6r5tb%2FyM5Q	");

				CloseableHttpResponse response = httpClient.execute(httpGet);
				InputStream inputStream = response.getEntity().getContent();
				Scanner scanner = new Scanner(inputStream,"utf-8");
				StringBuilder sBuilder = new StringBuilder();
				while(scanner.hasNextLine()){
					sBuilder.append(scanner.nextLine());
				}
				new Thread(new Page_parser_3(sBuilder.toString(), i)).start();
				scanner.close();
				Thread.sleep(1000*(5+random.nextInt(5)));
				

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
