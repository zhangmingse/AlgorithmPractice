package spider_2;

import java.util.Random;
import java.util.Scanner;

import org.apache.http.Header;
import org.apache.http.HttpHeaders;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class Spider_2 {
	public static void main(String[] args) {

		try {
			String pre_base_path = "http://jandan.net/ooxx/page-";
			String fellow_path = "#comments";
			int start_page_number = 2048;
			int page_count = 4;
			Random random = new Random();
			String cookie = null;
			for (int i = start_page_number; i > start_page_number - page_count; i--) {
				String url = pre_base_path + i + fellow_path;
				RequestConfig config = RequestConfig.custom().setCookieSpec(CookieSpecs.STANDARD).build();
				CloseableHttpClient httpClient = HttpClients.custom().setDefaultRequestConfig(config).build();

				HttpGet httpGet = new HttpGet(url);
				httpGet.addHeader("User-Agent",
						"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/42.0.2311.152 Safari/537.36");
				// if(cookie!=null)
				// httpGet.addHeader("Cookie",cookie);
				httpGet.addHeader("Cookie",
						"_gat=1; nsfw-click-load=off; gif-click-load=off; bad-click-load=off; _ga=GA1.2.1458040468.1468034472 ; 66a5S%2FJClC%2FvUyhzcLara6xR3gwfqtQk6r5tb%2FyM5Q	");

				CloseableHttpResponse response = httpClient.execute(httpGet);

				Header headers = response.getFirstHeader("Set-Cookie");
				if (headers != null)
					cookie = headers.getValue();
				Scanner scanner = new Scanner(response.getEntity().getContent(), "utf-8");
				StringBuilder sBuilder = new StringBuilder();
				while (scanner.hasNextLine()) {
					sBuilder.append(scanner.nextLine());
				}
				new Thread(new Page_Parser_2(sBuilder.toString(), i)).start();
				scanner.close();
				System.out.println("page number:" + i);
				Thread.sleep(1000 * (5 + random.nextInt(5)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
