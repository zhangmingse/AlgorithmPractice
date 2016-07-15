package spider_5;

import java.util.Random;
import java.util.Scanner;

import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class Spider_5 {
	public static void main(String[] args){
		try{
		String pre_url = "http://jandan.net/ooxx/page-";
		int start_page_index = 2048;
		int page_count =4;
		Random random = new Random();
		String fellow_url = "#comments";
		RequestConfig config = RequestConfig.custom().setCookieSpec(CookieSpecs.STANDARD).build();
		CloseableHttpClient httpClient = HttpClients.custom().setDefaultRequestConfig(config).build();
		for(int i = start_page_index;i>start_page_index-page_count;i--){
			System.out.println("parsing page " + i);
			HttpGet httpGet = new HttpGet(pre_url+i+fellow_url);
			httpGet.addHeader("User-Agent",
					"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/42.0.2311.152 Safari/537.36");
			httpGet.addHeader("Cookie",
					"_gat=1; nsfw-click-load=off; gif-click-load=off; bad-click-load=off; _ga=GA1.2.1458040468.1468034472 ; ");
			
			CloseableHttpResponse response = httpClient.execute(httpGet);
			
			StringBuilder sBuilder = new StringBuilder();
			Scanner scanner = new Scanner(response.getEntity().getContent(),"utf-8");
			while(scanner.hasNextLine()){
				sBuilder.append(scanner.nextLine());
			}
			new Thread(new PageParser_5(sBuilder.toString(), i)).start();
			scanner.close();
			Thread.sleep(1000*(5+random.nextInt(5)));
			
		}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
