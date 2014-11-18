package leetcode;

import java.math.BigInteger;

public class PlusOne {
	public static void main(String[] args){
		int[] digits = {1,2,3,4,5};
		PlusOne p = new PlusOne();
		int[] re = p.plusOne(digits);
		for(int i=0;i<re.length;i++){
			System.out.print(re[i]+" ");
		}
	}
	int[] plusOne(int[] digits) {   //array can not be convert to string directly
//		System.out.println(digits.length);
		
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<digits.length;i++){
			sb.append(digits[i]);
		}
		String s = new String(sb);
//		System.out.println(s);
        BigInteger b = new BigInteger(s,10);
        BigInteger one = new BigInteger("1",10);
        BigInteger sum = new BigInteger(b.add(one).toString(),10);
        int[] ii=new int[sum.toString().length()];   //always forget initial the array!!!
//      System.out.println(sum.toString().length());
        for(int i=0;i<sum.toString().length();i++)
        {
        	ii[i]=Character.digit(sum.toString().charAt(i),10);
        }
        return ii;
    }
}
