package dataAggregation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/*
 * The result is a tree.
 */

public class InitialSolution {
	int nodenum;
	VNode[] Vn;
	Edge tempV;
	int timeTides=1;
	List<VNode> tr = new ArrayList<VNode>();
	List<Integer> zr = new ArrayList<Integer>();
	List<Integer> father = new ArrayList<Integer>();
	List<VNode> selected = new ArrayList<VNode>();
	List<Integer> temp = new ArrayList<Integer>();
	List<Integer> trtemp = new ArrayList<Integer>();
	 InitialSolution(VNode[] V){

		nodenum = V.length;
		Vn = new VNode[nodenum];
		Vn=V; 							//shallow clone
	}

	 public List<VNode> ResultTree(){
		 tr.add(Vn[0]);
		 tr.get(0).round=timeTides;
		 //option collection
		 while(tr.size()!=nodenum){//查询所有tr结点的叶子结点
			 timeTides++;
			 zr.clear();
			 for(int i=0;i<tr.size();i++){                 //查询现有tr中结点的所有叶子结点
				 	tempV = tr.get(i).first;
				 	trtemp.clear();
				 	 for(int k=0;k<tr.size();k++){
						 trtemp.add(tr.get(k).from);
					 }
					while(tempV!=null) //将vn的边结点放入zr
							 {
								 if(!trtemp.contains(tempV.to))zr.add(tempV.to);
								 tempV = tempV.next;
							 }
						 Set<Integer> tempSet = new HashSet<Integer>(); //zr去重
						 tempSet.addAll(zr);
						 zr.clear();
						 zr.addAll(tempSet);
						 if(zr.containsAll(tr))zr.removeAll(tr); //删除zr中与tr中元素相同的元素
				 }
			 
			 father.clear();
			 selected.clear();
			 int z=-1;
			 while(zr.size()!=0){
				 //随机选择z    
				 int[] array = new int[zr.size()];
				 for(int t =0;t<zr.size();t++){
					 array[t]=zr.get(t);
				 }
				 int n = array.length-1;
				 int nn=(int)(Math.random()*(n-0)+0);
				 z=array[nn];
				 
				 //查找selected中的值
				 temp.clear();
				 for(int p=0;p<selected.size();p++){
					 temp.add(selected.get(p).from);
				 }				 
				 Unduplication ud = new Unduplication(z,tr,selected,Vn);
				 System.out.print("选择"+z+"   ");
				 if(!ud.selection()){
					 //选取z在tr中的父节点
					 tempV=null;
					 trtemp.clear();
					 for(int k=0;k<tr.size();k++){
						 trtemp.add(tr.get(k).from);
					 }
					 tempV = Vn[z].first;
					 father.clear();
					 while(tempV!=null){
						 if(trtemp.contains(tempV.to)) father.add(tempV.to);
						 tempV = tempV.next;
					 }
						 int[] arrayfa = new int[father.size()];
						 n=father.size();
						 for(int t=0;t<father.size();t++){
							 arrayfa[t]=father.get(t);
						 }
						 Vn[z].father= arrayfa[(int)(Math.random()*(n-0)+0)];
						
						 selected.add(Vn[z]);
						 System.out.println("selected添加"+Vn[z].from+" ");
						 Vn[z].round=timeTides;  //标记时间潮
				 }
				 if(!zr.isEmpty())zr.remove(nn);
				 else break;
			 }
			 tr.addAll(selected);
		 }
		 return tr;
	 }
}