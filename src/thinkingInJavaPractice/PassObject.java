package thinkingInJavaPractice;


class Letter{
	char c;
}
public class PassObject {
	static void f(Letter y){    
		y.c = 'a';
		System.out.println("y.c = "+y.c);
	}
	public static void main(String[] args){
		Letter x = new Letter();
		x.c ='z';
		System.out.println("1: x.c = "+x.c);
		f(x);
		System.out.println("2: x.c = "+x.c);
		f(x);
		
	}
}
