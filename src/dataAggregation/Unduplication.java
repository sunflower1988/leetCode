package dataAggregation;

import java.util.ArrayList;
import java.util.List;

public class Unduplication {
	int z;
	List<VNode> tr = new ArrayList<VNode>();
	List<VNode> selected = new ArrayList<VNode>();
	List<Integer> zfathers = new ArrayList<Integer>();
	List<Integer> selectedfa = new ArrayList<Integer>();
	List<Integer> temp = new ArrayList<Integer>();
	VNode[] v;
	Unduplication(int z,List<VNode> tr,List<VNode> selected,VNode[] Vn){
		this.z = z;
		this.tr=tr;
		this.selected=selected;
		this.v = Vn;
	}
	public boolean selection(){
		Edge e;
		for(int i=0;i<tr.size();i++){
			temp.add(tr.get(i).from);
		}
		e =  v[z].first;
		while(e!=null){
			if(temp.contains(zfathers))zfathers.add(e.to);
			e=e.next;	
		}
//		if(zfathers.containsAll(selected))return true;
		//与已选集的父节点集无干扰的z的父节点集合zfathers
		if(!selected.isEmpty())
		{
			e=selected.get(0).first;
			while(e!=null){
				selectedfa.add(e.to);
				e=e.next;
				}
		
		if(zfathers.contains(selectedfa)){
			zfathers.removeAll(selectedfa);
			if(zfathers.size()!=0)
				return false;
			else return true;
		}
		}
		//z的父节点与已选集无干扰
		return false;
		
		
	}
}
