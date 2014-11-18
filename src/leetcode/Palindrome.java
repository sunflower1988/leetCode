package leetcode;

/*time limit exceeded*/

import java.util.ArrayList;

public class Palindrome {
	public static void main(String[] args){
		String s1 = "0k.;r0.k;";
		String ss = s1.toLowerCase();
		char a;
		int m = '`';
		System.out.println(m);
//		String s2 = "race a car";
		ArrayList<Character> alist = new ArrayList<Character>();
		//remove symbol
		for(int i = ss.length()-1;i>=0;i--){
			a=s1.charAt(i);
			if((a>64&&a<91)||(a>96&&a<123)||(a>47&&a<58)){
				alist.add(a); 
			}
		}
		System.out.println(alist);
		int i = alist.size()-1;
		int j=0;
		while(i>=0){
			if(alist.get(i)==alist.get(j)){
				i--;
				j++;
			}
			else{
				System.out.println("This string is not a palindrome.");
				break;
			}
		}
		
	}
	
	
}
