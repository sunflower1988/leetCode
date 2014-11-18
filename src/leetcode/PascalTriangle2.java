package leetcode;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle2 {
	public static void main(String[] args){
		PascalTriangle2 pt2 = new PascalTriangle2();
		List<Integer> list = pt2.getRow(0);
		System.out.println(list);
	}
	public List<Integer> getRow(int rowIndex) {
		List<Integer> tempList = new ArrayList<Integer>();
		List<Integer> nlist = new ArrayList<Integer>();
		if(rowIndex>=0){
			int row = 0;
			while(row<rowIndex+1){
				nlist.clear();
				nlist.add(1);
				if(row>0){
					if(row>1){
						for(int i=0;i<row-1;i++){
							nlist.add(tempList.get(i)+tempList.get(i+1));
						}
					}
					nlist.add(1);
				}
				row++;
				tempList.clear();
				tempList.addAll(nlist);
			}
		}
		return nlist;
	}
}
