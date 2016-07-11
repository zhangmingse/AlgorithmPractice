package spider_1;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Random;
import java.util.Scanner;

import org.apache.http.client.HttpClient;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class Spider_1 {

	public static void main(String[] args) {
		try {
			Random random = new Random();
			int page_count = 1;
			String pre_base_url = "http://jandan.net/ooxx/page-";
			String fellow_base_url = "#comments";
			int start_page_number = 2047;
			RequestConfig config = RequestConfig.custom().setCookieSpec(CookieSpecs.STANDARD).build();
			CloseableHttpClient httpClient = HttpClients.custom().setDefaultRequestConfig(config).build();
			StringBuilder stringBuilder = null;

			for (int i = start_page_number; i > (start_page_number - page_count); i--) {
				System.out.println("page:" + i);
				String full_url = pre_base_url + i + fellow_base_url;
				HttpGet httpGet = new HttpGet(full_url);
				httpGet.addHeader("User-Agent",
						"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/42.0.2311.152 Safari/537.36");
				httpGet.addHeader("Cookie",
						"_gat=1; nsfw-click-load=off; gif-click-load=off; bad-click-load=off; _ga=GA1.2.1458040468.1468034472");

				CloseableHttpResponse response = httpClient.execute(httpGet);
				InputStream inputStream = response.getEntity().getContent();
				Scanner scanner = new Scanner(inputStream,"utf-8");
				stringBuilder = new StringBuilder();
				while(scanner.hasNextLine()){
					stringBuilder.append(scanner.nextLine());
				}
				String s = stringBuilder.toString();
//				System.out.println(s);
				new Thread(new PageParser_1(s, i)).start();
				scanner.close();
				inputStream.close();
				Thread.sleep(1000*(random.nextInt(5)+5));
				

			}
		} catch (Exception e) {
			System.out.println("main thread exception: " + e.getMessage());
		}
	}
	
	private String convert_input_to_html(InputStream inputStream){
		BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
		try {
			InputStreamReader inReader = new InputStreamReader(bufferedInputStream,"utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("zm convert Exception:"+ e.getMessage());
			return null;
		}
		
		return null;
	}

}
