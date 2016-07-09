package other;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class InetAddressTest {

	public static void main(String[] args){
		System.out.println("pleast input inetaddress");
		Scanner scanner =  new Scanner(System.in);
		String s = scanner.nextLine();
		if(s==null || s.equals("")){
			try {
				InetAddress inetAddress = InetAddress.getLocalHost();
				System.out.println(inetAddress);
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else{
			try {
				InetAddress[] address_list = InetAddress.getAllByName(s);
				for(InetAddress a :address_list){
					System.out.println(a);
				}
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		System.out.println("done");
	}
}
