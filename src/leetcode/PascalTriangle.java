package leetcode;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
	public static void main(String[] args){
		PascalTriangle pt = new PascalTriangle();
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		list = pt.generate(10);
//		for(int i=0;i<list.size();i++){
//			System.out.println(list.get(i));
//		}
	}
	List<List<Integer>> generate(int numrow){
		List<List<Integer>> Llist = new ArrayList<List<Integer>>();   //List is just an Interface
		int row = 1;
		if(numrow>0){
			while(row<numrow+1){
				List<Integer> list = new ArrayList<Integer>();
				list.add(1);           //the first element
					if(row>1){             //count row
						if(row>2){
							for(int i=0;i<row-2;i++)    //loop count for a row,the third row have i=1 count number.
														//the 4th row have i=4-2 count number
							{
								list.add(Llist.get(row-2).get(i)+Llist.get(row-2).get(i+1));
							}
						}
						list.add(1);       //the last element
					}
				System.out.println(list);
				Llist.add(list);
				row++;
			}
		}
	//		System.out.println(Llist);
		return Llist;
	}
}

