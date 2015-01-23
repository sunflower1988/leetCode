package api;
import java.math.BigInteger;

public class BigIntegerTest {
	public static void main(String[] args){
		int a = 1111111111;                 //2147483648L  Math.pow(2,31)
		BigInteger bi = new BigInteger("33333333333333333333333333333");
		System.out.println(bi.add(bi));
		System.out.println(bi.pow(a));
		
		
	}
}
