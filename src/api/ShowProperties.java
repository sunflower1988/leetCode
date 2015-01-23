package api;

import java.util.Date;

public class ShowProperties {
	int a;
	char b;
	public static void main(String[] args){
		System.out.println(new Date());
		System.getProperties().list(System.out);
		System.out.println(System.getProperty("user.name"));
		System.out.println(System.getProperty("java.library.path"));
		System.out.println(new Date());
		ShowProperties sp = new ShowProperties();
		sp.printf();
	}
	void printf(){
		System.out.println(a);
		System.out.println(b);
	}
}
