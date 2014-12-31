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
	List<VNode> selectedfa = new ArrayList<VNode>();
	List<Integer> temp = new ArrayList<Integer>();
	List<Integer> trtemp = new ArrayList<Integer>();
	 InitialSolution(VNode[] V){

		nodenum = V.length;
		Vn = new VNode[nodenum];
		Vn=V; 							//shallow clone
		for(int i=0;i<nodenum;i++){     //deep clone?
			Vn[i]=V[i];
		}
	}

	 public List<VNode> ResultTree(){
		 tr.add(Vn[0]);
		 tr.get(0).round=timeTides;
		 //option collection
		 while(tr.size()!=nodenum){//��ѯ����tr����Ҷ�ӽ��
			 timeTides++;
			 zr.clear();
			 for(int i=0;i<tr.size();i++){                 //��ѯ����tr�н�������Ҷ�ӽ��
				 	tempV = tr.get(i).first;
					for(int m = tr.get(i).degreeNum-1;m>=0;m--) //��vn�ı߽�����zr
							 {
								 zr.add(tempV.to);
								 tempV = tempV.next;
							 }
						 Set<Integer> tempSet = new HashSet<Integer>(); //zrȥ��
						 tempSet.addAll(zr);
						 zr.clear();
						 zr.addAll(tempSet);
						 if(zr.containsAll(tr))zr.removeAll(tr); //ɾ��zr����tr��Ԫ����ͬ��Ԫ��
				 }
			 
			 father.clear();
			 selected.clear();
			 int z=-1;
			 while(zr.size()!=0){
				 //���ѡ��z   
				 int[] array = new int[zr.size()];
				 for(int t =0;t<zr.size();t++){
					 array[t]=zr.get(t);
				 }
				 int n = array.length-1;
				 int nn=(int)(Math.random()*(n-0)+0);
				 z=array[nn];
				 
				 //����selected�е�ֵ
				 temp.clear();
				 for(int p=0;p<selected.size();p++){
					 temp.add(selected.get(p).from);
				 }
				 
/*				 while(temp!=null&&temp.contains(z)){
					 z=array[((int)(Math.random()*(n-0)+0))];
				 }*/
				 
				 Unduplication ud = new Unduplication(z,tr,selected,Vn);
				 System.out.print("���zֵ"+z+"   ");
				 if(!ud.selection()){
					 //ѡȡz��tr�еĸ��ڵ�
					 tempV=null;
					 
					 for(int k=0;k<tr.size();k++){
						 trtemp.add(tr.get(k).from);
					 }
					 tempV = Vn[z].first;
					while(tempV!=null){
						 if(trtemp.contains(tempV.to)) father.add(tempV.to);
						 tempV = tempV.next;
					 }
					 //ȥ����selected���ڵ���ͬ�ĸ��ڵ�
					 tempV=null;
					 selectedfa.clear();
					 if(selected.size()!=0)tempV=selected.get(0).first;
						 while(tempV!=null){
							selectedfa.add(Vn[tempV.to]);
							tempV=tempV.next;
					 }
					 father.removeAll(selectedfa);
					 //ѡȡz��tr�еĸ��ڵ�
					 if(father.size()!=0){
	
						 int[] arrayfa = new int[father.size()];
						 n=father.size();
						 for(int t=0;t<father.size();t++){
							 arrayfa[t]=father.get(t);
						 }
						 Vn[z].father= arrayfa[(int)(Math.random()*(n-0)+0)];
						
						 selected.add(Vn[z]);
						 System.out.println("selected����"+Vn[z].from+" ");
						 Vn[z].round=timeTides;  //���ʱ�䳱
					 }
				 }
				 if(!zr.isEmpty())zr.remove(nn);
				 else break;
			 }
			 tr.addAll(selected);
		 }
		 return tr;
	 }
}