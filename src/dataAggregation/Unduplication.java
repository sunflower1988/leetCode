package dataAggregation;
/*
 * 冲突判断：
 * 若Z节点可到达已选节点的任意父节点，则该节点不能被选择，返回冲突
 */
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
			if(temp.contains(e.to))zfathers.add(e.to);
			e=e.next;	
		}
		//z在tr中可选的father放入zfathers中
		if(!selected.isEmpty())
		{
			for(int i=0;i<selected.size();i++){
				e=selected.get(i).first;
				while(e!=null){
					if(temp.contains(e.to))selectedfa.add(e.to);
					e=e.next;
				}
			}
			//若Z节点可到达selected的任意父节点，则该节点不能被选择
			for(int i=0;i<selectedfa.size();i++){
				if(zfathers.contains(selectedfa.get(i)))
					return true;
			}
		}
        //false为不冲突
		return false;
	}
}
