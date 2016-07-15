package spider_7;

import java.io.InputStream;
import java.util.Random;
import java.util.Scanner;

import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class Spider_7 {

	public static void main(String[] args) {
		try {
			String pre_url = "http://jandan.net/ooxx/page-";
			String fellow_url = "#comments";
			int start_page_number = 2055;
			int page_count = 4;
			Random random = new Random();

			for (int i = start_page_number; i > start_page_number - page_count; i--) {
				String full_url = pre_url + i + fellow_url;
				RequestConfig config = RequestConfig.custom().setCookieSpec(CookieSpecs.STANDARD).build();
				CloseableHttpClient httpClient = HttpClients.custom().setDefaultRequestConfig(config).build();
				HttpGet httpGet = new HttpGet(full_url);

				httpGet.addHeader("User-Agent",
						"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/42.0.2311.152 Safari/537.36");
				httpGet.addHeader("Cookie",
						"_gat=1; nsfw-click-load=off; gif-click-load=off; bad-click-load=off; _ga=GA1.2.1458040468.1468034472 ; ");
				
				CloseableHttpResponse response = httpClient.execute(httpGet);
				InputStream inputStream = response.getEntity().getContent();
				Scanner scanner = new Scanner(inputStream,"utf-8");
				StringBuilder sBuilder = new StringBuilder();
				while(scanner.hasNextLine()){
					sBuilder.append(scanner.nextLine());
				}
				scanner.close();
				new Thread(new PageParser_7(sBuilder.toString(), i)).start();
				Thread.sleep(1000*(5+ random.nextInt(5)));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
