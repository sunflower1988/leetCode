package greedyGrowingTree;
import java.util.*;
//去除数组中重复元素
public class NoDuplicates {
	List<Character> NoD;
	public List<Character> INoDuplicate(List<Character> NoD){
		this.NoD=NoD;
		List<Character> temp = new ArrayList<Character>();
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
	List<Character> l=new ArrayList<Character>();// c={'a','b','c','d','e','f','a','b','c'};
	l.add('a');
	l.add('b');
	l.add('a');
	NoDuplicates N = new NoDuplicates();
	List<Character> b=N.INoDuplicate(l);
	
	for(int i=0;i<b.size();i++)
	System.out.print(b.get(i)+" ");
}
}
