package Spider;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

import javax.rmi.CORBA.Util;
import javax.swing.text.Utilities;

import org.apache.http.client.HttpClient;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIUtils;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class SimpleSpider {
	private static int page_count = 5;
	private static CloseableHttpClient httpClient;
	
	public static void main(String[] args){
		RequestConfig config = RequestConfig.custom().
				setCookieSpec(CookieSpecs.STANDARD).
				setConnectionRequestTimeout(6000).
				setConnectTimeout(6000).
				build();
		
		
		httpClient = HttpClients.custom().setDefaultRequestConfig(config).build();
		
		for(int i = 2035;i>(2035-page_count);i--){
			

			try {
				HttpGet httpGet = new HttpGet("http://jandan.net/ooxx/page-" + i +"#comments");
				httpGet.addHeader("User-Agent","Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/42.0.2311.152 Safari/537.36");
	            httpGet.addHeader("Cookie","_gat=1; nsfw-click-load=off; gif-click-load=off; bad-click-load=off; _ga=GA1.2.1458040468.1468034472");
				Thread.sleep(5000);
				System.out.println("page number " + i);
				CloseableHttpResponse response = httpClient.execute(httpGet);
				InputStream inputStream = response.getEntity().getContent();
				String html = convertToHtml(inputStream);
				new Thread(new HtmlParser_Picture_url(html, i)).start();
				inputStream.close();
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
	
	private static String convertToHtml(InputStream io){
		InputStreamReader inReader = null;
		try {
			inReader = new InputStreamReader(io,"UTF-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		BufferedReader bufferedReader = new BufferedReader(inReader);
		
		String line = null;
		StringBuilder sBuilder = new StringBuilder();
		try {
			while((line = bufferedReader.readLine())!=null){
				sBuilder.append(line);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sBuilder.toString();
	}

}
