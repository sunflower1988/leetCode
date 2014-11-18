package leetcode;

import java.math.BigInteger;

public class AddBinary2 {
	public static void main(String[] args){
		String a ="111";
		String b = "1";
		BigInteger srca = new BigInteger(a,2);
		BigInteger srcb = new BigInteger(b,2);
		System.out.println(srca.add(srcb).toString(2));
		
	}
}
