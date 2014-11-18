package leetcode;

import java.util.ArrayList;

public class AddBinary {
	public static void main(String[] args){
		String a = "111";
		String b="1";
		AddBinary addB = new AddBinary();
		String res = addB.sumResult(a,b);
		System.out.println(res);
	}
	String sumResult(String a,String b){
		int aa = Integer.parseInt(a);   //转换为整型
		int bb = Integer.parseInt(b);	
		int cc = aa+bb;	
		int temp = 0;
		String r = Integer.toString(cc);
		ArrayList<Integer> list = new ArrayList<Integer>(); //对象
		for(int i=r.length()-1;i>-1;i--){
			int abit = Character.getNumericValue(r.charAt(i));
			abit = abit+temp;
			if(abit==2)
				{
					list.add(0);
					temp = 1;
				}
			else if(abit==3){
					list.add(1);
					temp = 1;
				}
			else if(abit==1)
			{
				list.add(1);
				temp = 0;
			}
			else 
			{
				list.add(0);
				temp = 0;
			}
		}
		if(temp!=0)list.add(temp);
		return list.toString();
	}
	
}
