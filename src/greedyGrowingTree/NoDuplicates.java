package greedyGrowingTree;
import java.util.*;
//ȥ���������ظ�Ԫ��
public class NoDuplicates {
	List<Integer> NoD;
	public List<Integer> INoDuplicate(List<Integer> NoD){
		this.NoD=NoD;
		List<Integer> temp = new ArrayList<Integer>();
//		System.out.println(NoD.size);
		temp.add(NoD.get(0));
		for(int i=1;i<NoD.size();i++){
			int j=0;
				while(NoD.get(i)!=temp.get(j)&&j<temp.size()-1){
					j++;
				}
				if(j==temp.size()-1){
					temp.add(NoD.get(i));
				}
			}
		return temp;
		}
public static void main(String[] args){
//	test	go awawy Duplicates
	List<Integer> l=new ArrayList<Integer>();// c={'a','b','c','d','e','f','a','b','c'};
	l.add(1);
	l.add(2);
	l.add(1);
	NoDuplicates N = new NoDuplicates();
	List<Integer> b=N.INoDuplicate(l);
	
	for(int i=0;i<b.size();i++)
	System.out.print(b.get(i)+" ");
}
}
